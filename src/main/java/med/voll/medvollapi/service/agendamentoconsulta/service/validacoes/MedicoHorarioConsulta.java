package med.voll.medvollapi.service.agendamentoconsulta.service.validacoes;

import lombok.RequiredArgsConstructor;
import med.voll.medvollapi.exception.ValidacaoException;
import med.voll.medvollapi.repository.ConsultaRepository;
import med.voll.medvollapi.transaction.response.DadosAgendamentoConsulta;

@RequiredArgsConstructor
public class MedicoHorarioConsulta {

    private final ConsultaRepository consulta;

    public void validar(DadosAgendamentoConsulta dados){

        var medicoPossuiConsulta = consulta.existsByMedicoIdAndData(dados.idMedico(), dados.data());

        if (medicoPossuiConsulta){
            throw  new ValidacaoException("Medico já possui consulta agendada neste horario!");
        }
    }
}