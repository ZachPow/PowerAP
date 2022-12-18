import java.util.Scanner;

public class ConnectFourBoard {

    private int[][]board = new int[7][7];
    private int[] pos;

    private final int rows = 7;
    private final int columns = 7;


    public ConnectFourBoard(){

    }

    public void printBoard(){
        for(int row = 0; row < board.length; row++){
            for(int column = 0; column < board[0].length; column++){
                System.out.print(board[row][column] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    //places a token by checking each row in the column passed in
    public boolean placeToken(int column, int move){
        
        int[] arr = new int[2];

        //starts at the top row/board.length-1 and decrements
        //iterates until a token is found or we have reached the bottom row
        //if we find a row place token in the row above it
        for(int row = board.length-1; row >= 0; row--){
            if(board[row][column] == 0 || row == 0){
                board[row][column] = move;

                arr[0] = row;
                arr[1] = column;
                break;
            }
        }

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

        if(y-1>= 0 && x-1 >= 0){
            y--;
            x--;
        }
        while(board[y][x] == tokenType){
            
            count++;

            if(y-1>= 0 && x-1 >= 0){
                y--;
                x--;
            }else{
                break;
            }
        }
        
        y = column;
        x = row;

        if(y+1 < row && x+1 < column){
            y++;
            x++;
        }
        while(board[y][x] == tokenType){
            
            count++;

            if(y+1 < row && x+1 < column){
                y++;
                x++;
            }else{
                break;
            }
        }

        if(count >= 4){
            return true;
        }else{
            return false;
        }
    }
    private boolean checkForSlash(int[][] board, int column, 
                                            int row, int tokenType){

        int x = column;
        int y = row;
        int count = 1;

        
        if(y - 1 >= 0 && x+1 < columns ){
            y--;
            x++;
        }
        
        
        //checking for tokens above and to the right
        while(board[y][x] == tokenType){
            
            count++;

            if(y + 1 < row && x+1 < column ){
                y++;
                x++;
            }else{
                break;
            }
        }


        y = row;
        x = column;
        
        if(y+1 < rows && x-1 >= 0){
            y++;
            x--;
        }

        //checking for tokens below and left
        while(board[y][x] == tokenType){
            
            count++;

            if(y+1 < rows && x-1 >= 0){
                y++;
                x--;
            }else{
                break;
            }
        }
        
        if(count >= 4){
            return true;
        }else{
            return false;
        }

    }
    private boolean checkForVerticalRow(int[][] board, int column, 
                                                int row, int tokenType){

        int count = 0;
        int x = column;
        int y = row;

        //System.out.println("looking at token at " + x + ", " + y);

        //start at a row below token if it is inbound
        if(y+1 < rows){
            y++;
        }

        //while the row below is the same token
        while(board[y][x] == tokenType){
            count++;

            //System.out.println("X: " + x + " Y: " + y + " is a token");

            if(y+1 < rows){
                y++;
            }else{
                break;
            }
        }


        y = row;
        //set it to one row below the token if thats in bounds
        if(y-1 >= 0){
            y--;
        }

        //search for the tokens of the same type down from the token
        while(board[y][x] == tokenType){
            
            count++;

            //System.out.println("X: " + x + " Y: " + y + " is a token");

            if(y-1 >= 0){
                y--;
            }else{
                break;
            }
            
        }

        if(count+1 >= 4){
            return true;
        }else{
            return false;
        }



        //return false;
    }
    private boolean checkForRow(int[][] board, int column, 
                                        int row, int tokenType){
        int count = 1;
        int x = column;
        int y = row;

        //starts to look right of the token
        if(x+1 < columns){
            x++;
        }
        //while the tokens to the right are the same token as tokenType
        //stops when we go out of bounds or the token is not the sam tokenType
        while(board[y][x] == tokenType){
            count++;

            if(x+1 < columns){
                x++;
            }else{
                break;
            }
        }

        x = column;

        //start from the left token of the one passed in
        if(x-1 >= 0){
            x--;
        }

        //how many tokens are the same to the right of it
        while(board[y][x] == tokenType){
            count++;

            if(x-1 >= 0){
                x--;
            }else{
                break;
            }
        }

        //check if we have at least 4 tokens
        if(count >= 4){
            return true;
        }else{
            return false;
        }

    }
}
