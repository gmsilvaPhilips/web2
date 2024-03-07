package gmsilva.restapifurb.dto.produto;
import gmsilva.restapifurb.dto.comandaProduto.ComandaProduto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.List;

@Table(name = "produtos")
@Entity(name = "Produto")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Produto {
@Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
private List<ComandaProduto> comandaProdutos;
@Column(name = "nome")
private String nome;
@Column(name = "preco")
private BigDecimal preco;

public Produto(DadosCadastroProduto produto){
    this.nome = produto.nome();
    this.preco = produto.preco();
}
}
