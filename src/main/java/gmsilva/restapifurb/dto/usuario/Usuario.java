package gmsilva.restapifurb.dto.usuario;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "usuarios")
@Entity(name = "Usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Usuario {
    @Id @GeneratedValue
    private Long id;
    private String nome;
    private String telefone;


    public Usuario(DadosCadastroUsuario usuario){
        this.nome = usuario.nome();
        this.telefone = usuario.telefone();
    }

}
