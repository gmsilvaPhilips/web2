package gmsilva.restapifurb.dto.comanda;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import gmsilva.restapifurb.dto.comandaProduto.ComandaProduto;
import gmsilva.restapifurb.dto.produto.DadosCadastroProduto;
import gmsilva.restapifurb.dto.produto.Produto;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Double.parseDouble;

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
    @JsonIgnore
    private List<ComandaProduto> comandaProdutos;
    @Transient
    private List<DadosCadastroProduto> produtos;


    public Comanda(DadosCadastroComanda comanda){
        this.idUsuario = comanda.idUsuario();
        this.nomeUsuario = comanda.nomeUsuario();
        this.telefoneUsuario = comanda.telefoneUsuario();
        this.produtos = comanda.produtos();
    }


    public static Comanda fromResultSet(Object[] resultSet) {

        Comanda comanda = new Comanda();
        Object[] innerArray = (Object[]) resultSet[0];
        System.out.println(innerArray[0]);


        comanda.setId((Long) innerArray[0]);
        comanda.setIdUsuario((Long) innerArray[1]);
        comanda.setNomeUsuario((String) innerArray[2]);
        comanda.setTelefoneUsuario((String) innerArray[3]);

        List<DadosCadastroProduto> produtos = new ArrayList<>();
        String[] nomesProdutos = ((String) innerArray[4]).split(",");
        String[] precosProdutos = ((String) innerArray[5]).split(",");

        for (int i = 0; i < nomesProdutos.length; i++) {
            DadosCadastroProduto produto = new DadosCadastroProduto(nomesProdutos[i], new BigDecimal(Double.valueOf(precosProdutos[i])));
            produtos.add(produto);
        }


        comanda.setProdutos(produtos);

        return comanda;
    }
}

