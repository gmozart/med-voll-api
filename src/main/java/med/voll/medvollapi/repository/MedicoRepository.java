package med.voll.medvollapi.repository;

import med.voll.medvollapi.entity.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
}
