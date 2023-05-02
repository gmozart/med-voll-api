package med.voll.medvollapi.service.agendamentoconsulta.service.validacoes;


import lombok.RequiredArgsConstructor;
import med.voll.medvollapi.dto.ConsultaDTO;
import med.voll.medvollapi.exception.ValidacaoException;
import med.voll.medvollapi.repository.PacienteRepository;
import med.voll.medvollapi.repository.ValidadorAgendamentoConsultasRepository;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class PacienteAtivo  implements ValidadorAgendamentoConsultasRepository {

    private final PacienteRepository pacienteRepository;

    public void validar(ConsultaDTO dadosAgendamentoConsulta){

        var pacienteAtivo = pacienteRepository.findById(dadosAgendamentoConsulta.getPacienteId());

        if(pacienteAtivo.isPresent() && pacienteAtivo.get().getAtivo().equals(false)){
            throw new ValidacaoException("Consulta não pode ser agendada com paciente inativo!");
        }
    }
}