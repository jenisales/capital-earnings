package test;


import main.usecase.*;
import org.junit.Assert;

import org.junit.Test;


import java.util.LinkedList;
import java.util.List;


public class CapitalEarningsCalculatorTest {

    @Test
    public void test_calculate_BuyOperation(){
        Operation operation1 = new Operation(OperationType.BUY, 10.00, 10000);
        Operation operation2 = new Operation(OperationType.SELL, 20.00, 5000);

        List<Operation> operations = new LinkedList<>();
        operations.add(operation1);
        operations.add(operation2);

        TaxCalculator calculator = new CapitalEarningsCalculator();
        List<PaidTaxOperation> paidTaxOperations= calculator.calculate(operations);
        Double operation1Tax = paidTaxOperations.get(0).getTax();

        Assert.assertEquals(paidTaxOperations.size(),2);
        Assert.assertEquals(operation1Tax, 0.00, 0.001);

    }



    @Test
    public void test_calculate_CapitalEarningTotalValueLessThan20000(){
        Operation operation1 = new Operation(OperationType.BUY, 10.00, 100);
        Operation operation2 = new Operation(OperationType.SELL, 15.00, 50);
        Operation operation3 = new Operation(OperationType.SELL, 15.00, 50);

        List<Operation> operations = new LinkedList<>();
        operations.add(operation1);
        operations.add(operation2);
        operations.add(operation3);

        TaxCalculator calculator = new CapitalEarningsCalculator();
        List<PaidTaxOperation> paidTaxOperations= calculator.calculate(operations);

        Double operation1Tax1 = paidTaxOperations.get(0).getTax();
        Double operation1Tax2 = paidTaxOperations.get(1).getTax();
        Double operation1Tax3 = paidTaxOperations.get(2).getTax();

        Assert.assertEquals(paidTaxOperations.size(),3);
        Assert.assertEquals(operation1Tax1, 0.00, 0.001);
        Assert.assertEquals(operation1Tax2, 0.00, 0.001);
        Assert.assertEquals(operation1Tax3, 0.00, 0.001);

    }

    @Test
    public void test_calculate_CapitalEarningTotalValueWithTax(){
        Operation operation1 = new Operation(OperationType.BUY, 10.00, 10000);
        Operation operation2 = new Operation(OperationType.SELL, 20.00, 5000);
        Operation operation3 = new Operation(OperationType.SELL, 5.00, 5000);

        List<Operation> operations = new LinkedList<>();
        operations.add(operation1);
        operations.add(operation2);
        operations.add(operation3);

        TaxCalculator calculator = new CapitalEarningsCalculator();
        List<PaidTaxOperation> paidTaxOperations= calculator.calculate(operations);

        Double operation1Tax1 = paidTaxOperations.get(0).getTax();
        Double operation1Tax2 = paidTaxOperations.get(1).getTax();
        Double operation1Tax3 = paidTaxOperations.get(2).getTax();

        Assert.assertEquals(paidTaxOperations.size(),3);
        Assert.assertEquals(operation1Tax1, 0.00, 0.001);
        Assert.assertEquals(operation1Tax2, 10000.00, 0.001);
        Assert.assertEquals(operation1Tax3, 0.00, 0.001);

    }

}
