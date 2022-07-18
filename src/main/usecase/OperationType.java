package main.usecase;

public enum OperationType {
    SELL("sell"),
    BUY("buy");

    private String descricao;

    OperationType(String descricao) {
        this.descricao = descricao;
    }


    public String getDescricao(){
        return descricao;
    }
}
