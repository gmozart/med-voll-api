package med.voll.medvollapi.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import med.voll.medvollapi.entity.Consulta;
import med.voll.medvollapi.entity.Medico;
import med.voll.medvollapi.entity.Paciente;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Builder
public class ConsultaDTO {

    private Long id;

    private Long medicoId;

    private Long pacienteId;

    @Future
    private LocalDateTime data;

    public static ConsultaDTO of(Consulta consulta){
        return ConsultaDTO.builder()
                .id(consulta.getId())
                .medicoId(consulta.getMedico().getId())
                .pacienteId(consulta.getPaciente().getId())
                .data(consulta.getData())
                .build();
    }

    public static Consulta of(ConsultaDTO consultaDTO){
        return Consulta.builder()
                .id(consultaDTO.getId())
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