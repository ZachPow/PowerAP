public class SelectionSort {
    public static void main(String args[]){

        int[] arr = new int[10];
        int minIndex = 0;
        int temp = 0;

        for(int i = 0; i < arr.length; i++){
            arr[i] = (int)(Math.random()*100);
        }

        for(int i = 0; i < arr.length; i++){
            
            //assign minimum to i
            minIndex = i;

            //look for minimum
            for(int j = i; j < arr.length-1; j++){
                if(arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }

            //swap minimum and i
            temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;

            //print array
            for(int k = 0; k <= i; k++){
                System.out.print(arr[k] + " ");
            }
            
            System.out.print(" | ");

            for(int k = i+1; k < arr.length; k++){
                System.out.print(arr[k] + " ");
            }
            System.out.println();

        }
    }
}
