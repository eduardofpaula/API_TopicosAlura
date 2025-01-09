package ApiTopicoAlura.ApiTopicoAlura.DTO;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DeleteTopicDTO(@JsonAlias("id") Long id) {
}
