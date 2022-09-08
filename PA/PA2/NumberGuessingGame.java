import java.util.Scanner;

public class NumberGuessingGame{
    public static void main(String args[]){

        //variable declaration
        Scanner input = new Scanner(System.in);
        int lives = 3;
        int number = (int)(Math.random()*10)+1;
        boolean game = true;


        //game loop
        while(game){

            System.out.println("Lives: " + lives);
            System.out.print("Your Guess: ");

            
            //check the guess
            if(input.nextInt() == number){

                System.out.println("congrats you won");
                System.out.println("would you like to play again y/n: ");

                //check if they want to play again
                if(input.next().charAt(0) == 'n'){
                    game = false;
                }else {
                    lives = 3;
                    number = (int)(Math.random()*10)+1;
                }
                
            }else{

                lives--;

                //check if you have lost
                if(lives == 0){

                    System.out.println("correct number was " + number);
                    

                    System.out.println("would you like to play again y/n: ");

                    //check if they want to play again
                    if(input.next().charAt(0) == 'n'){
                        game = false;
                    }else {
                        lives = 3;
                        number = (int)(Math.random()*10)+1;
                    }
                }
            }
        }
        

    }
 }
