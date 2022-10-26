import java.util.Scanner;

public class Calculator {
    public static void main(String args[]){

        //variable declaration
        int val1 = 0;
        int val2 = 0;
        char op = ' ';
        int result = 0;

        Scanner input = new Scanner(System.in);
        

        System.out.print("please enter equation with spaces between terms: ");

        //get input
        val1 = input.nextInt();
        op = input.next().charAt(0);
        val2 = input.nextInt();



        //check the operator and call method
        if(op == '+'){
            System.out.println(val1 + " " + op + " " + val2 + " = " + adder(val1, val2));
        }else if(op == '-'){
            System.out.println(val1 + " " + op + " " + val2 + " = " + substract(val1, val2));
        }else if(op == '*' || op == 'x'){
            System.out.println(val1 + " " + op + " " + val2 + " = " + mutiply(val1, val2));
        }else if(op == '/'){
            System.out.println(val1 + " " + op + " " + val2 + " = " + divide(val1, val2));

        }else if(op == '%'){
            
            //print out if the number is divisable or not
            if(remainder(val1, val2) == 0){
                System.out.println(val1 + " is divisable by " + val2);
            }else{
                System.out.println(val1 + " is not divisable by" + val2);
            }
        }

    }
    //methods
    public static int adder(int a, int b){
        return a+b;
    }
    public static int substract(int a, int b){
        return a-b;
    }
    public static int mutiply(int a, int b){
        return a*b;
    }
    public static int divide(int a, int b){
        return a/b;
    }
    public static int remainder(int a, int b){
        return a % b;
    }
}
