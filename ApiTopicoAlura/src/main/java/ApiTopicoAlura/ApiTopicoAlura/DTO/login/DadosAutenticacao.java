package ApiTopicoAlura.ApiTopicoAlura.DTO.login;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "DadosAutenticacao", description = "DTO para dados de autenticação")
@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosAutenticacao(@JsonAlias("email")
                                @Schema(description = "Email do usuário", example = "usuario@email.com")
                                String email,
                                @JsonAlias("password")
                                @Schema(description = "Senha do usuário", example = "123456")
                                String password) {
}
