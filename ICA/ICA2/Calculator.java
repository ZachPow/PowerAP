import java.util.Scanner;

public class Calculator {
    public static void main(String args[]){
        
        Scanner input = new Scanner(System.in);
        
        int val1 = 0;
        int val2 = 0;
        char operator = ' ';

        val1 = input.nextInt();
        operator = input.next().charAt(0);
        val2 = input.nextInt();

        if(val1 <= -999 || val1 >= 999 || val2 <= -999 || val2 >= 999){
            System.out.println("Your input values are not valid");
            return;
        }

        System.out.print(val1 + " " + operator + " " + val2 + " = ");

        switch(operator){
            case '+': System.out.print(val1 + val2);
                break;
            case '-': System.out.print(val1 - val2);
                break;
            case '/': System.out.print((double)val1 / val2);
                break;
            case '*': System.out.print(val1 * val2);
                break;
            case '%': System.out.print(val1 % val2);
                break;
            case 'x': System.out.print(val1 * val2);
                break;
            default: System.out.print("unknown operator");
                break;
        }

    }
}
