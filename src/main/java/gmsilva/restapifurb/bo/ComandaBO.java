package gmsilva.restapifurb.bo;

import gmsilva.restapifurb.dao.ComandaDAO;
import gmsilva.restapifurb.dto.comanda.DadosCadastroComanda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ComandaBO {

    @Autowired
    private ComandaDAO comandaDAO;


    public void cadastrarComanda(DadosCadastroComanda comanda) {
    comandaDAO.cadastrarComanda(comanda);
    }
}
