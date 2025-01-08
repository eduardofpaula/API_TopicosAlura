package ApiTopicoAlura.ApiTopicoAlura.DTO.listTopics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ResponseTopicDTO(Long id, String title, String message, LocalDate dataCriacao, int status,
                               Long idCurso, Long idUsuario) {
}
