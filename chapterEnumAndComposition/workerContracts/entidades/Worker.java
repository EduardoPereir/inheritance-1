package FUNDAMENTALS.enumEComposicao.workerContracts.entidades;

import FUNDAMENTALS.enumEComposicao.workerContracts.entidades.enums.WorkerLevel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Worker {
    private String name;
    private WorkerLevel level;
    private Double baseSalary;
    private Department department;
    private List<HourContract> contracts = new ArrayList<>();

    public Worker(String name, WorkerLevel level, Double baseSalary, Department department){
     this.name =name;
     this.level = level;
     this.baseSalary = baseSalary;
     this.department = department;
    }

    public Department getDepartment() {
        return department;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public WorkerLevel getLevel() {
        return level;
    }
    public void setLevel(WorkerLevel level) {
        this.level = level;
    }
    public Double getBaseSalary() {
        return baseSalary;
    }
    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }
    public List<HourContract> getContracts(){
        return contracts;
    }

    public double incomeSalary(Integer month, Integer year){
        double total = baseSalary;
        Calendar calendar = Calendar.getInstance();
        for (HourContract c: contracts ) {
            calendar.setTime(c.getDate());
            int c_month = 1 +  calendar.get(Calendar.MONTH);
            int c_year = calendar.get(Calendar.YEAR);
            if (c_month == month && c_year == year) {
                total += c.totalValue();
            }
        }
        return total;
    }

    public void addContract( HourContract contract){
        contracts.add(contract);
    }

    public void removeContract ( HourContract contract){
        contracts.remove(contract);
    }

}
