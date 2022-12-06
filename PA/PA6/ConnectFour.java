import java.util.Scanner;

public class ConnectFour{
    public static void main(String args[]){
        int[][]board = new int[7][7];

        Scanner input = new Scanner(System.in);
        String temp;
        int[] pos;
        int i = 0;

        do{
            printBoard(board);
            temp = input.next();

            if(i % 2 == 0){
                pos = placeToken(board, Integer.parseInt(temp), 1);
            }else{
                pos = placeToken(board, Integer.parseInt(temp), 2);
            }
            i++;

        }while(!checkForWin(board, pos[0], pos[1]));

        System.out.println("X: " + pos[0] + " Y: " + pos[1]);

        printBoard(board);

        if(checkForWin(board, pos[0], pos[1])){
            System.out.println("yay");
            System.out.println(board[pos[0]][pos[1]] + "won");
        } 

        // /System.out.println("row found");
        
    }
     //looks to see if a row or a streak of 4 can be found
    //it checks to see how many tokens are to the right
    //and checks how many tokens are to the left
    //based on the token passed in which is dictated by row and columb arguments
    public static boolean checkForWin(int[][] board, int row, int column){

        int count = 1;
        
        int x = column;
        int y = row;

        //what type of token are we looking for
        int tokenType = board[y][x];

        int rows = board.length;
        int columns = board[0].length;

        if(checkForRow(board, column, row, columns, rows, tokenType)){
            System.out.println("row");
            return true;
        }
        if(checkForVerticalRow(board, column, row, columns, rows, tokenType)){
            System.out.println("vertical");
            return true;
        }
        if(checkForForwardSlah(board, column, row, columns, rows, tokenType)){
            System.out.println("forwardSlash");
            return true;
        }
        if(checkForSlash(board, column, row, columns, rows, tokenType)){
            System.out.println("backSlash");
            return true;
        }else{
            //System.out.println("no slash");
        }
        return false;
        
    }
    public static boolean checkForForwardSlah(int[][] board, int column, 
                                                int row, int columns, 
                                                int rows, int tokenType){

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
    public static boolean checkForSlash(int[][] board, int column, 
                                            int row, int columns, 
                                            int rows, int tokenType){

        int x = column;
        int y = row;
        int count = 1;

        
        if(y - 1 >= rows && x+1 < columns ){
            y--;
            x++;
        }
        
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
        
        System.out.println("count: " + count);
        if(y+1 < rows && x-1 >= 0){
            y++;
            x--;
        }
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
    public static boolean checkForVerticalRow(int[][] board, int column, 
                                                int row, int columns, 
                                                int rows, int tokenType){

        int count = 1;
        int x = column;
        int y = row;

        //start at a row above token if it is inbound
        if(y+1 < rows){
            y++;
        }

        //while the row above is the same token
        while(board[y][x] == tokenType){
            count++;

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

            if(y-1 >= 0){
                y--;
            }else{
                break;
            }
        }

        if(count >= 4){
            System.out.println("vertical row");
            return true;
        }else{
            return false;
        }



        //return false;
    }
    public static boolean checkForRow(int[][] board, int column, 
                                        int row, int columns, 
                                        int rows, int tokenType){
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
   
    //places a token by checking each row in the column passed in
    public static int[] placeToken(int[][] board, int column, int move){
        
        int[] arr = new int[2];

        //starts at the top row/board.length-1 and decrements
        //iterates until a token is found or we have reached the bottom row
        //if we find a row place token in the row above it
        for(int row = 0; row < board.length; row++){
            if(board[row][column] != 0){
                board[row-1][column] = move;
                arr[0] = row-1;
                arr[1] = column;
                return arr;
            }
        }
        //place token in bottom row
        board[board.length-1][column] = move;
        arr[0] = board.length-1;
        arr[1] = column;
        return arr;
    }
    public static void printBoard(int[][] board){
        for(int row = 0; row < board.length; row++){
            for(int column = 0; column < board[0].length; column++){
                System.out.print(board[row][column] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}