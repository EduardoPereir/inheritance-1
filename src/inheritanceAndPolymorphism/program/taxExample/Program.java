package inheritanceAndPolymorphism.program.taxExample;


import inheritanceAndPolymorphism.entities.taxExample.CompanyTaxPayer;
import inheritanceAndPolymorphism.entities.taxExample.IndividualTaxPayer;
import inheritanceAndPolymorphism.entities.taxExample.TaxPayers;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {


        Scanner scanner = new Scanner(System.in);

        List<TaxPayers> taxpayers = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {

            System.out.println("\nTax payer #" + (i + 1) + " data: ");
            System.out.print("Individual or company (i/c) ? ");
            char answer = scanner.next().charAt(0);

            System.out.print("Name: ");
            String name = scanner.next();
            System.out.print("Annual Income: ");
            Double annualIncome = scanner.nextDouble();

            if (answer == 'i') {
                System.out.print("Health expenditures: ");
                Double healthExp = scanner.nextDouble();
                taxpayers.add(new IndividualTaxPayer(name, annualIncome, healthExp));
            }
            if (answer == 'c') {
                System.out.print("Number of employees:  ");
                int nOfEmployees = scanner.nextInt();
                taxpayers.add(new CompanyTaxPayer(name, annualIncome, nOfEmployees));
            }

        }
        System.out.println(" \nTAXES PAID: ");
        double sum = 0.0;

        for (TaxPayers p : taxpayers) {
            System.out.println(p.toString());
            sum += p.tax();
        }

        System.out.println("\nTotal taxes: " + sum);
        scanner.close();
    }
}
