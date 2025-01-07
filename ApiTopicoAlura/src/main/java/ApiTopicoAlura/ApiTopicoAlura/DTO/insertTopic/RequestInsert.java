package ApiTopicoAlura.ApiTopicoAlura.DTO.insertTopic;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record RequestInsert(@JsonAlias("titulo") String title,
                            @JsonAlias("mensagem") String message,
                            @JsonAlias("id_usuario") Long userId,
                            @JsonAlias("id_curso") Long courseId) {

}
