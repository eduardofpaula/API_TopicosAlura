package ApiTopicoAlura.ApiTopicoAlura.DTO.insertTopic;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonIgnoreProperties(ignoreUnknown = true)
@Schema(description = "Dados para validação da inserção de um tópico")
public record ValidadeInsertTopic(
        @Schema(description = "Título do tópico", example = "Dúvida sobre Spring Boot")
        @JsonAlias("titulo") String title,

        @Schema(description = "Mensagem do tópico", example = "Como configurar múltiplos bancos de dados no Spring Boot?")
        @JsonAlias("mensagem") String message) {
}
