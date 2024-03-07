package gmsilva.restapifurb.bo;

import gmsilva.restapifurb.dao.ComandaDAO;
import gmsilva.restapifurb.dto.comanda.Comanda;
import gmsilva.restapifurb.dto.comanda.DadosCadastroComanda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComandaBO {

    @Autowired
    private ComandaDAO comandaDAO;


    public ResponseEntity<Comanda> cadastrarComanda(DadosCadastroComanda comanda) {
    return comandaDAO.cadastrarComanda(comanda);
    }

    public List<Comanda> obterTodasComandas() {
        return comandaDAO.obterTodasComandas();
    }

    public ResponseEntity<Comanda> ObterComanda(Long id) {
    return comandaDAO.obterComanda(id);
    }

    public ResponseEntity deletarComanda(Long id) {
    return  comandaDAO.deletarComanda(id);
    }
}
