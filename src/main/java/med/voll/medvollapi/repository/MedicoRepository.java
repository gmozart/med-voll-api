package med.voll.medvollapi.repository;


import med.voll.medvollapi.entity.Medico;
import med.voll.medvollapi.enums.Especialidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface MedicoRepository extends JpaRepository<Medico, Long> {


    @Query(
            value = "    SELECT m.id FROM Medicos m " +
            "WHERE" +
            "m.ativo = 1" +
            "AND" +
            "m.especialidade = :especialidade" +
            "AND" +
            "m.id NOT IN(" +
            "SELECT c.medico_id FROM Consultas c"+
            "WHERE"+
            "c.data = :data"+
            ")"+
            " ORDER BY RAND() "+
            " LIMIT 1 ", nativeQuery = true)
    Medico escolherMedicoLivreNaData(Especialidade especialidade, LocalDateTime data);
}
