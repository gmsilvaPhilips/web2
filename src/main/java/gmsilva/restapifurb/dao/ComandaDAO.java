package gmsilva.restapifurb.dao;

import gmsilva.restapifurb.dto.comanda.Comanda;
import gmsilva.restapifurb.dto.comanda.ComandaRepository;
import gmsilva.restapifurb.dto.comanda.DadosCadastroComanda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ComandaDAO {

    @Autowired
    private ComandaRepository comandaRepo;
    public void cadastrarComanda(DadosCadastroComanda comanda) {
       comandaRepo.save(new Comanda(comanda));
    }
}
