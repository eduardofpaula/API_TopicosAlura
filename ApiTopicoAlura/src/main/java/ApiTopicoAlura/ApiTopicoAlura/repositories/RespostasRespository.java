package ApiTopicoAlura.ApiTopicoAlura.repositories;

import ApiTopicoAlura.ApiTopicoAlura.entities.Resposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RespostasRespository extends JpaRepository<Resposta, Long> {
}
