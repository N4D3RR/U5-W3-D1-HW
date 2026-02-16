package naderdeghaili.u5w3d1hw.services;

import naderdeghaili.u5w3d1hw.entities.Dipendente;
import naderdeghaili.u5w3d1hw.exceptions.UnauthorizedException;
import naderdeghaili.u5w3d1hw.payloads.LoginDTO;
import naderdeghaili.u5w3d1hw.security.JWTTools;
import org.springframework.stereotype.Service;

@Service

public class LoginService {

    private final DipendentiService dipendentiService;
    private final JWTTools jwtTools;

    public LoginService(DipendentiService dipendentiService, JWTTools jwtTools) {
        this.dipendentiService = dipendentiService;
        this.jwtTools = jwtTools;

    }


    public String getCredentialsGiveToken(LoginDTO body) {
        Dipendente found = this.dipendentiService.findByEmail(body.email());
        if (found.getEmail().equals(body.email())) {
            String accessToken = jwtTools.createToken(found);

            return accessToken;

        } else {
            throw new UnauthorizedException("Credenziali errate, riprova");
        }
        
    }
}
