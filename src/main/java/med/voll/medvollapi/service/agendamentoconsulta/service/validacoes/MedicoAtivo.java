package med.voll.medvollapi.service.agendamentoconsulta.service.validacoes;

import lombok.RequiredArgsConstructor;
import med.voll.medvollapi.exception.ValidacaoException;
import med.voll.medvollapi.repository.MedicoRepository;
import med.voll.medvollapi.repository.ValidadorAgendamentoConsultas;
import med.voll.medvollapi.transaction.response.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
public class MedicoAtivo implements ValidadorAgendamentoConsultas {

    private final MedicoRepository medico;

    public void validar(DadosAgendamentoConsulta dadosAgendamentoConsulta){

        var medicoAtivo = medico.findById(dadosAgendamentoConsulta.idMedico());

        if(medicoAtivo.isPresent() && medicoAtivo.get().getSnAtivo().equals(false)){
            throw new ValidacaoException("Consulta não pode ser agendada com paciente inativo!");
        }
    }
}