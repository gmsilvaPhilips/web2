package gmsilva.restapifurb.dao;

import gmsilva.restapifurb.dto.comanda.Comanda;
import gmsilva.restapifurb.dto.comanda.ComandaRepository;
import gmsilva.restapifurb.dto.comanda.DadosCadastroComanda;
import gmsilva.restapifurb.dto.produto.DadosCadastroProduto;
import gmsilva.restapifurb.dto.produto.Produto;
import gmsilva.restapifurb.dto.produto.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class ProdutoDAO {

    @Autowired
    private ProdutoRepository produtoRepo;
    public ResponseEntity cadastrarProduto(DadosCadastroProduto dadosCadastroProduto) {
        if (produtoRepo.existsByNome(dadosCadastroProduto.nome())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of("error", Map.of("text", "Produto já existe")));
        }

        Produto produto = new Produto(dadosCadastroProduto);
        produtoRepo.save(produto);
        return ResponseEntity.ok().body(produto);
        // salvar os produtos na comanda
    }
}
