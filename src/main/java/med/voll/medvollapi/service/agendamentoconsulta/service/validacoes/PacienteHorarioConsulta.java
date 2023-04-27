package med.voll.medvollapi.service.agendamentoconsulta.service.validacoes;


import lombok.RequiredArgsConstructor;
import med.voll.medvollapi.exception.ValidacaoException;
import med.voll.medvollapi.repository.ConsultaRepository;
import med.voll.medvollapi.repository.ValidadorAgendamentoConsultas;
import med.voll.medvollapi.transaction.response.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class PacienteHorarioConsulta  implements ValidadorAgendamentoConsultas {

    private final ConsultaRepository consultaRepository;



    public void validar(DadosAgendamentoConsulta dadosAgendamentoConsulta){

        var inicioHorarioConsulta = 7;
        var fimHorarioConsulta = 18;
        var primeiroHorario = dadosAgendamentoConsulta.data().withHour(inicioHorarioConsulta);
        var ultimoHorario = dadosAgendamentoConsulta.data().withHour(fimHorarioConsulta);
        var medicoPossuiConsulta = consultaRepository.existsByPacienteIdAndDataBetween(dadosAgendamentoConsulta.idPaciente(), primeiroHorario, ultimoHorario);

        if (medicoPossuiConsulta){
            throw  new ValidacaoException("Paciente já possui consulta agendada neste horario!");
        }
    }
}