package gmsilva.restapifurb.dao;

import gmsilva.restapifurb.dto.comanda.Comanda;
import gmsilva.restapifurb.dto.comanda.ComandaRepository;
import gmsilva.restapifurb.dto.comanda.DadosCadastroComanda;
import gmsilva.restapifurb.dto.comandaProduto.ComandaProduto;
import gmsilva.restapifurb.dto.comandaProduto.ComandaProdutoRepository;
import gmsilva.restapifurb.dto.produto.DadosCadastroProduto;
import gmsilva.restapifurb.dto.produto.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ComandaDAO {

    @Autowired
    private ComandaRepository comandaRepo;

    @Autowired
    private ComandaProdutoRepository comandaProdutoRepo;
    public void cadastrarComanda(DadosCadastroComanda dadosCadastroComanda) {
        //validar os dados
        System.out.println(dadosCadastroComanda);
        // salvar a comanda
       Comanda comanda = new Comanda(dadosCadastroComanda);
       comandaRepo.save(comanda);

        for (DadosCadastroProduto dadosCadastroProduto :  dadosCadastroComanda.produtos()){
        //validar os dados
            ComandaProduto comandaProduto = new ComandaProduto(comanda, new Produto(dadosCadastroProduto));
            comandaProdutoRepo.save(comandaProduto);
        }

    }
}
