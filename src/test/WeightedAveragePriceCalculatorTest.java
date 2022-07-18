package test;

import main.usecase.WeightedAveragePriceCalculator;
import org.junit.Assert;
import org.junit.Test;

public class WeightedAveragePriceCalculatorTest {

    @Test
    public void test_calculate_WeightedAveragePrice(){
        WeightedAveragePriceCalculator weightedAveragePriceCalculator = new WeightedAveragePriceCalculator();
        Double average = weightedAveragePriceCalculator.calculate(5, 20.00, 5, 10.00);
        Assert.assertEquals(average, 15.00, 0.001);
    }

}
