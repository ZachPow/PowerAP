public class Insertion{
    public static void main(String args[]){
        
        //new integer array of size ten which will contain values which we will sort
        int[] arr = new int[10];

        //this variable will be used to store the index we should insert the next value to
        int swapIndex = 0;

        /*this variable will be used to store the next element we will be sorting because 
          during the shifting phase of the sorting algorithm we will be overriding the index
          that the element is found at
        */
        int element = 0;


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
            System.out.print(arr[i] + " ");
        }

        /*
          since all elements are printed on the same line we print a new line to
          distinguish between the original array and the printing of the array with
          the divider as we sort it.
        */
        System.out.println();


        //for loop that runs for every index of the array
        //purpose: insert each element into its correct spot
        for(int i = 0; i < arr.length; i++){
            
            //store element because the index will be overwritten during the shifting
            //also store it so it can be compared to the sorted side of the array
            element = arr[i];

            /* 
              the swapIndex startes with i so that in the event that it is bigger than
              all sorted elements it'll swap with itself instead of the previous value that
              swapIndex held
            */
            swapIndex = i;

            /*
              starts with the i-1 which is the value left of the element to be inserted and decrements and
              makes sure that the element is smaller than the kth element. If it is not smaller than the 
              kth element it breaks out of the for loop because that means that the element should be inserted
              at the swapIndex. For loop also ends if k < 0 because that means it has reached the end of the 
              sorted portion of the array and that the element we are sorting is the smalles element found so 
              far
            */
            for(int k = i-1; k >= 0; k--){
                if(element < arr[k]){
                    swapIndex = k;
                }else{
                    break;
                }
            }

            /*
              This for loop shifts all the elements from (swapIndex, i] by one index to the right. 
              We start at the index of the element to be inserted also known as i and take the k-1th
              element and store it into the kth element. We repeat this process until we reach the swapIndex
              which can be left alone as we are about to insert the element into it
            */
            for(int k = i; k > swapIndex; k--){
                arr[k] = arr[k-1];
            }

            //this puts the element into the swapIndex
            arr[swapIndex] = element;

            /*prints Sorted part of array also known as [0, i] portion of the array. i is considered
              part of the sorted part of the array because we put a sorted number into the ith index
              during the shifting phase
            */
            for(int k = 0; k <= i; k++){
                System.out.print(arr[k] + " ");
            }
            
            //prints divider
            //this is purely cosmetic
            System.out.print(" | ");

            //print unsorted portion of array - (i, arr.length)
            //exclusive of i since we have already printed the ith index out
            for(int k = i+1; k < arr.length; k++){
                System.out.print(arr[k] + " ");
            }

            //all elements are printed on the same line so we print a new line to seperate this iteration from the next
            System.out.println();
        }
    }
}