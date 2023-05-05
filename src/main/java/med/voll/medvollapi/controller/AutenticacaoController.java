package med.voll.medvollapi.controller;


import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import med.voll.medvollapi.dto.UsuarioDTO;
import med.voll.medvollapi.entity.Usuario;
import med.voll.medvollapi.record.DadosTokenJWT;
import med.voll.medvollapi.security.TokenService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@SecurityRequirement(name = "bearer-key")
@RequestMapping("/login")
public class AutenticacaoController {

    private final AuthenticationManager manager;

    private final TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid UsuarioDTO usuarioDTO){
        var authenticationToken = new UsernamePasswordAuthenticationToken(usuarioDTO.getLogin(),usuarioDTO.getSenha());
        var authentication = manager.authenticate(authenticationToken);
        var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());

        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }


}
