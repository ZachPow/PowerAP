import java.util.Scanner;

public class PA4 {
    public static void main(String args[]){

        boolean game = true;

        final int attributePoints = 20;

        int temp;

        Player oponent = new Player(attributePoints);
        Player player = getInputForPlayer(attributePoints); 
    
        System.out.println();
        System.out.println("Player: " + player);
        System.out.println("Enemy: " + oponent);

        while(game){
            

            temp = 0;

            while(temp != 2){

                System.out.println("1. Print Action List");
                System.out.println("2. Enter action");

                temp = getNumberInput();
            
                switch(temp){
                    case 1: System.out.println("input is one");
                            player.printActionList();
                        break;
                    case 2: player.setActionState(getActionStatusInput());
                        break;
                    default:
                            System.out.println("Expected input is 1 or 2");
                        break;
                }
            }
            oponent.generateactionState();
            Player.attackRound(player, oponent);

            System.out.println();
            System.out.println("Player: " + player);
            System.out.println("Enemy: " + oponent);

            if(player.getHealth() <= 0){
                System.out.println("you lost");
                game = false;
            }else if(oponent.getHealth() <= 0){
                System.out.println("you won");
                game = false;
            }
        }
        

    }
    //gets inputs for health, armor, magicArmor
    //then returns Player object using read in values
    public static Player getInputForPlayer(int attributePointsIn){
        int attributePoints = attributePointsIn;
        int armor = 0;
        int health = 0;
        int magicArmor = 0;

        int temp;

        System.out.println("\nStat Points: " + attributePoints);
        System.out.println("How many points would you like to put into Health");

        temp = getNumberInput(attributePoints);
        health += temp;
        attributePoints -= temp;

        System.out.println("\nStat Points: " + attributePoints);
        System.out.println("How many points would you like to put into armor");

        temp = getNumberInput(attributePoints);
        armor += temp;
        attributePoints -= temp;

        System.out.println("\nStat Points: " + attributePoints);
        System.out.println("How many points would you like to put into magic armor");

        temp = getNumberInput(attributePoints);
        magicArmor += temp;
        attributePoints -= temp;

        System.out.println();

        return new Player(health, armor, magicArmor, attributePoints);
    }

    //gets input and checks if input is valid
    //input is valid if it is a action reconized by the validActionState() method
    //see validActionState in the player class to see valid actions states
    public static String getActionStatusInput(){
        
        Scanner input = new Scanner(System.in);
        String str = new String();

        System.out.println("please enter an action");

        str = input.nextLine();


        //str.toLower because all attack status are lower case
        //user can input with caps and it will still work
        while(!Player.validActionState(str.toLowerCase())){  
            System.out.println("bad input");
            str = input.nextLine();
        }

        //input.close();
        return str.toLowerCase();
    }

    /*gets input from user and validates them using 
      the validNumber() and validInput() methods 
    */ 
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

    //overload of getNumberInput(int attribute points)
    //this method doesn't take in a attribute argument
    //just checks to see if input is a number instead of calling validInput() it calls validNumber()
    public static int getNumberInput(){
        Scanner input = new Scanner(System.in);
        String val;
        
        //get input
        val = input.next();
        
        //check if we got a valid input
        //propmt the user for a new input if it is invalid
        while(!validNumber(val)){
            System.out.println("bad input please give another input");
            val = input.next();
        }

        //returns the string parsed to an integer
        return Integer.parseInt(val);
    }

    //checks if string s is a valid string
    //does this by seeing if it can be parsed into a integer
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
    //valid inputs can be parsed to integers and are less than attribute points
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