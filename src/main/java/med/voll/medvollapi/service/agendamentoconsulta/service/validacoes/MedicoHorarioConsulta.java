package med.voll.medvollapi.service.agendamentoconsulta.service.validacoes;


import lombok.RequiredArgsConstructor;
import med.voll.medvollapi.dto.ConsultaDTO;
import med.voll.medvollapi.exception.ValidacaoException;
import med.voll.medvollapi.repository.ConsultaRepository;
import med.voll.medvollapi.repository.ValidadorAgendamentoConsultasRepository;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MedicoHorarioConsulta implements ValidadorAgendamentoConsultasRepository {

    private final ConsultaRepository consultaRepository;

    public void validar(ConsultaDTO dadosAgendamentoConsulta){

        var medicoPossuiConsulta = consultaRepository.existsByMedicoIdAndData(dadosAgendamentoConsulta.getMedicoId(), dadosAgendamentoConsulta.getData());

        if (medicoPossuiConsulta){
            throw  new ValidacaoException("Medico já possui consulta agendada neste horario!");
        }
    }
}