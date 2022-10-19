public class SelectionSort {
    public static void main(String args[]){

<<<<<<< HEAD:PA/PA3/SelectionSort.java
        int[] arr = new int[100000];
=======
        //new integer array of size ten which will contain values which we will sort
        int[] arr = new int[10];

        //this vairable will be used to store the index of the smallest unsorted value in the array
>>>>>>> c9cf24fb8a13f61f6ef30c11af42553dce8ff1d1:PA/PA3/SelectionSort/SelectionSort.java
        int minIndex = 0;

        //this variable is used to help us store an element during the swap phase of the sort
        int temp = 0;


        /*Array value initilization
          Sets every index of the array to a pseudorandom number
          using the Math.random method. Math.Random produces a
          pseudorandom number in the range of [0.0, 1.0). We are 
          then mutipling the returned value by 100 to give us a 
          range of [0.0, 100.0). We then type cast this resultant
          into a integer so it can be stored in an index of our 
          integer array. We are also initilizing each element but
          also printing out each element with a space as we initialize
          it. 
        */
        for(int i = 0; i < arr.length; i++){
            arr[i] = (int)(Math.random()*100);
        }
        
        //starts timer to time how long to sort takes
        final long startTime = System.currentTimeMillis();

        //for loop that runs for every index of the array
        /*purpose: find each minimum in the unsorted portion of the array and swap it to
        its correct position*/
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
