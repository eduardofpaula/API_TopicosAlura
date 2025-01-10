# API_TopicosAlura

## API de tópicos de cursos da Alura

### Objetivo

O objetivo desta API é fornecer um serviço de tópicos de cursos da Alura. A API permite a criação, leitura, atualização e remoção de tópicos de cursos.

### Endpoints

#### GET /topicos

Retorna a lista de tópicos de cursos.

#### GET /topicos/{id}

Retorna o tópico de curso com o id informado.

#### POST /topicos

Cria um novo tópico de curso.

#### PUT /topicos/{id}

Atualiza o tópico de curso com o id informado.

#### DELETE /topicos/{id}

Remove o tópico de curso com o id informado.

### Modelo de tópico de curso

```json
{
  "id": 1,
  "titulo": "Java",
  "mensagem": "Dúvidas sobre Java",
  "dataCriacao": "2021-07-01T18:00:00"
}
```

### Tecnologias

- Java 21
- Spring Boot
- Spring Data JPA
- Spring Web
- Spring Security
- PostgreSQL
- Swagger

### Documentação

A documentação da API está disponível em http://localhost:8080/swagger-ui.html

### Como executar

1. Clone o repositório:
   ```sh
   git clone https://github.com/eduardofpaula/API_TopicosAlura.git
   ```
2. Importe o projeto na sua IDE.
3. Execute a classe `ApiTopicosAluraApplication`.