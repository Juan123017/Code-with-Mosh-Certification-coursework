import java.util.Scanner;
import java.text.NumberFormat;

public class PaymentSchedule{
	
	public static void main(String[] args){

		final double MIN_PRINCIPAL = 1000;

		final double MAX_PRINCIPAL = 1_000_000;

		final double MIN_INTEREST = 0;

		final double MAX_INTEREST = 30;

		final double MIN_YEARS = 1;

		final double MAX_YEARS = 30;

		double monthlyPayment = 0;

		double principal = 0;

		double annualInterestRate = 0;

		int totalYears = 0;

		NumberFormat formattedCurrency = NumberFormat.getCurrencyInstance();

		principal = input("Principal: ",MIN_PRINCIPAL, MAX_PRINCIPAL, "Enter a value between " + MIN_PRINCIPAL + " and " + MAX_PRINCIPAL);

		annualInterestRate = input("Annual Interest Rate: ",MIN_INTEREST, MAX_INTEREST, "Enter a value between " + MAX_INTEREST + " and " + MAX_INTEREST);

		totalYears = (int)input("Years: ", MIN_YEARS,MAX_YEARS,"Enter a value between " + MIN_YEARS + " and " + MAX_YEARS);

		System.out.println("********* MONTHLY PAYMENT *********");

		String formattedMonthlyPayment = formattedCurrency.format(monthlyPayment(principal, annualInterestRate,totalYears));

		System.out.println(formattedMonthlyPayment);

		monthlyPaymentSchedule(principal,monthlyPayment(principal, annualInterestRate, totalYears));

	}

	public static double input(String prompt, double min, double max, String warningMessage){

		Scanner input = new Scanner(System.in);

		double value = 0;

		while(true){

			System.out.println(prompt);

			value = input.nextDouble();

			if(value >= min && value <= max )
				break;

			System.out.println(warningMessage);
		}

		return value; 
	}



	public static double monthlyPayment(double principal, double annualInterestRate, int totalYears ){

		final int PERCENT = 100;

		final int MONTHS = 12;

		double totalMonthlyMorgagePayment = 0;

		double monthlyInterestRate = 0;

		monthlyInterestRate = (annualInterestRate / PERCENT) / MONTHS;

		double totalMonthlyMorgagePayments = totalYears * MONTHS;

		double numerand = monthlyInterestRate * (Math.pow(1 + monthlyInterestRate,totalMonthlyMorgagePayments));

		double denominator = (Math.pow(1 + monthlyInterestRate,totalMonthlyMorgagePayments)) - 1;

		totalMonthlyMorgagePayment = principal * (numerand / denominator);

		return totalMonthlyMorgagePayment;

	}

	public static void monthlyPaymentSchedule(double principal, double totalMonthlyMorgagePayment){

		String formattedPrincipal = null;

		int paymentCounter = 0;

		NumberFormat formattedCurrency = NumberFormat.getCurrencyInstance();

		System.out.println("********* PAYMENT SCHEDULE *********");

		while(principal > 0){

			paymentCounter++;

			principal = principal - totalMonthlyMorgagePayment;

			formattedPrincipal = formattedCurrency.format(principal);

			if(principal >= totalMonthlyMorgagePayment)
				System.out.println(formattedPrincipal);
		}

		System.out.println("Total MOnthly Payments: " + paymentCounter);

	}
}














