package main;

import java.util.Scanner;
import main.service.CapitalEarningsService;

public class CapitalEarnings {
    public static void main(String[] args){
        Scanner operationsIn = new Scanner(System.in);
        String operations;
        while(operationsIn.hasNext()){
            operations = operationsIn.nextLine();
            calculateCapitalEarning(operations);
        }
    }

    private static void calculateCapitalEarning(String operations) {
        CapitalEarningsService capitalEarningsService = new CapitalEarningsService();
        capitalEarningsService.calculateOperations(operations);
    }
}
