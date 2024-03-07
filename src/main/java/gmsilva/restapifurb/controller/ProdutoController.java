package gmsilva.restapifurb.controller;

import gmsilva.restapifurb.bo.ComandaBO;
import gmsilva.restapifurb.bo.ProdutoBO;
import gmsilva.restapifurb.dao.ComandaDAO;
import gmsilva.restapifurb.dto.comanda.DadosCadastroComanda;
import gmsilva.restapifurb.dto.produto.DadosCadastroProduto;
import jakarta.persistence.Embedded;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/RestAPIFurb")
public class ProdutoController {

    @Autowired
    private ProdutoBO produtoBO;
    @PostMapping("/produtos")
    public String registrarProduto(@Valid @RequestBody DadosCadastroProduto produto) {
        produtoBO.cadastrarProduto(produto);
        System.out.println(produto);
        return produto.toString();
    }
}
