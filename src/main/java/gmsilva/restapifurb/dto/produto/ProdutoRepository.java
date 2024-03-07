package gmsilva.restapifurb.dto.produto;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    Produto findByNome(String nome);
    boolean existsByNome(String nome);

}
