package main.usecase;

public class WeightedAveragePriceCalculator {

    public Double calculate(Integer currentQuantity, Double currentAverage, Integer purchasedQuantity, Double purchasePrice){
        return ((currentQuantity * currentAverage) + (purchasedQuantity * purchasePrice)) / (currentQuantity + purchasedQuantity);
    }

}
