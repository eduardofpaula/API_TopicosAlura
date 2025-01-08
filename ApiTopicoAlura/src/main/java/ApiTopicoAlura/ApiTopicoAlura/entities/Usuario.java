package ApiTopicoAlura.ApiTopicoAlura.entities;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "usuario", schema = "apitopico")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;

    @Column(name = "nome_usuario", nullable = false, length = 300)
    private String nome;

    @Column(name = "email", length = 300, unique = true)
    private String email;

    @Column(name = "senha", nullable = false, length = 300)
    private String senha;

    @ManyToMany
    @JoinTable(name = "usuario_perfil", schema = "apitopico",
            joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_perfil"))
    private List<Perfil> perfil;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Perfil> getPerfil() {
        return perfil;
    }

    public void setPerfil(List<Perfil> perfil) {
        this.perfil = perfil;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Adapte a lógica para controlar expiração de conta, se necessário.
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Adapte para controlar bloqueio de conta.
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Adapte para controlar expiração de credenciais.
    }

    @Override
    public boolean isEnabled() {
        return true; // Adapte para controlar se a conta está ativa.
    }
}
