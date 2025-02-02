package ApiTopicoAlura.ApiTopicoAlura.controllers;


import ApiTopicoAlura.ApiTopicoAlura.DTO.AttTopic.RequestAttTopicDTO;
import ApiTopicoAlura.ApiTopicoAlura.DTO.insertTopic.RequestInsert;
import ApiTopicoAlura.ApiTopicoAlura.DTO.listTopics.ResponseTopicDTO;
import ApiTopicoAlura.ApiTopicoAlura.service.TopicService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    TopicService topicService;

    @PostMapping
    public ResponseEntity<Map<String,String>> insertTopic(@RequestBody RequestInsert requestInsert) {

        topicService.insertTopic(requestInsert);
        return new ResponseEntity<>(Map.of("message","Tópico inserido com Sucesso"), HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<List<ResponseTopicDTO>> getAllTopics() {
        return ResponseEntity.ok().body(topicService.listAllTopics());
    }

    @GetMapping("/id")
    public ResponseEntity<ResponseTopicDTO> getTopiById(@RequestParam @Valid Long id) {
        return ResponseEntity.ok().body(topicService.listTopicById(id));
    }

    @PutMapping()
    public ResponseEntity<Map<String,String>> updateTopic(@RequestBody RequestAttTopicDTO requestAttTopicDTO) {
        topicService.updateTopic(requestAttTopicDTO);
        return new ResponseEntity<>(Map.of("message","Tópico atualizado com Sucesso"), HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<Map<String,String>> deleteTopic(@RequestParam @Valid Long id) {
        topicService.deleteTopic(id);
        return new ResponseEntity<>(Map.of("message","Tópico deletado com Sucesso"), HttpStatus.OK);
    }
}
