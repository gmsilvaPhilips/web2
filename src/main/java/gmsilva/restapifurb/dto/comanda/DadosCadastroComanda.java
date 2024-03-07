package gmsilva.restapifurb.dto.comanda;

import gmsilva.restapifurb.dto.produto.DadosCadastroProduto;
import gmsilva.restapifurb.dto.produto.Produto;

import java.util.ArrayList;
import java.util.List;

public record DadosCadastroComanda(Long idUsuario, String nomeUsuario, String telefoneUsuario, List<DadosCadastroProduto> produtos) {
}
