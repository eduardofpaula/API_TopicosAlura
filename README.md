# API_TopicosAlura

## API de tópicos de cursos da Alura

### Objetivo

O objetivo desta API é fornecer um serviço de tópicos de cursos da Alura. A API permite a criação, leitura, atualização e remoção de tópicos de cursos.

### Endpoints

#### GET /topicos

Retorna a lista de tópicos ativados de cursos associados a um usuario.

![image](https://github.com/user-attachments/assets/a4791467-539c-447c-b829-3c1820a88d76)


#### GET /topicos/{id}

Retorna o tópico de curso com o id informado.

![image](https://github.com/user-attachments/assets/7ef02254-4aa4-4a45-a4b1-5f3eae6b667b)

#### POST /topicos

Cria um novo tópico de curso.

![image](https://github.com/user-attachments/assets/73478a83-7665-4b36-b929-c00717fa3d54)

#### PUT /topicos/{id}

Atualiza o tópico de curso com o id informado.

![image](https://github.com/user-attachments/assets/1ad4be36-cd17-47a3-adb6-cb6aa73705df)

#### DELETE /topicos/{id}

Remove o tópico de curso com o id informado.

![image](https://github.com/user-attachments/assets/2646b3d8-cb18-4783-8f6e-99dd41cc3900)

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

- ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
- ![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
- Spring Data JPA
- Spring Web
- Spring Security
- ![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
- ![Swagger](https://img.shields.io/badge/-Swagger-%23Clojure?style=for-the-badge&logo=swagger&logoColor=white)

### Documentação

A documentação da API está disponível em http://localhost:8080/swagger-ui.html

### Como executar

1. Clone o repositório:
   ```sh
   git clone https://github.com/eduardofpaula/API_TopicosAlura.git
   ```
2. Importe o projeto na sua IDE.
3. Execute a classe `ApiTopicosAluraApplication`.
