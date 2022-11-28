import java.util.Scanner;

public class PA4 {
    public static void main(String args[]){

        int attributePoints = 20;
        int armor = 0;
        int health = 0;
        int magicArmor = 0;
        int temp;

        Scanner input = new Scanner(System.in);
        Player oponent = new Player(attributePoints);


        System.out.println("Stat Points: " + attributePoints);
        System.out.println("How many points would you like to put into Health");

        temp = getNumberInput(attributePoints);
        health += temp;
        attributePoints -= temp;

        System.out.println("Stat Points: " + attributePoints);
        System.out.println("How many points would you like to put into armor");

        temp = getNumberInput(attributePoints);
        armor += temp;
        attributePoints -= temp;

        System.out.println("Stat Points: " + attributePoints);
        System.out.println("How many points would you like to put into magic armor");

        temp = getNumberInput(attributePoints);
        magicArmor += temp;
        attributePoints -= temp;

        Player player = new Player(health, armor, magicArmor, attributePoints); 
    
        System.out.println("Player: " + player);
        System.out.println("Oponent: " + oponent);
    }
    public static String getAttackStatusInput(){
        
        Scanner input = new Scanner(System.in);
        String str = new String();

        str = input.next();

        while(!Player.validAttackState(str)){
            str = input.next();
        }

        return str;
    }
    //gets input from user
    public static int getNumberInput(int attributePoints){

        Scanner input = new Scanner(System.in);
        String val;
        
        //get input
        val = input.next();
        
        //check if we got a valid input
        //propmt the user for a new input if it is invalid
        while(!validInput(val, attributePoints)){
            System.out.println("bad input please give another input");
            val = input.next();
        }

        //returns the string parsed to an integer
        return Integer.parseInt(val);
    }

    //check that our input is valid
    public static boolean validInput(String s, int attributePoints){
        int temp;

        //attempt to parse input
        //if we fail to parse the input return false
        try{

            temp = Integer.parseInt(s);

        }catch(Exception e){

            //System.out.println(e.getStackTrace());
            return false;
        }

        //return false if input is bigger than attribute points
        //or if input is less than zero
        if(temp > attributePoints || temp < 0){
            return false;
        }
        
        return true;
    }
}
