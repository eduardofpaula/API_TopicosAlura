package ApiTopicoAlura.ApiTopicoAlura.DTO.login;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosAutenticacao(String email, String password) {
}
