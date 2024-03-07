package gmsilva.restapifurb.controller;

import gmsilva.restapifurb.bo.ComandaBO;
import gmsilva.restapifurb.dto.comanda.Comanda;
import gmsilva.restapifurb.dto.comanda.DadosCadastroComanda;
import gmsilva.restapifurb.dto.produto.ProdutoAtualizacaoBody;
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
    public ResponseEntity registrarComanda(@Valid @RequestBody DadosCadastroComanda comanda) {
        return comandaBO.cadastrarComanda(comanda);
    }
    @GetMapping("/comandas")
    public ResponseEntity obterTodasComandas() {
        return comandaBO.obterTodasComandas();

}
    @GetMapping("/comandas/{id}")
    public ResponseEntity obterComanda(@PathVariable Long id) {
        return comandaBO.ObterComanda(id);
    }

    @DeleteMapping("/comandas/{id}")
    public ResponseEntity deletarComanda(@PathVariable Long id){
        return comandaBO.deletarComanda(id);
    }


    @PutMapping("/comandas/{id}")
    public ResponseEntity atualizarComanda(@PathVariable Long id,@Valid @RequestBody ProdutoAtualizacaoBody body){
        return comandaBO.atualizarComanda(id,body);
    }
}


