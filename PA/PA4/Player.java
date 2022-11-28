
public class Player{
    
    private int health;
    private int armor;
    private int magicArmor;
    private int attributePoints;
    private String attackState;

    //constructor used for player
    public Player(int healthIn, int armorIn, int magicArmorIn, int pointsIn){
        health = healthIn;
        armor = armorIn;
        magicArmor = magicArmorIn;
        attributePoints = pointsIn;
        attackState = "none";
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

        return temp;
    }

    public int getHealth(){
        return health;
    }
    public void setAttackState(String s){
        attackState = s;
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

    public static void attackRound(Player player, Player oponent){

        //switch statement to evaluate players attackState
        switch(player.attackState){
            case "heal":  player.addHealth(1);
                          break;

            case "spell": if(oponent.attackState.equals("defend"))
                            oponent.subHealth(1);
                          else if(oponent.attackState.equals("heal"))
                            oponent.subHealth(2);
                          break;

            case "attack": if(oponent.attackState.equals("spell"))
                                oponent.subHealth(1);
                           else if(oponent.attackState.equals("heal"))
                                oponent.subHealth(2);
                           break;
        }

        //switch statement to evaluate oponents attackStatus
        switch(oponent.attackState){
            case "heal":  oponent.addHealth(1);
                          break;

            case "spell": if(player.attackState.equals("defend"))
                            player.subHealth(1);
                          else if(player.attackState.equals("heal"))
                            player.subHealth(2);
                          break;

            case "attack": if(player.attackState.equals("spell"))
                                player.subHealth(1);
                           else if(player.attackState.equals("heal"))
                                player.subHealth(2);
                           break;
        }

    }

    public static boolean validAttackState(String attackStatus){
        
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