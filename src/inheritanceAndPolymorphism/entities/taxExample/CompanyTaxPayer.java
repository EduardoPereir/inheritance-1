package inheritanceAndPolymorphism.entities.taxExample;

public class CompanyTaxPayer extends TaxPayers {

    private Integer numberOfEmployees;
    public CompanyTaxPayer(String name, Double annualIncome, Integer numberOfEmployees) {
        super(name, annualIncome);
        this.numberOfEmployees = numberOfEmployees;
    }

    public Integer getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(Integer numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public Double tax() {
        if (getNumberOfEmployees() > 10) {
            double taxes = getAnnualIncome() * 0.14;
            return taxes;
        } else  {
            double taxes = getAnnualIncome() * 0.16;
            return taxes;
        }
    }

    @Override
    public String toString() {
        return getName() + ": $" + String.format("%.2f", tax());
    }
}
