package inheritanceAndPolymorphism.entities.taxExample;

public class IndividualTaxPayer extends TaxPayers {

    private Double healthExpenditures;

    public IndividualTaxPayer(String name, Double annualIncome, Double healthExpenditures) {
        super(name, annualIncome);
        this.healthExpenditures = healthExpenditures;
    }

    public Double getHealthExpenditures() {
        return healthExpenditures;
    }

    public void setHealthExpenditures(Double healthExpenditures) {
        this.healthExpenditures = healthExpenditures;
    }

    @Override
    public Double tax() {
        if (getAnnualIncome() >= 20000.00 && getHealthExpenditures() == 0) {
            double taxes = getAnnualIncome() * 0.25;
            return taxes;
        } else if (getAnnualIncome() >= 20000.00 && getHealthExpenditures() > 0) {
            double taxes = getAnnualIncome() * 0.25;
            double total = taxes - (getHealthExpenditures() * 0.5);
            return total;
        } else if (getAnnualIncome() < 20000.00 && getHealthExpenditures() > 0) {
            double taxes = getAnnualIncome() * 0.15;
            double total = taxes - (getHealthExpenditures() * 0.5);
            return total;
        } else {
            double taxes = getAnnualIncome() * 0.15;
            return taxes;
        }
    }

    @Override
    public String toString() {
        return getName() + ": $" +String.format("%.2f", tax());
    }
}
