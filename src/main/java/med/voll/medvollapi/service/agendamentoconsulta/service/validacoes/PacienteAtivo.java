package med.voll.medvollapi.service.agendamentoconsulta.service.validacoes;

import lombok.RequiredArgsConstructor;
import med.voll.medvollapi.exception.ValidacaoException;
import med.voll.medvollapi.repository.PacienteRepository;
import med.voll.medvollapi.repository.ValidadorAgendamentoConsultas;
import med.voll.medvollapi.transaction.response.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class PacienteAtivo  implements ValidadorAgendamentoConsultas {

    private final PacienteRepository pacienteRepository;

    public void validar(DadosAgendamentoConsulta dadosAgendamentoConsulta){

        var pacienteAtivo = pacienteRepository.findById(dadosAgendamentoConsulta.idPaciente());

        if(pacienteAtivo.isPresent() && pacienteAtivo.get().getAtivo().equals(false)){
            throw new ValidacaoException("Consulta não pode ser agendada com paciente inativo!");
        }
    }
}