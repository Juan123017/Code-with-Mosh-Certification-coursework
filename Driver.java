/* Author: Juan Rincon
    Date: 12/19/22
    Purpose: Calculate monthly morgage Payment, schedule and number of payments. Written to showcase object oriented programming, 
    Java programming, and basic Java fundamentals skills.
    */

public class Driver {

    final static double MIN_PRINCIPAL = 1000;

    final static double MAX_PRINCIPAL = 1_000_000;

    final static double MIN_INTEREST = 0;

    final static double MAX_INTEREST = 30;

    final static int MIN_YEARS = 1;

    final static int MAX_YEARS = 30;

    public static void main(String[] args){

        int years = 0;
        double principal = 0;
        double annualInterestRate = 0;
        double monthlyPayment = 0;



        years =(int) UserInput.getInput("YEARS: ", MIN_YEARS,MAX_YEARS,"YEARS CANNOT BE LESS THAN 0 OR MORE THAN 30!!!");
        principal = UserInput.getInput("PRINCIPAL: ", MIN_PRINCIPAL,MAX_PRINCIPAL,"PRINCIPAL CANNOT BE LESS THAN $1,000.00 OR MORE THAN $1,000,000.00!!!");
        annualInterestRate = UserInput.getInput("ANNUAL INTEREST: ",MIN_INTEREST,MAX_INTEREST,"INTEREST CANNOT BE LESS THAN 0% OR MORE THAN 30%" );

        var monthlyPaymentCalc = new MonthlyPaymentCalculator(principal,annualInterestRate,years);

       monthlyPayment = monthlyPaymentCalc.monthlyPayment();

       PaymentSchedule.monthlyPaymentSchedule(principal,monthlyPayment);

        




    }


}
