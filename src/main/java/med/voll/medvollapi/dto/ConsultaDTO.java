package med.voll.medvollapi.dto;

import lombok.Builder;
import lombok.Data;
import med.voll.medvollapi.entity.Consulta;
import med.voll.medvollapi.entity.Medico;
import med.voll.medvollapi.entity.Paciente;
import med.voll.medvollapi.enums.Especialidade;


import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Builder
public class ConsultaDTO {

    private Long id;

    @NotNull
    private Medico medico;

    @NotNull
    private Paciente paciente;

    @Future
    @NotNull
    private LocalDateTime data;

    public static ConsultaDTO of(Consulta consulta){
        return ConsultaDTO.builder()
                .id(consulta.getId())
                .medico(consulta.getMedico())
                .paciente(consulta.getPaciente())
                .data(consulta.getData())
                .build();
    }

    public static Consulta of(ConsultaDTO consultaDTO){
        return Consulta.builder()
                .id(consultaDTO.getId())
                .medico(consultaDTO.getMedico())
                .paciente(consultaDTO.getPaciente())
                .data(consultaDTO.getData())
                .build();
    }

    public static Optional<ConsultaDTO> of(Optional<Consulta> consulta){
        return consulta.stream().map(ConsultaDTO::of).findAny();
    }

    public static List<ConsultaDTO> of(List<Consulta> consultas){
        return consultas.stream().map(ConsultaDTO::of).collect(Collectors.toList());
    }
}