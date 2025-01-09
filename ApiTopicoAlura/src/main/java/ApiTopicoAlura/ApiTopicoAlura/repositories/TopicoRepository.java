package ApiTopicoAlura.ApiTopicoAlura.repositories;

import ApiTopicoAlura.ApiTopicoAlura.DTO.listTopics.ResponseTopicDTO;
import ApiTopicoAlura.ApiTopicoAlura.entities.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {

    boolean existsByTituloOrMensagem(String titulo, String mensagem);

    @Query("select d from Topico d where d.status = 1 order by NLSSORT(d.titulo, 'NLS_SORT = BINARY_AI') ASC")
    List<Topico> findAllByStatus();
}


