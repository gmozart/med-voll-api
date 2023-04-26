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

    private final ConsultaRepository consulta;

    public void validar(DadosAgendamentoConsulta dados){

        var primeiroHorario = dados.data().withHour(7);
        var ultimoHorario = dados.data().withHour(18);
        var medicoPossuiConsulta = consulta.existsByPacienteIdAndDataBetween(dados.idPaciente(), primeiroHorario, ultimoHorario);

        if (medicoPossuiConsulta){
            throw  new ValidacaoException("Paciente já possui consulta agendada neste horario!");
        }
    }
}