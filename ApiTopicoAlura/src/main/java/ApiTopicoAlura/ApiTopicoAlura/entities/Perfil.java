package ApiTopicoAlura.ApiTopicoAlura.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "perfil", schema = "apitopico")
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_perfil", nullable = false, length = 300)
    private String nome;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
