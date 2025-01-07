package ApiTopicoAlura.ApiTopicoAlura.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "usuario", schema = "apitopico")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Usuario{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;

    @Column(name = "nome_usuario", nullable = false, length = 300)
    private String nome;

    @Column(name = "email", nullable = false, length = 300, unique = true)
    private String email;

    @Column(name = "senha", nullable = false, length = 300)
    private String password;

    @ManyToMany
    @JoinTable(name = "usuario_perfil", schema = "apitopico",
            joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_perfil"))
    private List<Perfil> perfil;

}
