public class MonthlyPaymentCalculator {

    private  double principal;
    private  double annualInterestRate;
    private  int totalYears;

    public MonthlyPaymentCalculator(double principal,double annualInterestRate, int totalYears){
        setPrincipal(principal);
        setAnnualInterestRate(annualInterestRate);
        setTotalYears(totalYears);

    }

    private void setPrincipal(double principal){

        this.principal = principal;
    }

    private double getPrincipal(){

        return principal;
    }

    private void setAnnualInterestRate(double annualInterestRate){

        this.annualInterestRate = annualInterestRate;
    }

    private double getAnnualInterestRate(){
        return annualInterestRate;
    }

    private void setTotalYears(int totalYears){

        this.totalYears = totalYears;
    }

    private int getTotalYears(){

        return totalYears;
    }

    public double monthlyPayment(){

        final int PERCENT = 100;

        final int MONTHS = 12;

        double totalMonthlyMorgagePayment = 0;

        double monthlyInterestRate = 0;

        monthlyInterestRate = (this.annualInterestRate / PERCENT) / MONTHS;

        double totalMonthlyMorgagePayments = this.totalYears * MONTHS;

        double numerand = monthlyInterestRate * (Math.pow(1 + monthlyInterestRate,totalMonthlyMorgagePayments));

        double denominator = (Math.pow(1 + monthlyInterestRate,totalMonthlyMorgagePayments)) - 1;

        totalMonthlyMorgagePayment = this.principal * (numerand / denominator);

        return totalMonthlyMorgagePayment;

    }

}

