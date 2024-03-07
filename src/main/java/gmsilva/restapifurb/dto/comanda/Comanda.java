package gmsilva.restapifurb.dto.comanda;


import com.fasterxml.jackson.annotation.JsonInclude;
import gmsilva.restapifurb.dto.comandaProduto.ComandaProduto;
import gmsilva.restapifurb.dto.produto.DadosCadastroProduto;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
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
    @OneToMany(mappedBy = "comanda", cascade = CascadeType.ALL)
    private List<ComandaProduto> comandaProdutos;
    @Transient
    private List<DadosCadastroProduto> produtos;


    public Comanda(DadosCadastroComanda comanda){
        this.idUsuario = comanda.idUsuario();
        this.nomeUsuario = comanda.nomeUsuario();
        this.telefoneUsuario = comanda.telefoneUsuario();
        this.produtos = comanda.produtos();
    }

}

