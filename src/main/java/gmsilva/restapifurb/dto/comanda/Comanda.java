package gmsilva.restapifurb.dto.comanda;


import gmsilva.restapifurb.dto.produto.Produto;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;

@Table(name = "comandas")
@Entity(name = "Comanda")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Comanda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long idUsuario;
    private String nomeUsuario;
    private String telefoneUsuario;
    @OneToMany(mappedBy = "comanda")
    private ArrayList<Produto> produtos;


    public Comanda(DadosCadastroComanda comanda){
        this.idUsuario = comanda.idUsuario();
        this.nomeUsuario = comanda.nomeUsuario();
        this.telefoneUsuario = comanda.telefoneUsuario();
    }

}

