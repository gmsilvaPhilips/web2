package gmsilva.restapifurb.dto.comanda;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface ComandaRepository extends JpaRepository<Comanda, Long> {

    @Query("SELECT c.id, c.idUsuario, c.nomeUsuario, c.telefoneUsuario, GROUP_CONCAT(p.nome) AS produtos_nomes, GROUP_CONCAT(p.preco) AS produtos_precos FROM Comanda c, ComandaProduto cp, Produto p  where c.id = cp.comanda.id and p.id = cp.produto.id and c.id = :id GROUP BY c.id")
    Optional<Object[]> findByIdWithProdutos(@Param("id") long id);

}
