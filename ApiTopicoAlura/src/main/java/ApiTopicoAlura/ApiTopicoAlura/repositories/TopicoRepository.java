package ApiTopicoAlura.ApiTopicoAlura.repositories;

import ApiTopicoAlura.ApiTopicoAlura.entities.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {

    boolean existsByTituloOrMensagem(String titulo, String mensagem);
}


