package gmsilva.restapifurb.controller;

import gmsilva.restapifurb.bo.ComandaBO;
import gmsilva.restapifurb.dto.comanda.Comanda;
import gmsilva.restapifurb.dto.comanda.DadosCadastroComanda;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/RestAPIFurb")
public class ComandaController {

    @Autowired
    private ComandaBO comandaBO;
    @PostMapping("/comandas")
    public ResponseEntity<Comanda> registrarComanda(@Valid @RequestBody DadosCadastroComanda comanda) {

        System.out.println(comanda);
        return comandaBO.cadastrarComanda(comanda);
    }
 }
