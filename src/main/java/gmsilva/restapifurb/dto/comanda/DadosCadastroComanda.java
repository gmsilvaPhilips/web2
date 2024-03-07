package gmsilva.restapifurb.dto.comanda;

import gmsilva.restapifurb.dto.produto.DadosCadastroProduto;
import gmsilva.restapifurb.dto.produto.Produto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.ArrayList;
import java.util.List;

public record DadosCadastroComanda(
        @Min(value = 0, message = "O id do usuário deve ser maior que 0")Long idUsuario,
        @NotBlank(message = "O nome do usuário não pode ser vazio")String nomeUsuario,
        @NotBlank(message = "O telefone do usuário não pode ser vazio") String telefoneUsuario,
        @NotEmpty(message = "A lista de produtos não pode ser vazia")
        List<DadosCadastroProduto> produtos) {
}
