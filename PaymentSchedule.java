import java.text.NumberFormat;
public class PaymentSchedule {

    public static void monthlyPaymentSchedule(double principal, double totalMonthlyMorgagePayment){

        String formattedPrincipal = null;

        int paymentCounter = 0;

        NumberFormat formattedCurrency = NumberFormat.getCurrencyInstance();

        System.out.println("MONTHLY PAYMENT: " + formattedCurrency.format(totalMonthlyMorgagePayment));

        System.out.println("********* PAYMENT SCHEDULE *********");

        while(principal > 0){

            paymentCounter++;

            principal = principal - totalMonthlyMorgagePayment;

            formattedPrincipal = formattedCurrency.format(principal);

            if(principal >= totalMonthlyMorgagePayment)
                System.out.println(formattedPrincipal);
        }

        System.out.println("Total Monthly Payments: " + paymentCounter);

    }
}
