package naderdeghaili.u5w3d1hw.controllers;

import naderdeghaili.u5w3d1hw.payloads.LoginDTO;
import naderdeghaili.u5w3d1hw.payloads.LoginResDTO;
import naderdeghaili.u5w3d1hw.services.LoginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class DipendentiLoginController {

    private final LoginService loginService;


    public DipendentiLoginController(LoginService loginService) {
        this.loginService = loginService;

    }


    @PostMapping("/login")
    public LoginResDTO login(@RequestBody LoginDTO body) {

        return new LoginResDTO(this.loginService.getCredentialsGiveToken(body));
    }
}
