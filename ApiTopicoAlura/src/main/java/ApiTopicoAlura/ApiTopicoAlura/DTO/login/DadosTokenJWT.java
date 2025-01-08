package ApiTopicoAlura.ApiTopicoAlura.DTO.login;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosTokenJWT(
        @Schema(description = "Token JWT", example = "$2a$12$9IdDEFCLQ5xSbl7x30Vs")
        String token) {
}
