package med.voll.medvollapi.transaction.response;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import med.voll.medvollapi.enums.Especialidade;

import java.time.LocalDateTime;

public record DadosAgendamentoConsulta(

        Long idMedico,

        @NotNull
        Long idPaciente,

        @NotNull
        @Future
        LocalDateTime data,

        Especialidade especialidade){
}
