import java.util.Scanner;
public class UserInput{

    public static double getInput(String prompt, double min, double max, String warningMessage){

        Scanner input = new Scanner(System.in);

        double value;

        while(true){

            System.out.println(prompt);

            value = input.nextDouble();

            if(value >= min && value <= max )
                break;

            System.out.println(warningMessage);
        }

        return value;
    }
}