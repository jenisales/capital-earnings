package main.usecase;

public class PaidTaxOperation {
    private Double tax;

    public PaidTaxOperation(Double tax) {
        this.tax = tax;
    }

    public Double getTax() {
        return tax;
    }

}
