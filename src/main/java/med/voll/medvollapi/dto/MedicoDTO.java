package med.voll.medvollapi.dto;

import med.voll.medvollapi.entity.Endereco;
import med.voll.medvollapi.entity.Medico;
import med.voll.medvollapi.enums.Especialidade;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Builder
public class MedicoDTO {

    private Long id;
    @NotBlank
    private String nome;
    @NotBlank
    private String telefone;
    @NotBlank
    private String email;
    @NotBlank
    private String crm;

    private Especialidade especialidade;

    private Endereco endereco;

    public static MedicoDTO of(Medico medico){
        return MedicoDTO.builder()
                .id(medico.getId())
                .nome(medico.getNome())
                .telefone(medico.getTelefone())
                .email(medico.getEmail())
                .crm(medico.getCrm())
                .especialidade(medico.getEspecialidade())
                .endereco(medico.getEndereco())
                .build();
    }

    public static Medico of(MedicoDTO medicoDTO){
        return Medico.builder()
                .id(medicoDTO.getId())
                .nome(medicoDTO.getNome())
                .telefone(medicoDTO.getTelefone())
                .email(medicoDTO.getEmail())
                .crm(medicoDTO.getCrm())
                .especialidade(medicoDTO.getEspecialidade())
                .endereco(medicoDTO.getEndereco())
                .build();
    }

    public static Optional<MedicoDTO> of(Optional<Medico> medico){
        return medico.stream().map(MedicoDTO::of).findAny();
    }

    public static List<MedicoDTO> of(List<Medico> medico){
        return medico.stream().map(MedicoDTO::of).collect(Collectors.toList());
    }
}
