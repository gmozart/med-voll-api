package entity;

import javax.persistence.Embeddable;

@Embeddable
public class Endereco {

    private String logradouro;
    private Integer numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;


}
