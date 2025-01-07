package ApiTopicoAlura.ApiTopicoAlura.DTO.insertTopic;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ValidadeInsertTopic(@JsonAlias("titulo") String title,
                                   @JsonAlias("mensagem") String message) {
}
