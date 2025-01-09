package ApiTopicoAlura.ApiTopicoAlura.service;

import ApiTopicoAlura.ApiTopicoAlura.DTO.AttTopic.RequestAttTopicDTO;
import ApiTopicoAlura.ApiTopicoAlura.DTO.listTopics.ResponseTopicDTO;
import ApiTopicoAlura.ApiTopicoAlura.entities.Curso;
import ApiTopicoAlura.ApiTopicoAlura.entities.Topico;
import ApiTopicoAlura.ApiTopicoAlura.entities.Usuario;
import ApiTopicoAlura.ApiTopicoAlura.DTO.insertTopic.RequestInsert;
import ApiTopicoAlura.ApiTopicoAlura.DTO.insertTopic.ValidadeInsertTopic;
import ApiTopicoAlura.ApiTopicoAlura.repositories.CursoRepository;
import ApiTopicoAlura.ApiTopicoAlura.repositories.TopicoRepository;
import ApiTopicoAlura.ApiTopicoAlura.repositories.UsuarioRepository;
import ApiTopicoAlura.ApiTopicoAlura.service.utils.VerifyEmpty;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TopicService {

    @Autowired
    TopicoRepository topicoRepository;

    @Autowired
    CursoRepository cursoRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Operation(summary = "Insert a new topic", description = "Insert a new topic in the database")
    @Transactional
    public void insertTopic(RequestInsert requestInsert) {

        Usuario usuario = usuarioRepository.findById(requestInsert.userId()).orElseThrow(() -> new IllegalArgumentException("User not found"));
        Curso curso = cursoRepository.findById(requestInsert.courseId()).orElseThrow(() -> new IllegalArgumentException("Course not found"));

        if (topicoRepository.existsByTituloOrMensagem(requestInsert.title(), requestInsert.message())) {
            throw new IllegalArgumentException("Title and message must not be the same");
        }

        ValidadeInsertTopic validadeInsertTopic = new ValidadeInsertTopic(
                requestInsert.title(),
                requestInsert.message()
        );

        VerifyEmpty.validadesAll(validadeInsertTopic);

        Topico topico = new Topico(
                null,
                requestInsert.title(),
                requestInsert.message(),
                LocalDate.now(),
                1,
                usuario,
                curso
        );

        topicoRepository.save(topico);
    }

    @Operation(summary = "List all topics", description = "List all activated topics in the database")
    public List<ResponseTopicDTO> listAllTopics() {

        List<Topico> topicos = topicoRepository.findAllByStatus();
        
        return topicos.stream().map(topico -> new ResponseTopicDTO(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getDataCriacao(),
                topico.getStatus(),
                topico.getCurso().getId(),
                topico.getUsuario().getId()
        )).collect(Collectors.toList());
        
    }

    @Operation(summary = "List topic by ID", description = "List a topic by ID in the database")
    public ResponseTopicDTO listTopicById(Long id) {

        Topico topico = topicoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Topic not found"));

        return new ResponseTopicDTO(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getDataCriacao(),
                topico.getStatus(),
                topico.getCurso().getId(),
                topico.getUsuario().getId()
        );
    }

    @Operation(summary = "Update a topic", description = "Update a topic in the database")
    @Transactional
    public void updateTopic(RequestAttTopicDTO requestAttTopicDTO) {

        Optional<Topico> topicoEdited = topicoRepository.findById(requestAttTopicDTO.id());

        if (topicoEdited.isEmpty()) {
            throw new IllegalArgumentException("Topic not found");
        }

        if( topicoRepository.existsByTituloOrMensagem(requestAttTopicDTO.title(), requestAttTopicDTO.message())) {
            throw new IllegalArgumentException("Title and message must not be the same");
        }

        ValidadeInsertTopic validadeInsertTopic = new ValidadeInsertTopic(
                requestAttTopicDTO.title(),
                requestAttTopicDTO.message()
        );

        VerifyEmpty.validadesAll(validadeInsertTopic);

        Topico topico = topicoEdited.get();
        topico.setTitulo(requestAttTopicDTO.title());
        topico.setMensagem(requestAttTopicDTO.message());
        topicoRepository.save(topico);
    }

    @Operation(summary = "Delete a topic", description = "Delete a topic in the database")
    @Transactional
    public void deleteTopic(@Valid Long id) {

        Optional<Topico> topico = topicoRepository.findById(id);

        if (topico.isEmpty()) {
            throw new IllegalArgumentException("Topic not found");
        }

        topicoRepository.deleteById(id);

    }
}
