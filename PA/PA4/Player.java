
public class Player{
    
    private int health;
    private int armor;
    private int magicArmor;
    private int attributePoints;

    public Player(int healthIn, int armorIn, int magicArmorIn, int pointsIn){
        health = healthIn;
        armor = armorIn;
        magicArmor = magicArmorIn;
        attributePoints = pointsIn;
    }
    public Player(int attributePointsIn){
        int temp;

        attributePoints = attributePointsIn;

        for(int i = attributePoints; i > 0; i--, attributePoints--){
            temp = (int)(Math.random()*3);

            switch(temp){
                case 0: health++;
                    break;
                case 1: armor++;
                    break;
                case 2: magicArmor++;
                    break;
                default:
                    System.out.println("initialization of player no work ");
                    break;
            }
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
    public void subHealth(){
        health--;
    }
    public int getArmor(){
        return armor;
    }
    public int getMagicArmor(){
        return magicArmor;
    }

}