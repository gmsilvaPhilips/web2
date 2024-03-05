package gmsilva.restapifurb.dto.produto;


import gmsilva.restapifurb.dto.comanda.Comanda;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Table(name = "produtos")
@Entity(name = "Produto")
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Produto {
@Id
private long id;
@ManyToOne
@JoinColumn(name = "idComanda")
private Comanda comanda;
private String nome;
private BigDecimal preco;

public Produto(DadosCadastroProduto produto){
    this.id = produto.id();
    this.nome = produto.nome();
    this.preco = produto.preco();

}
}
