package FUNDAMENTALS.enumEComposicao.workerContracts.aplicacao;

import FUNDAMENTALS.enumEComposicao.workerContracts.entidades.Department;
import FUNDAMENTALS.enumEComposicao.workerContracts.entidades.HourContract;
import FUNDAMENTALS.enumEComposicao.workerContracts.entidades.Worker;
import FUNDAMENTALS.enumEComposicao.workerContracts.entidades.enums.WorkerLevel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {

        Scanner scanner = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter department's name: ");
        Department department = new Department(scanner.next());
        System.out.println("Enter worker data:");
        System.out.print("Name:");
        String name = scanner.next();
        System.out.print("Level:");
        String level = scanner.next();
        System.out.print("Base salary:");
        Double baseSalary = scanner.nextDouble();
        Worker worker = new Worker(name, WorkerLevel.valueOf(level), baseSalary, department);

        System.out.print("\nHow many contracts to this worker have? ");
        Integer contractsCount = scanner.nextInt();

        for (int i = 0; i < contractsCount; i++) {
            System.out.printf("Enter Contract #%d data: ", i + 1);
            System.out.println("\nDate (DD/MM/YYYY): ");
            Date date = sdf.parse(scanner.next());
            System.out.println("Value per hour: ");
            Double valuePerHour = scanner.nextDouble();
            System.out.println("Duration (hours): ");
            Integer hours = scanner.nextInt();
            HourContract contract = new HourContract(date, valuePerHour, hours);
            worker.addContract(contract);
        }

        System.out.println();
        System.out.println("Enter month and year to calculate income (MM/yyyy):  ");
        String monthAndYear = scanner.next();
        int month = Integer.parseInt(monthAndYear.substring(0,2));
        int year = Integer.parseInt(monthAndYear.substring(3));
        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartment().getName());
        System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.incomeSalary(month, year)));

        scanner.close();

    }
}
