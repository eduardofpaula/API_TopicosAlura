package ApiTopicoAlura.ApiTopicoAlura.DTO.AttTopic;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record RequestAttTopicDTO(
        @JsonAlias("id") Long id,
        @JsonAlias("titulo") String title,
        @JsonAlias("mensagem") String message) {
}
