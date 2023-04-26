package med.voll.medvollapi.service.agendamentoconsulta.service.validacoes;

import lombok.RequiredArgsConstructor;
import med.voll.medvollapi.exception.ValidacaoException;
import med.voll.medvollapi.repository.MedicoRepository;
import med.voll.medvollapi.transaction.response.DadosAgendamentoConsulta;

@RequiredArgsConstructor
public class MedicoAtivo {

    private final MedicoRepository medico;

    public void validar(DadosAgendamentoConsulta dados){

        var medicoAtivo = medico.findById(dados.idMedico());

        if(medicoAtivo.isPresent() && medicoAtivo.get().getSnAtivo().equals(false)){
            throw new ValidacaoException("Consulta não pode ser agendada com paciente inativo!");
        }
    }
}