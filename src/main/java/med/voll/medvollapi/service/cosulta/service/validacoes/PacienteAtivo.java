package med.voll.medvollapi.service.cosulta.service.validacoes;

import lombok.RequiredArgsConstructor;
import med.voll.medvollapi.exception.ValidacaoException;
import med.voll.medvollapi.repository.PacienteRepository;
import med.voll.medvollapi.transaction.response.DadosAgendamentoConsulta;

@RequiredArgsConstructor
public class PacienteAtivo {

    private final PacienteRepository paciente;

    public void validar(DadosAgendamentoConsulta dados){

        var pacienteAtivo = paciente.findById(dados.idPaciente());
        var snAtivo = pacienteAtivo.get().getAtivo();

        if (!snAtivo){
            throw new ValidacaoException("Consulta não pode ser agendada com paciente inativo!");
        }
    }
}