package gmsilva.restapifurb.bo;

import gmsilva.restapifurb.dao.ComandaDAO;
import gmsilva.restapifurb.dao.ProdutoDAO;
import gmsilva.restapifurb.dto.comanda.DadosCadastroComanda;
import gmsilva.restapifurb.dto.produto.DadosCadastroProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class ProdutoBO {

    @Autowired
    private ProdutoDAO produtoDAO;


    public void cadastrarProduto(DadosCadastroProduto produto) {
        produtoDAO.cadastrarProduto(produto);
    }
}
