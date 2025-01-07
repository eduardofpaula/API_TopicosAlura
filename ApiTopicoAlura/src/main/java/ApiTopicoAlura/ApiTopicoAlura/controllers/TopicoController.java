package ApiTopicoAlura.ApiTopicoAlura.controllers;


import ApiTopicoAlura.ApiTopicoAlura.DTO.insertTopic.RequestInsert;
import ApiTopicoAlura.ApiTopicoAlura.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
