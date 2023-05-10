package med.voll.medvollapi.repository;

import lombok.RequiredArgsConstructor;
import med.voll.medvollapi.dto.ConsultaDTO;
import med.voll.medvollapi.dto.MedicoDTO;
import med.voll.medvollapi.dto.PacienteDTO;
import med.voll.medvollapi.entity.Consulta;
import med.voll.medvollapi.entity.Endereco;
import med.voll.medvollapi.entity.Medico;
import med.voll.medvollapi.entity.Paciente;
import med.voll.medvollapi.enums.Especialidade;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
@RequiredArgsConstructor
class MedicoRepositoryTest {


    private MedicoRepository medicoRepository;

    private PacienteDTO pacienteDTO;

    private MedicoDTO medicoDTO;

    private ConsultaDTO consultaDTO;

    private TestEntityManager entityManager;

    @Test
    @DisplayName("Devolver null qundo único médico cadastrado não esta disponivel na data")
    void escolherMedicoLivreNaData() {

        var proximaSegunda = LocalDate.now()
                .with(TemporalAdjusters.next(DayOfWeek.MONDAY))
                .atTime(10,0);

        var medico = dadosMedico();
        var paciente = dadosPaciente();


        var medicoLivre = medicoRepository.escolherMedicoLivreNaData(Especialidade.CARDIOLOGIA, proximaSegunda);
        assertThat(medicoLivre).isNull();

    }



    private void cadastrarConsulta(Medico medico, Paciente paciente, LocalDateTime data) {
        entityManager.persist(ConsultaDTO.of(new Consulta(null, medico, paciente, data)));
    }

    private MedicoDTO cadastrarMedico(){
        return entityManager.persist(dadosMedico());
    }

    private PacienteDTO cadastrarPaciente(){
        return entityManager.persist(dadosPaciente());
    }

    private PacienteDTO dadosPaciente(){
       return pacienteDTO = PacienteDTO.of(
               new Paciente(3l,
                       "Paciente Teste",
                       "email test",
                "6199568501",
                       "1635451",
                       dadosEndereco(),
                       true));

    }
    private MedicoDTO dadosMedico(){
        return medicoDTO = MedicoDTO.of(
                new Medico(3L,
                        "Medico Teste",
                        "11111111",
                        "TESTE@EMAIL.COM",
                        "111111",
                        Especialidade.CARDIOLOGIA,
                        dadosEndereco(),
                        true
                ));
    }
    private Endereco dadosEndereco(){
        return new Endereco(
                "teste logradouro",
                61,
                "teste complemento",
                "teste bairro",
                "Recife",
                "PE",
                "00000"
        );
    }
}











