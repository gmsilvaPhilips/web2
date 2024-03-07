package gmsilva.restapifurb.dto.comanda;


import gmsilva.restapifurb.dto.comandaProduto.ComandaProduto;
import gmsilva.restapifurb.dto.produto.Produto;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Table(name = "comandas")
@Entity(name = "Comanda")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Comanda {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "idusuario")
    private long idUsuario;
    @Column(name = "nomeusuario")
    private String nomeUsuario;
    @Column(name = "telefoneusuario")
    private String telefoneUsuario;
    @OneToMany(mappedBy = "comanda")
    private List<ComandaProduto> comandaProdutos;

    public Comanda(DadosCadastroComanda comanda){
        this.idUsuario = comanda.idUsuario();
        this.nomeUsuario = comanda.nomeUsuario();
        this.telefoneUsuario = comanda.telefoneUsuario();
    }

}

