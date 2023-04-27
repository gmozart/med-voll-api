package med.voll.medvollapi.entity;

import jakarta.persistence.Embeddable;
import lombok.*;


@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Endereco {

    private String logradouro;
    private Integer numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
}