package gmsilva.restapifurb.dto.comanda;

import gmsilva.restapifurb.dto.produto.DadosCadastroProduto;
import gmsilva.restapifurb.dto.produto.Produto;

import java.util.ArrayList;

public record DadosCadastroComanda(Long idUsuario, String nomeUsuario, String telefoneUsuario, ArrayList<DadosCadastroProduto> produtos) {
}
