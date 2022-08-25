import java.util.Scanner;

public class TimeConverter {
    public static void main(String args[]){

        //variable declarations
        Scanner input = new Scanner(System.in);
        int seconds = 0;
        int minutes = 0;
        int hours = 0;
        int days = 0;
        int years = 0;


        //ask for input
        System.out.println("Input a amount of time in seconds");

        //get input
        seconds = input.nextInt();

        //convert seconds to minutes and find remainder
        minutes = seconds/60;
        seconds = seconds%60;

        //convert minutes to hours and find remainder
        hours = minutes/60;
        minutes %= 60;

        //convert hours to dyas and find remainder
        days = hours/24;
        hours %= 24;

        //convert days to years and find remainder
        years = days/365;
        days %= 365;

        
        //print out the time in terms of years, days, hours, minutes, and secondss
        System.out.println("years: " + years + " days: " + days + " hours " + hours + " minutes: " + minutes + " seconds " + seconds);
    }
    
}
