package med.voll.medvollapi.dto;

import lombok.Builder;
import lombok.Data;
import med.voll.medvollapi.entity.Endereco;
import med.voll.medvollapi.entity.Paciente;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Builder
public class PacienteDTO {

    private Long id;
    @NotBlank
    private String nome;
    @NotBlank
    private String email;
    @NotBlank
    private String telefone;
    @NotBlank
    private String cpf;
    @NotBlank
    private Endereco endereco;
    private Boolean ativo;

    public static PacienteDTO of(Paciente paciente){
        return PacienteDTO.builder()
                .id(paciente.getId())
                .nome(paciente.getNome())
                .email(paciente.getEmail())
                .telefone(paciente.getTelefone())
                .cpf(paciente.getCpf())
                .endereco(paciente.getEndereco())
                .ativo(paciente.getAtivo())
                .build();
    }
    public static Paciente of(PacienteDTO pacienteDTO){
        return Paciente.builder()
                .id(pacienteDTO.getId())
                .nome(pacienteDTO.getNome())
                .email(pacienteDTO.getEmail())
                .telefone(pacienteDTO.getTelefone())
                .cpf(pacienteDTO.getCpf())
                .endereco(pacienteDTO.getEndereco())
                .ativo(pacienteDTO.getAtivo())
                .build();
    }
    public static Optional<PacienteDTO> of(Optional<Paciente> paciente){
        return paciente.stream().map(PacienteDTO::of).findAny();
    }
    public static List<PacienteDTO> of(List<Paciente> pacientes){
        return pacientes.stream().map(PacienteDTO::of).collect(Collectors.toList());
    }
}