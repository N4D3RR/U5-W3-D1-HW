package naderdeghaili.u5w3d1hw.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import naderdeghaili.u5w3d1hw.entities.Dipendente;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTTools {

    @Value("${jwt.secret}")
    private String key;

    public String createToken(Dipendente dipendente) {
        return Jwts.builder().issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 30))
                .subject(String.valueOf(dipendente.getId()))
                .signWith(Keys.hmacShaKeyFor(key.getBytes()))
                .compact();

    }

//    public String verifyToken() {
//
//    }
}
