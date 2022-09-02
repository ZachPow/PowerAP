import java.util.Scanner;


public class Counter {
    public static void main(String args[]){
        
        //variable declaration
        Scanner input = new Scanner(System.in);
        int total = 1;
        int val = 0;

        //get input
        val = input.nextInt();

        //for loop to get value
        for(int i = val; i > 0; i--){
            total *= i;
        }

        //print total
        System.out.println(total);
    }
}
