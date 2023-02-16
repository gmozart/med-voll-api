package entity;

import enums.Especialidade;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="medicos")
public class Medico {

    @Id
    private Long id;
    private String nome;
    private Integer telefone;
    private String email;
    private Integer crm;
    private Especialidade especialidade;
    private Endereco endereco;

}
