package ApiTopicoAlura.ApiTopicoAlura.controllers;

import ApiTopicoAlura.ApiTopicoAlura.DTO.login.DadosAutenticacao;
import ApiTopicoAlura.ApiTopicoAlura.DTO.login.DadosTokenJWT;
import ApiTopicoAlura.ApiTopicoAlura.entities.Usuario;
import ApiTopicoAlura.ApiTopicoAlura.service.utils.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dadosAutenticacao){

        var authenticationToken = new UsernamePasswordAuthenticationToken(dadosAutenticacao.email(), dadosAutenticacao.password());
        var authentication = authenticationManager.authenticate(authenticationToken);

        var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());

        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }


}
