package med.voll.medvollapi.enums;

public enum Especialidade {

    ORTOPEDIA(1,"ORTOPEDIA"),
    CARDIOLOGIA(2,"CARDIOLOGIA"),
    GINECOLOGIA(3,"GINECOLOGIA"),
    DERMATOLOGIA(4, "DERMATOLOGIA");

    private int cod;

    private String descricao;


    Especialidade(int cod, String descricao){
        this.cod = cod;
        this.descricao = descricao;
    }

    public Integer getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Especialidade toEnum(Integer cod) {

        if (cod == null) {

            return null;
        }
        for (Especialidade x : Especialidade.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Id inválido" + cod);
    }

}
