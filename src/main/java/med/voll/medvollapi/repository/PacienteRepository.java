package med.voll.medvollapi.repository;

import med.voll.medvollapi.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {


}
