package naderdeghaili.u5w3d1hw.controllers;

import naderdeghaili.u5w3d1hw.payloads.LoginDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class DipendentiLogin {

    @PostMapping("/login")
    public String login(@RequestBody LoginDTO body) {
        
        return null;
    }
}
