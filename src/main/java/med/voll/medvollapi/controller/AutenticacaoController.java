package med.voll.medvollapi.controller;

import lombok.RequiredArgsConstructor;
import med.voll.medvollapi.dto.UsuarioDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/login")
public class AutenticacaoController {

    private final AuthenticationManager manager;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid UsuarioDTO usuarioDTO){
        var token = new UsernamePasswordAuthenticationToken(usuarioDTO.getLogin(),usuarioDTO.getSenha());
        var authentication = manager.authenticate(token);

        return ResponseEntity.ok().build();
    }

}
