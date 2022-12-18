import java.util.Scanner;

public class ConnectFourBoard {

    private int[][]board = new int[7][7];
    private int[] pos;

    private final int rows = 7;
    private final int columns = 7;


    public void printBoard(){
        for(int row = 0; row < board.length; row++){

            for(int column = 0; column < board[0].length; column++){
                System.out.print("____");
            }
            System.out.println();

            for(int column = 0; column < board[0].length; column++){

                switch(board[row][column]){
                    case 0: System.out.print('.');
                        break;
                    case 1: System.out.print('X');
                        break;
                    case 2: System.out.print('O');
                        break;
                }

                System.out.print(" | ");

            }
            System.out.println();

        }

        for(int column = 0; column < board[0].length; column++){
                System.out.print("----");
        }
        System.out.println();
    }

    //places a token by checking each row in the column passed in
    public boolean placeToken(int column, int move){
        
        //used to store the position of the placed token
        int[] arr = new int[2];

        /*  starts at the top row/board.length-1 and decrements
            iterates until a token is found or we have reached the bottom row
            if we find a row place token in the row above it
        */
        for(int row = board.length-1; row >= 0; row--){
            if(board[row][column] == 0 || row == 0){
                board[row][column] = move;


                //store the position of where we place the token
                arr[0] = row;
                arr[1] = column;

                break;
            }
        }

        //passes the position to the checkForWin method
        return checkForWin(arr[0], arr[1]);
    }

    /*  looks to see if a row or a streak of 4 can be found
        it checks to see how many tokens are to the right
        and checks how many tokens are to the left
        based on the token passed in which is dictated by row and columb arguments
    */

    public boolean checkForWin(int row, int column){

        int count = 1;
        
        int x = column;
        int y = row;

        //what type of token are we looking for
        int tokenType = board[y][x];

        int rows = board.length;
        int columns = board[0].length;

        if(checkForRow(board, column, row, tokenType)){
            System.out.println("row");
            return true;
        }
        if(checkForVerticalRow(board, column, row, tokenType)){
            System.out.println("vertical");
            return true;
        }
        if(checkForForwardSlash(board, column, row, tokenType)){
            System.out.println("forwardSlash");
            return true;
        }
        if(checkForSlash(board, column, row, tokenType)){
            System.out.println("backSlash");
            return true;
        }

        return false;
        
    }

    public boolean checkBounds(int x, int y){
        if(x >= 0 && x < columns && y >= 0 && y < rows){
            return true;
        }else{
            return false;
        }
    }

    private boolean checkForForwardSlash(int[][] board, int column, 
                                                int row, int tokenType){

        int x = column;
        int y = row;
        int count = 1;

        do{
            if(checkBounds(x-1, y-1)){
                y--;
                x--;
            }else
                break;
            

            if(board[y][x] == tokenType){
                count++;
            }
            
        }while(board[y][x] == tokenType);

        
        y = column;
        x = row;

        do{
            if(checkBounds(x+1, y+1)){
                y++;
                x++;
            }else{
                break;
            }

            if(board[y][x] == tokenType){
                count++;
            }
            
        }while(board[y][x] == tokenType);

        return count >= 4;
    }

    private boolean checkForSlash(int[][] board, int column, 
                                            int row, int tokenType){

        int x = column;
        int y = row;
        int count = 1;

        
        do{
            if(checkBounds(x+1, y-1)){
                y--;
                x++;
            }else{
                break;
            }

            if(board[y][x] == tokenType){
                count++;
            }
            
        }while(board[y][x] == tokenType);


        y = row;
        x = column;
        
        do{
            if(y+1 < rows && x-1 >= 0){
                y++;
                x--;
            }else{
                break;
            }

            if(board[y][x] == tokenType){
                count++;
            }
            

        }while(board[y][x] == tokenType);

        return count >= 4;

    }

    private boolean checkForVerticalRow(int[][] board, int column, 
                                                int row, int tokenType){

        int count = 1;
        int x = column;
        int y = row;

        do{
            if(checkBounds(x, y+1)){
                y++;
            }else{
                break;
            }

            if(board[y][x] == tokenType){
                count++;
            }
            
        }while(board[y][x] == tokenType);


        y = row;

        do{
            if(checkBounds(x, y-1)){
                y--;
            }else{
                break;
            }

            if(board[y][x] == tokenType){
                count++;
            }
            
        }while(board[y][x] == tokenType);

        return count >= 4;
    }

    private boolean checkForRow(int[][] board, int column, 
                                        int row, int tokenType){
        int count = 1;
        int x = column;
        int y = row;

        do{
            if(checkBounds(x+1, y)){
                x++;
            }else{
                break;
            }

            if(board[y][x] == tokenType){
                count++;
            }
            
        }while(board[y][x] == tokenType);

        x = column;

        do{
            if(checkBounds(x-1, y)){
                x--;
            }else{
                break;
            }

            if(board[y][x] == tokenType){
                count++;
            }
            
        }while(board[y][x] == tokenType);

        return count >= 4;

    }
}
