package gmsilva.restapifurb.controller;

import gmsilva.restapifurb.bo.ComandaBO;
import gmsilva.restapifurb.dto.comanda.Comanda;
import gmsilva.restapifurb.dto.comanda.DadosCadastroComanda;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/RestAPIFurb")
public class ComandaController {

    @Autowired
    private ComandaBO comandaBO;
    @PostMapping("/comandas")
    public ResponseEntity<Comanda> registrarComanda(@Valid @RequestBody DadosCadastroComanda comanda) {
        return comandaBO.cadastrarComanda(comanda);
    }
    @GetMapping("/comandas")
    public ResponseEntity<List<Comanda>> obterTodasComandas() {
        List<Comanda> comandas = comandaBO.obterTodasComandas();
        return ResponseEntity.ok(comandas);



}
    @GetMapping("/comandas/{id}")
    public ResponseEntity<Comanda> obterComanda(@PathVariable Long id) {
        return comandaBO.ObterComanda(id);
    }

    @DeleteMapping("/comandas/{id}")
    public ResponseEntity deletarComanda(@PathVariable Long id){
        return comandaBO.deletarComanda(id);
    }
}


