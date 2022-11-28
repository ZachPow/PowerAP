import java.util.Scanner;

public class PA4 {
    public static void main(String args[]){

        int attributePoints = 20;
        int armor = 0;
        int health = 0;
        int magicArmor = 0;
        int temp;

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
    
        player.setActionState(getAttackStatusInput());

        System.out.println(player);
    }

    //gets input and checks if input is valid
    public static String getAttackStatusInput(){
        
        Scanner input = new Scanner(System.in);
        String str = new String();

        System.out.println("please enter an action");

        str = input.nextLine();

        //str.toLower because all attack status are lower case
        //user can input with caps and it will still work
        while(!Player.validActionState(str.toLowerCase())){
            str = input.nextLine();
            System.out.println("bad input");
        }

        input.close();
        return str.toLowerCase();
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

        //input.close();

        //returns the string parsed to an integer
        return Integer.parseInt(val);
    }
    public static boolean validNumber(String s){
        int temp;

        //attempt to parse input
        //if we fail to parse the input return false
        try{

            temp = Integer.parseInt(s);

        }catch(Exception e){

            //System.out.println(e.getStackTrace());
            return false;
        }
        return true;
    }
    //check that our input is valid
    public static boolean validInput(String s, int attributePoints){
        int temp;

        if(!validNumber(s)){
            return false;
        }else{
            temp = Integer.parseInt(s);
        }

        //return false if input is bigger than attribute points
        //or if input is less than zero
        if(temp > attributePoints || temp < 0){
            return false;
        }
        
        return true;
    }
}
