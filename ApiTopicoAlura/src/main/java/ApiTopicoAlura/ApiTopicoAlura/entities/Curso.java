package ApiTopicoAlura.ApiTopicoAlura.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "curso", schema = "apitopico")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false, length = 300)
    private String nome;

    @Column(name = "categoria", nullable = false, length = 300)
    private String categoria;

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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
