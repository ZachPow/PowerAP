public class ICA7{
    public static void main(String args[]){

        int[][] board = new int[10][10];


        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){

                if(i+j == 9 || i == j){
                    board[i][j] = i*j;
                }else{
                    board[i][j] = i+j;
                }

                System.out.printf("%-4d", board[i][j]);
                //System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        

        
    }
}