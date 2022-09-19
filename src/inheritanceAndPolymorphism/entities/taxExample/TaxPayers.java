package inheritanceAndPolymorphism.entities.taxExample;

public abstract class TaxPayers {

    private  String name;
    private Double annualIncome;

    public TaxPayers(String name, Double annualIncome) {
        this.name = name;
        this.annualIncome = annualIncome;
    }

    public TaxPayers() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(Double annualIncome) {
        this.annualIncome = annualIncome;
    }

    public  abstract Double tax();
    public abstract  String toString();
}
