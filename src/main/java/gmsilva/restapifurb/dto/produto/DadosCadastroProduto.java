package gmsilva.restapifurb.dto.produto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record DadosCadastroProduto(
        @NotBlank(message = "Nome não pode ser nulo") String nome,
        @DecimalMax(value = "1000.00", message ="O valor não pode ser maior que 1000") BigDecimal preco) {
}
