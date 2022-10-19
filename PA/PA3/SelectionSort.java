public class SelectionSort {
    public static void main(String args[]){

        int[] arr = new int[100000];
        int minIndex = 0;
        int temp = 0;

        for(int i = 0; i < arr.length; i++){
            arr[i] = (int)(Math.random()*100);
        }
        
        final long startTime = System.currentTimeMillis();

        for(int i = 0; i < arr.length; i++){
            
            //assign minimum to i
            minIndex = i;

            //look for minimum
            for(int j = i; j < arr.length; j++){
                if(arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }

            //swap minimumIndex and arr[i]
            temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;

            //print array

            //sorted portion
            /*for(int k = 0; k <= i; k++){
                System.out.print(arr[k] + " ");
            }
            
            System.out.print(" | ");

            //not sorted portion
            for(int k = i+1; k < arr.length; k++){
                System.out.print(arr[k] + " ");
            }
            System.out.println();*/

        }

        final long endTime = System.currentTimeMillis();

        System.out.println("Total execution time: " + (endTime - startTime) + " miliseconds");

    }
}
