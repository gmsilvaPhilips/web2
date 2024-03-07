package gmsilva.restapifurb.bo;

import gmsilva.restapifurb.dao.ProdutoDAO;
import gmsilva.restapifurb.dto.produto.DadosCadastroProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProdutoBO {

    @Autowired
    private ProdutoDAO produtoDAO;


    public ResponseEntity cadastrarProduto(DadosCadastroProduto produto) {
        return produtoDAO.cadastrarProduto(produto);
    }
}
