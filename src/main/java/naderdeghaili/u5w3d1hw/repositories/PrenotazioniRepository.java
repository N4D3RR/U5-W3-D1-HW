package naderdeghaili.u5w3d1hw.repositories;

import naderdeghaili.u5w3d1hw.entities.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.UUID;

public interface PrenotazioniRepository extends JpaRepository<Prenotazione, UUID> {

    boolean existsByViaggioDataViaggioAndDipendenteId(LocalDate dataViaggio, UUID dipendenteId);

    boolean existsByViaggioIdAndDipendenteId(UUID viaggioId, UUID dipendenteId);


}
