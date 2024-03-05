package gmsilva.restapifurb.dto.produto;

import java.math.BigDecimal;

public record DadosCadastroProduto(Long id,String nome, BigDecimal preco) {
}
