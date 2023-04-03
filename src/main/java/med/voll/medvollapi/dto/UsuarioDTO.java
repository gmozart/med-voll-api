package med.voll.medvollapi.dto;

import lombok.Builder;
import lombok.Data;
import med.voll.medvollapi.entity.Usuario;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Builder
public class UsuarioDTO {

    private Long id;
    private String login;
    private String senha;

    public static UsuarioDTO of(Usuario usuario){
        return UsuarioDTO.builder()
                .id(usuario.getId())
                .login(usuario.getLogin())
                .senha(usuario.getSenha())
                .build();
    }
    public static Usuario of(UsuarioDTO usuarioDTO){
        return Usuario.builder()
                .id(usuarioDTO.getId())
                .login(usuarioDTO.getLogin())
                .senha(usuarioDTO.getSenha())
                .build();
    }
    public static Optional<UsuarioDTO> of(Optional<Usuario> usuario){
        return usuario.stream().map(UsuarioDTO::of).findAny();
    }
    public static List<UsuarioDTO> of(List<Usuario> usuarios){
        return usuarios.stream().map(UsuarioDTO::of).collect(Collectors.toList());
    }
}