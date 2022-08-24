import java.util.Scanner;

public class TimeConverter {
    public static void main(String args[]){

        Scanner input = new Scanner(System.in);
        int seconds = 0;

        System.out.println("Input a amount of time in seconds");

        seconds = input.nextInt();

        printTimeConversion(seconds);
        
    }
    public static void printTimeConversion(int seconds){

        int minutes = 0;
        int hours = 0;
        int days = 0;
        int years = 0;


        minutes = seconds/60;
        seconds = seconds%60;

        hours = minutes/60;
        minutes %= 60;

        days = hours/24;
        hours %= 24;

        years = days/365;
        days %= 365;
        
        System.out.println("years: " + years + " days: " + days + " hours " + hours + " minutes: " + minutes + " seconds " + seconds);

    }
}
