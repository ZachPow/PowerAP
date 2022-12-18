import java.util.Scanner;

public class ConnectFour{
    public static void main(String args[]){
        
        ConnectFourBoard board = new ConnectFourBoard();
        Scanner input = new Scanner(System.in);
        boolean game = true;
        int num = 0;
        int temp;


        while(game){
            
            board.printBoard();

            temp = input.nextInt();

            if (num % 2 == 0){

                if(board.placeToken(temp, 1)){
                    game = false;
                }

            }else{

                if(board.placeToken(temp, 2)){
                    game = false;
                }
            }
            num++;

            
            
        }

        board.printBoard();
        
    }
    
}