package gmsilva.restapifurb.dao;

import gmsilva.restapifurb.dto.comanda.Comanda;
import gmsilva.restapifurb.dto.comanda.ComandaRepository;
import gmsilva.restapifurb.dto.comanda.DadosCadastroComanda;
import gmsilva.restapifurb.dto.comandaProduto.ComandaProduto;
import gmsilva.restapifurb.dto.comandaProduto.ComandaProdutoRepository;
import gmsilva.restapifurb.dto.produto.DadosCadastroProduto;
import gmsilva.restapifurb.dto.produto.Produto;
import gmsilva.restapifurb.dto.produto.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public class ComandaDAO {

    @Autowired
    private ComandaRepository comandaRepo;

    @Autowired
    private ComandaProdutoRepository comandaProdutoRepo;

    @Autowired
    private ProdutoRepository produtoRepo;
    public ResponseEntity<Comanda> cadastrarComanda(DadosCadastroComanda dadosCadastroComanda) {
        //validar os dados
        System.out.println(dadosCadastroComanda);
        // salvar a comanda
       Comanda comanda = new Comanda(dadosCadastroComanda);
       comandaRepo.save(comanda);

        for (DadosCadastroProduto dadosCadastroProduto :  dadosCadastroComanda.produtos()){
        //validar os dados

            ComandaProduto comandaProduto = new ComandaProduto(comanda,produtoRepo.findByNome(dadosCadastroProduto.nome()));

            comandaProdutoRepo.save(comandaProduto);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(comanda);
    }
}
