package med.voll.medvollapi.service.agendamentoconsulta.service.validacoes;


import lombok.RequiredArgsConstructor;
import med.voll.medvollapi.dto.ConsultaDTO;
import med.voll.medvollapi.exception.ValidacaoException;
import med.voll.medvollapi.repository.MedicoRepository;
import med.voll.medvollapi.repository.ValidadorAgendamentoConsultasRepository;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MedicoAtivo implements ValidadorAgendamentoConsultasRepository {

    private final MedicoRepository medico;

    public void validar(ConsultaDTO dadosAgendamentoConsulta){

        var medicoAtivo = medico.findById(dadosAgendamentoConsulta.getMedicoId());

        if(medicoAtivo.isPresent() && medicoAtivo.get().getAtivo().equals(false)){
            throw new ValidacaoException("Consulta não pode ser agendada com paciente inativo!");
        }
    }
}