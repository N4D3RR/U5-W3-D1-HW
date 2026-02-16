package naderdeghaili.u5w3d1hw.repositories;

import naderdeghaili.u5w3d1hw.entities.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DipendentiRepository extends JpaRepository<Dipendente, UUID> {
    boolean existsByEmail(String email);

    boolean existsByUsername(String username);
}
