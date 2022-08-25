import java.util.Scanner;

public class TempConverter {
    public static void main(String args[]){
        
        //variable declarations
        Scanner input = new Scanner(System.in);
        double fahrenheit = 0;
        double celcius = 0;
        double kelvin = 0;


        //ask for input
        System.out.println("please enter a value in fahrenheit to be converted to kelvin");
        
        //get input
        fahrenheit = input.nextDouble();

        celcius = (fahrenheit -32) * 5.0/9;   
        
        kelvin = (fahrenheit - 32) * 5.0/9 + 273.15;

        //print result of calculations
        System.out.println("your value in Kelvin is " + kelvin);
        System.out.println("your value in celcius " + celcius);
    }
    
}
