package gmsilva.restapifurb.bo;

import gmsilva.restapifurb.dao.ComandaDAO;
import gmsilva.restapifurb.dto.comanda.Comanda;
import gmsilva.restapifurb.dto.comanda.DadosCadastroComanda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class ComandaBO {

    @Autowired
    private ComandaDAO comandaDAO;


    public ResponseEntity<Comanda> cadastrarComanda(DadosCadastroComanda comanda) {
    return comandaDAO.cadastrarComanda(comanda);
    }
}
