package naderdeghaili.u5w3d1hw.services;

import lombok.extern.slf4j.Slf4j;
import naderdeghaili.u5w3d1hw.entities.Dipendente;
import naderdeghaili.u5w3d1hw.entities.Prenotazione;
import naderdeghaili.u5w3d1hw.entities.Viaggio;
import naderdeghaili.u5w3d1hw.exceptions.NotFoundException;
import naderdeghaili.u5w3d1hw.exceptions.ValidationException;
import naderdeghaili.u5w3d1hw.payloads.NewPrenotazioneDTO;
import naderdeghaili.u5w3d1hw.repositories.DipendentiRepository;
import naderdeghaili.u5w3d1hw.repositories.PrenotazioniRepository;
import naderdeghaili.u5w3d1hw.repositories.ViaggiRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PrenotazioniService {

    private final PrenotazioniRepository prenotazioniRepository;
    private final ViaggiRepository viaggiRepository;
    private final DipendentiRepository dipendentiRepository;

    public PrenotazioniService(PrenotazioniRepository prenotazioniRepository, ViaggiRepository viaggiRepository, DipendentiRepository dipendentiRepository) {
        this.prenotazioniRepository = prenotazioniRepository;
        this.viaggiRepository = viaggiRepository;
        this.dipendentiRepository = dipendentiRepository;
    }

    public Prenotazione savePrenotazione(NewPrenotazioneDTO payload) {

        Viaggio viaggio = viaggiRepository.findById(payload.viaggioId()).orElseThrow(() -> new NotFoundException(payload.viaggioId()));

        Dipendente dipendente = dipendentiRepository.findById(payload.dipendenteId()).orElseThrow(() -> new NotFoundException(payload.dipendenteId()));


        if (prenotazioniRepository.existsByViaggioIdAndDipendenteId(viaggio.getId(), dipendente.getId())) {
            throw new ValidationException(List.of("il dipendente ha già prenotato questo viaggio"));
        }

        if (prenotazioniRepository.existsByViaggioDataViaggioAndDipendenteId(viaggio.getDataViaggio(), dipendente.getId())) {
            throw new ValidationException(List.of("il dipendente ha già una prenotazione per quel giorno"));
        }

        Prenotazione prenotazione = new Prenotazione(viaggio, dipendente, payload.note());

        return prenotazioniRepository.save(prenotazione);
    }


}
