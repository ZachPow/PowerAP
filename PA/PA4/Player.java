
public class Player{
    
    private int health;
    private int armor;
    private int magicArmor;
    private int attributePoints;
    private String actionState;

    //constructor used for player
    public Player(int healthIn, int armorIn, int magicArmorIn, int pointsIn){
        health = healthIn;
        armor = armorIn;
        magicArmor = magicArmorIn;
        attributePoints = pointsIn;
        actionState = "none";
    }

    //constructor used for computer
    //assigns attribute to a random attribute until no attribute points are left 
    public Player(int attributePointsIn){
        int temp;

        attributePoints = attributePointsIn;

        while(attributePoints > 0){
            temp = (int)(Math.random()*3);

            switch(temp){
                case 0: health++;
                    break;
                case 1: armor++;
                    break;
                case 2: magicArmor++;
                    break;
                default:
                    System.out.println("initialization of oponent no work ");
                    break;
            }
            attributePoints--;
        }
        attackStatus = "none";
    }
    
    public String toString(){

        String temp = new String();

        temp += "\n";
        temp += "Health: " + health;
        temp += " Armor: " + armor;
        temp += " Magic Armor: " + magicArmor;
        temp += " Attribute points: " + attributePoints;
        temp += " Attack Status: " + actionState;
        temp += "\n";

        return temp;
    }

    public int getHealth(){
        return health;
    }
    public void setActionState(String s){
        actionState = s;
    }
    public int getArmor(){
        return armor;
    }
    public int getMagicArmor(){
        return magicArmor;
    }

    public void addHealth(int value){
        health += value;
    }
    public void subHealth(int value){
        health -= value;
    }

    //generate d20 roll
    public static int getRoll(){
        return (int)((Math.random()*20)+1);
    }

    //takes armor and damage as args
    //rolls a d20 against armor stat (tie goes to defense)
    public static boolean rollToAttack(int armor, int damage, Player player){
        int roll = getRoll();

        if(roll > armor){
            player.subHealth(damage);
            return true;
        }else{
            return false;
        }
    }

    //generates a random action state
    //used to generate oponents actionState
    public void generateactionState(){
        int temp = (int)(Math.random()*4);

        switch(temp){
            case 0:
                actionState = "attack";
                break;
            case 1:
                actionState = "heal";
                break;
            case 2:
                actionState = "defend";
                break;
            case 3:
                actionState = "spell";
                break;
            default:
                System.out.println("generateAttack doesn't work");
                break;
        }

    }

    public void printActionList(){
        System.out.println();
        System.out.println("Actions: ");
        System.out.println("Heal, Spell, Attack, Defend \n");
    }

    public static void attackRound(Player player, Player oponent){

        //switch statement to evaluate players actionState
        switch(player.actionState){
            case "heal":  player.addHealth(1);
                          break;

            case "spell": if(oponent.actionState.equals("defend"))
                                if(!rollToAttack(oponent.magicArmor, 1, oponent))
                                    System.out.println("attack failed to hit oponent");
                                
                          else if(oponent.actionState.equals("heal"))
                                if(!rollToAttack(oponent.magicArmor, 3, oponent))
                                    System.out.println("attack failed to hit oponent");
                          break;

            case "attack": if(oponent.actionState.equals("spell"))
                                if(!rollToAttack(oponent.armor, 1, oponent))
                                    System.out.println("attack failed to hit oponent");

                           else if(oponent.actionState.equals("heal"))
                                if(!rollToAttack(oponent.armor, 3, oponent))
                                    System.out.println("attack failed to hit oponent");
                           break;
        }

        //switch statement to evaluate oponents attackStatus
        switch(oponent.actionState){
            case "heal":  oponent.addHealth(1);
                          break;

            case "spell": if(player.actionState.equals("defend"))
                              if(!rollToAttack(player.magicArmor, 1, player))
                                  System.out.println("attack failed to hit player");

                          else if(player.actionState.equals("heal"))
                              if(!rollToAttack(player.magicArmor, 3, player))
                                  System.out.println("attack failed to hit player");

                          break;

            case "attack": if(player.actionState.equals("spell"))
                                if(!rollToAttack(player.armor, 3, player))
                                    System.out.println("attack failed to hit player");

                           else if(player.actionState.equals("heal"))
                                if(!rollToAttack(player.armor, 3, player))
                                    System.out.println("attack failed to hit player");
                           break;
        }

    }

    public static boolean validActionState(String attackStatus){
        
        if(attackStatus.equals("attack") 
                || attackStatus.equals("defend")
                || attackStatus.equals("spell")
                || attackStatus.equals("heal")){
            return true;
        }else{
            return false;
        }
    }

}