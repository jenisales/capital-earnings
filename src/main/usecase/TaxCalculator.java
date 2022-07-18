package main.usecase;

import java.util.List;

public interface TaxCalculator {

    List<PaidTaxOperation> calculate(List<Operation> operations);

}
