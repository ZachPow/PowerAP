
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
    }
    
    public String toString(){

        String temp = new String();

        temp += "Health: " + health;
        temp += " Armor: " + armor;
        temp += " Magic Armor: " + magicArmor;
        temp += " Attribute points: " + attributePoints;
        temp += " Attack Status: " + actionState;

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

    //generates a random attack state
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

    public static void attackRound(Player player, Player oponent){

        //switch statement to evaluate players actionState
        switch(player.actionState){
            case "heal":  player.addHealth(1);
                          break;

            case "spell": if(oponent.actionState.equals("defend"))
                            oponent.subHealth(1);
                          else if(oponent.actionState.equals("heal"))
                            oponent.subHealth(2);
                          break;

            case "attack": if(oponent.actionState.equals("spell"))
                                oponent.subHealth(1);
                           else if(oponent.actionState.equals("heal"))
                                oponent.subHealth(2);
                           break;
        }

        //switch statement to evaluate oponents attackStatus
        switch(oponent.actionState){
            case "heal":  oponent.addHealth(1);
                          break;

            case "spell": if(player.actionState.equals("defend"))
                            player.subHealth(1);
                          else if(player.actionState.equals("heal"))
                            player.subHealth(2);
                          break;

            case "attack": if(player.actionState.equals("spell"))
                                player.subHealth(1);
                           else if(player.actionState.equals("heal"))
                                player.subHealth(2);
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