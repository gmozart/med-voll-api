package med.voll.medvollapi.repository;

import med.voll.medvollapi.entity.Medico;
import med.voll.medvollapi.enums.Especialidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface MedicoRepository extends JpaRepository<Medico, Long> {


    @Query("""
            
            """)
    Medico escolherMedicoLivreNaData(Especialidade especialidade, LocalDateTime data);
}
