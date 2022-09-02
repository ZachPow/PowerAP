import java.util.Scanner;

public class Calculator {
    public static void main(String args[]){
        
        //variable declaration
        Scanner input = new Scanner(System.in);
        
        int val1 = 0;
        int val2 = 0;
        char operator = ' ';

        //ask for input
        System.out.print("please enter equation with spaces in between each part: ");


        //get input
        val1 = input.nextInt();
        operator = input.next().charAt(0);
        val2 = input.nextInt();

        
        //check if val1 and val2 are valid
        if(val1 <= -999 || val1 >= 999 || val2 <= -999 || val2 >= 999){

            System.out.println("Your input values are not valid");

        }else{

            //print math based on the operator given
            if(operator == '+'){
                System.out.print(val1 + " " + operator + " " + val2 + " = " + (val1 + val2));
            }else if(operator == '-'){
                System.out.print(val1 + " " + operator + " " + val2 + " = " + (val1 - val2));
            }else if(operator == '*'){
                System.out.print(val1 + " " + operator + " " + val2 + " = " + (val1 * val2));
            }else if(operator == 'x'){
                System.out.print(val1 + " " + operator + " " + val2 + " = " + (val1 * val2));
            }else if(operator == '/'){
                System.out.print(val1 + " " + operator + " " + val2 + " = " + ((double)val1 / val2));
            }else if(operator == '%'){
                
                if(val1 % val2 == 0)
                    System.out.println(val1 + " is divisable by " + val2);
                else
                    System.out.println(val1 + " is not divisable by " + val2);

            }else{
                System.out.println("Unknown operator");
            }
        }

    }
}
