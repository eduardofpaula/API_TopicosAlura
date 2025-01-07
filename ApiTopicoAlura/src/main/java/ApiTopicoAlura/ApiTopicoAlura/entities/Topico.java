package ApiTopicoAlura.ApiTopicoAlura.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "topico", schema = "apitopico")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_topico", nullable = false)
    private Long id;

    @Column(name = "titulo", nullable = false, length = 300)
    private String titulo;

    @Column(name = "mensagem", nullable = false, length = 3000)
    private String mensagem;

    @Column(name = "data_criacao", nullable = false)
    private LocalDate dataCriacao;

    @Column(name = "status", nullable = false)
    private int status;

    @ManyToOne
    @JoinColumn(name = "id_curso", nullable = false)
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @OneToMany(mappedBy = "topico")
    private List<Resposta> resposta;

    public Topico(Long id, String titulo, String mensagem, LocalDate dataCriacao, int status, Usuario usuario, Curso curso) {
        this.id = id;
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.dataCriacao = dataCriacao;
        this.status = status;
        this.usuario = usuario;
        this.curso = curso;
    }

}
