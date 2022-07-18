package main.usecase;

import java.security.cert.TrustAnchor;
import java.util.LinkedList;
import java.util.List;

public class CapitalEarningsCalculator implements TaxCalculator{

    private Double FREE_TAX = 0.00;

    private Boolean firstBuyOperation = true;

    private WeightedAveragePriceCalculator averagePriceCalculator;

    public CapitalEarningsCalculator(){
        this.averagePriceCalculator = new WeightedAveragePriceCalculator();
    }

    @Override
    public List<PaidTaxOperation> calculate(List<Operation> operations) {
        List<PaidTaxOperation> paidTaxOperations = new LinkedList<>();
        Double averagePrice = 0.0;
        Double earnings = 0.0;
        Double totalValueOperation = 0.0;
        Double taxCalculated = 0.0;
        Double percentual = 20.00 / 100.0;

        for (Operation operation: operations){
            boolean isBuyOperation = operation.getOperationType() == OperationType.BUY;

            if (isBuyOperation){
                paidTaxOperations.add(new PaidTaxOperation(FREE_TAX));
                if (firstBuyOperation){
                    averagePrice = operation.getUnitCost();
                    firstBuyOperation = false;
                }
            }else {
                if (operation.getUnitCost() > averagePrice){
                    earnings = operation.getUnitCost() - averagePrice;
                    if (earnings >= averagePrice){
                        totalValueOperation = earnings * operation.getQuantity();
                        taxCalculated = totalValueOperation * percentual;
                        paidTaxOperations.add(new PaidTaxOperation(taxCalculated));
                        System.out.println("Teste");
                    }else {
                        paidTaxOperations.add(new PaidTaxOperation(FREE_TAX));
                    }
                }else {
                    paidTaxOperations.add(new PaidTaxOperation(FREE_TAX));
                }

            }
        }
        return paidTaxOperations;
    }

}
