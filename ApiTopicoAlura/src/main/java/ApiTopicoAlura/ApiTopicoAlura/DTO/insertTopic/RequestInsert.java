package ApiTopicoAlura.ApiTopicoAlura.DTO.insertTopic;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonIgnoreProperties(ignoreUnknown = true)
@Schema(description = "Request para inserir um novo tópico")
public record RequestInsert(
        @Schema(description = "Título do tópico", example = "Como configurar Spring Security")
        @JsonAlias("titulo") String title,

        @Schema(description = "Mensagem do tópico", example = "Estou com dificuldades para configurar Spring Security na minha API.")
        @JsonAlias("mensagem") String message,

        @Schema(description = "ID do usuário associado ao tópico", example = "1")
        @JsonAlias("id_usuario") Long userId,

        @Schema(description = "ID do curso associado ao tópico", example = "101")
        @JsonAlias("id_curso") Long courseId) {
}

