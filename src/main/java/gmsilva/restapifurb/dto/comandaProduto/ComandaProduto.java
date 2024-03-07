package gmsilva.restapifurb.dto.comandaProduto;

import gmsilva.restapifurb.dto.comanda.Comanda;
import gmsilva.restapifurb.dto.produto.Produto;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "comandaprodutos")
@Entity(name = "ComandaProduto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ComandaProduto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "idcomanda")
    private Comanda comanda;

    @ManyToOne
    @JoinColumn(name = "idproduto")
    private Produto produto;

    public ComandaProduto(Comanda comanda, Produto produto){
        this.comanda = comanda;
        this.produto = produto;
    }
}
