package ApiTopicoAlura.ApiTopicoAlura.service.utils;

import ApiTopicoAlura.ApiTopicoAlura.entities.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    public String gerarToken(Usuario usuario) {
        {
            try {
                Algorithm algorithm = Algorithm.HMAC256(secret);
                return JWT.create()
                        .withIssuer("API Topico Alura")
                        .withSubject(usuario.getUsername())
                        .withExpiresAt(dataExpiracao())
                        .sign(algorithm);
            } catch (JWTCreationException exception) {
                throw new RuntimeException("Erro ao criar token", exception);
            }
        }

    }

    private Instant dataExpiracao() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
