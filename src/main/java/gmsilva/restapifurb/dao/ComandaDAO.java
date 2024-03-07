package gmsilva.restapifurb.dao;

import gmsilva.restapifurb.dto.comanda.Comanda;
import gmsilva.restapifurb.dto.comanda.ComandaRepository;
import gmsilva.restapifurb.dto.comanda.DadosCadastroComanda;
import gmsilva.restapifurb.dto.comandaProduto.ComandaProduto;
import gmsilva.restapifurb.dto.comandaProduto.ComandaProdutoRepository;
import gmsilva.restapifurb.dto.produto.DadosCadastroProduto;
import gmsilva.restapifurb.dto.produto.Produto;
import gmsilva.restapifurb.dto.produto.ProdutoAtualizacaoBody;
import gmsilva.restapifurb.dto.produto.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class ComandaDAO {
    @Autowired
    private ComandaRepository comandaRepo;
    @Autowired
    private ComandaProdutoRepository comandaProdutoRepo;
    @Autowired
    private ProdutoRepository produtoRepo;


    public ResponseEntity cadastrarComanda(DadosCadastroComanda dadosCadastroComanda) {
        System.out.println(dadosCadastroComanda);

        for (DadosCadastroProduto dadosCadastroProduto :  dadosCadastroComanda.produtos()){
            Produto produto = produtoRepo.findByNome(dadosCadastroProduto.nome());
            if (produto == null || (produto.getPreco().compareTo(dadosCadastroProduto.preco()) != 0))  {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", "Produto invalido",                         "message", "O produto com nome '" + dadosCadastroProduto.nome() + "' não foi encontrado."));
            }
        }

       Comanda comanda = new Comanda(dadosCadastroComanda);
        comandaRepo.save(comanda);
        for (DadosCadastroProduto dadosCadastroProduto :  dadosCadastroComanda.produtos()){

            ComandaProduto comandaProduto = new ComandaProduto(comanda,produtoRepo.findByNome(dadosCadastroProduto.nome()));

            comandaProdutoRepo.save(comandaProduto);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(comanda);
    }

    public ResponseEntity obterTodasComandas() {
        List<Comanda> comandas = comandaRepo.findAll();

        if (comandas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", "Nenhuma comanda encontrada", "message", "Não há comandas cadastradas no momento."));
        }

        return ResponseEntity.ok(comandas);
    }


    public ResponseEntity obterComanda(Long id) {
        Optional<Object[]> result = comandaRepo.findByIdWithProdutos(id);

        if (result.isPresent()) {
            Comanda comanda = Comanda.fromResultSet(result.get());
            return ResponseEntity.ok(comanda);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", "Comanda não encontrada", "message", "A comanda com o ID '" + id + "' não foi encontrada."));
        }
    }


    public ResponseEntity deletarComanda(Long id) {
        if (comandaRepo.existsById(id)) {
            comandaRepo.deleteById(id);
            return ResponseEntity.ok().body(Map.of("success", Map.of("text", "comanda removida")));
        } else {
            return ResponseEntity.status(404).body(Map.of("error", Map.of("text", "Comanda não encontrada")));
        }
    }


    public ResponseEntity atualizarComanda(Long id, ProdutoAtualizacaoBody body) {
        Optional<Comanda> optionalComanda = comandaRepo.findById(id);

        if (optionalComanda.isEmpty()) {
            return  ResponseEntity.status(400).body(Map.of("error", Map.of("text", "Comanda não encontrada")));
        }

        Comanda comanda = optionalComanda.get();

        for (DadosCadastroProduto dadosCadastroProduto : body.produtos()) {
            Produto produtoExistente = produtoRepo.findByNome(dadosCadastroProduto.nome());

            if (produtoExistente != null) {
                ComandaProduto comandaProduto = new ComandaProduto(comanda, produtoExistente);
                comandaProdutoRepo.save(comandaProduto);
                return ResponseEntity.ok().body(Map.of("success", Map.of("text", "comanda atualizada com sucesso")));
            }

        }

        return  ResponseEntity.status(400).body(Map.of("error", Map.of("text", "produto não encontrado")));
    }
}
