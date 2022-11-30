public class ICA6{
    public static void main(String args[]){

        int[][] arr = new int[5][5];

        arr[0][0] = 1;

        for(int row = 0; row < arr.length; row++){
            for(int column = 0; column < arr[0].length; column++){

                if(boundCheck(row-1, column)){
                    arr[row][column] += arr[row-1][column];
                }
                if(boundCheck(row, column-1)){
                    arr[row][column] += arr[row][column-1];
                }

                System.out.print(arr[row][column] + " ");
            }
            System.out.println();
        }



    }
    public static boolean boundCheck(int row, int column){
        if(row >= 0 && column >= 0){
            return true;
        }else{
            return false;
        }
        
    }
}