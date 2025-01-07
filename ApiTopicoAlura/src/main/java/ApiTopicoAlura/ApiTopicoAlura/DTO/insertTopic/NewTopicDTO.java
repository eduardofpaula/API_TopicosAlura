package ApiTopicoAlura.ApiTopicoAlura.DTO.insertTopic;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record NewTopicDTO(@JsonAlias("titulo") String title,
                          @JsonAlias("mensagem") String message,
                          @JsonAlias("id_curso") Long courseId,
                          @JsonAlias("id_usuario") Long userId) {
}
