package gmsilva.restapifurb.controller;

import gmsilva.restapifurb.bo.ComandaBO;
import gmsilva.restapifurb.dto.comanda.DadosCadastroComanda;
import gmsilva.restapifurb.dto.produto.DadosCadastroProduto;
import jakarta.persistence.Embedded;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/RestAPIFurb")
public class ComandaController {


    @PostMapping("/comandas")
    public String registrarComanda(@Valid @RequestBody DadosCadastroComanda comanda) {
        ComandaBO comandaBO = new ComandaBO();
        comandaBO.cadastrarComanda(comanda);
        System.out.println(comanda);
        return comanda.toString();
    }
 }
