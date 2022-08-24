import java.util.Scanner;

public class TempConverter {
    public static void main(String args[]){
        
        //variable declarations
        Scanner input = new Scanner(System.in);
        int fahrenheit = 0;

        //ask for input
        System.out.println("please enter a value in fahrenheit to be converted to kelvin");
        
        //get input
        fahrenheit = input.nextInt();

        //print result of function
        System.out.println("your value in Kelvin is " + fahrenheitToKelvin(fahrenheit));

    }
    public static float fahrenheitToKelvin(int val){

        //return the conversion of farenheit to Kelvin
        return (float)((val-32) * 5.0/9 + 273.15);
    }
    public static float kelvinToFahrenheit (int val){
        
        //return the conversion of kelvin to fhrenheit
        return (float)((val-273.15) * 9.0/5 + 32);
    }
}
