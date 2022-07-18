package main.usecase;

public class Operation {
    private OperationType operationType;
    private Double unitCost;
    private Integer quantity;

    public Operation(OperationType operationType, Double unitCost, Integer quantity) {
        this.operationType = operationType;
        this.unitCost = unitCost;
        this.quantity = quantity;
    }

    public OperationType getOperationType(){
        return operationType;
    }
    public Double getUnitCost() {
        return unitCost;
    }

    public Integer getQuantity() {
        return quantity;
    }
}

