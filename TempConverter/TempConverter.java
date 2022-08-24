import java.util.Scanner;

public class TempConverter {
    public static void main(String args[]){
        
        Scanner input = new Scanner(System.in);
        int temp = 0;

        System.out.println("please enter a value in fahrenheit to be converted to kelvin");
        
        temp = input.nextInt();

        System.out.println("your value in Kelvin is " + kelvinToFahrenheit(temp));

    }
    public static float fahrenheitToKelvin(int val){

        return (float)((val-32) * 5.0/9 + 273.15);
    }
    public static float kelvinToFahrenheit (int val){
        return (float)((val-273.15) * 9.0/5 + 32);
    }
}
