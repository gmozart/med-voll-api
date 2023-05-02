package med.voll.medvollapi.service.agendamentoconsulta.service.validacoes;


import lombok.RequiredArgsConstructor;
import med.voll.medvollapi.dto.ConsultaDTO;
import med.voll.medvollapi.exception.ValidacaoException;
import med.voll.medvollapi.repository.ConsultaRepository;
import med.voll.medvollapi.repository.ValidadorAgendamentoConsultasRepository;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class PacienteHorarioConsulta  implements ValidadorAgendamentoConsultasRepository {

    private final ConsultaRepository consultaRepository;

    public void validar(ConsultaDTO dadosAgendamentoConsulta){

        var inicioHorarioConsulta = 7;
        var fimHorarioConsulta = 18;
        var primeiroHorario = dadosAgendamentoConsulta.getData().withHour(inicioHorarioConsulta);
        var ultimoHorario = dadosAgendamentoConsulta.getData().withHour(fimHorarioConsulta);
        var medicoPossuiConsulta = consultaRepository.existsByPacienteIdAndDataBetween(dadosAgendamentoConsulta.getPacienteId(), primeiroHorario, ultimoHorario);

        if (medicoPossuiConsulta){
            throw  new ValidacaoException("Paciente já possui consulta agendada neste horario!");
        }
    }
}