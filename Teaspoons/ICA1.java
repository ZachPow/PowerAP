import java.util.Scanner;

public class ICA1{
    public static void main(String args[]){
        
        //variables
        Scanner input = new Scanner(System.in);
        double teaSpoons = 0;
        double tableSpoons = 0;
        double cups = 0;
        double pints = 0;
        double quarts = 0;
        double gallons = 0;
        double fluidOunces = 0;

        //asking for input
        System.out.println("Please give number in teaspoons to be converted");

        //get input
        teaSpoons = input.nextDouble();

        //calculations
        tableSpoons = teaSpoons/3;
        cups = teaSpoons/48;
        pints = teaSpoons/96;
        quarts = teaSpoons/192;
        gallons = teaSpoons/768;
        fluidOunces = teaSpoons/6;

        //print result
        System.out.println("TableSpoon: " + tableSpoons);
        System.out.println("Cups " + cups);
        System.out.println("Pints: " + pints);
        System.out.println("Quarts: " + quarts);
        System.out.println("Gallons: " + gallons);
        System.out.println("fluidOunces: " + fluidOunces);
    }
}