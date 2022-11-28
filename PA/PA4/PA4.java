import java.util.Scanner;

public class PA4 {
    public static void main(String args[]){

        int attributePoints = 20;
        int armor;
        int health;
        int magicArmor;
        String temp;

        Scanner input = new Scanner(System.in);
        Player oponent = new Player(attributePoints);


        System.out.println("Stat Points: " + attributePoints);
        System.out.println("How many points would you like to put into Health");
        temp = input.next();
        
        if(!validInput(temp, attributePoints)){
            System.out.println("bad input");
            return;
        }
        health = Integer.parseInt(temp);
        attributePoints -= health;

        System.out.println("Stat Points: " + attributePoints);
        System.out.println("How many points would you like to put into Armor");
        temp = input.next();
        
        if(!validInput(temp, attributePoints)){
            System.out.println("bad input");
            return;
        }
        armor = Integer.parseInt(temp);
        attributePoints -= armor;

        System.out.println("Stat Points: " + attributePoints);
        System.out.println("How many points would you like to put into magic armor");
        temp = input.next();
        
        if(!validInput(temp, attributePoints)){
            System.out.println("bad input");
            return;
        }
        magicArmor = Integer.parseInt(temp);
        attributePoints -= armor;
        
        
    }
    public static boolean validInput(String s, int attributePoints){
        int temp;
        
        try{
            temp = Integer.parseInt(s);
        }catch(Exception e){
            System.out.println(e.getStackTrace());
            return false;
        }

        if(temp > attributePoints){
            return false;
        }
        
        return true;

    }
}
