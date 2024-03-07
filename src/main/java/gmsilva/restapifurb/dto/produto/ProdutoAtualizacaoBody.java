package gmsilva.restapifurb.dto.produto;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record ProdutoAtualizacaoBody(List<DadosCadastroProduto> produtos) {
}
