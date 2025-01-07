package ApiTopicoAlura.ApiTopicoAlura.configurations;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@OpenAPIDefinition(
        info = @Info(
                title = "Api Topico Alura",
                version = "v1",
                description = """
                        Api para gerenciamento de tópicos de um fórum.
                        """,
                contact = @Contact(
                        name = "Eduardo Farias",
                        url = "https://www.linkedin.com/in/eduardofariasp/",
                        email = "eduardo.fariasp@outlook.com"
                ),
                license = @License(
                        name = "MIT License",
                        url = "https://opensource.org/licenses/MIT"
                )
        )
)

public class SwaggerConfig {
}
