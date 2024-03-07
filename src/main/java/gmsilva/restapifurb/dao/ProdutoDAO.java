package gmsilva.restapifurb.dao;

import gmsilva.restapifurb.dto.comanda.Comanda;
import gmsilva.restapifurb.dto.comanda.ComandaRepository;
import gmsilva.restapifurb.dto.comanda.DadosCadastroComanda;
import gmsilva.restapifurb.dto.produto.DadosCadastroProduto;
import gmsilva.restapifurb.dto.produto.Produto;
import gmsilva.restapifurb.dto.produto.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProdutoDAO {

    @Autowired
    private ProdutoRepository produtoRepo;
    public void cadastrarProduto(DadosCadastroProduto produto) {
        //validar os dados
        System.out.println(produto);
        // salvar a comanda
        produtoRepo.save(new Produto(produto));
        // salvar os produtos na comanda
    }
}
