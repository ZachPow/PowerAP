import java.util.Scanner;

public class Search {
    public static void main(String args[]){
        
        
        //variable declaration
        int[] arr = new int[20];
        int comparisons = 0;
        int target = 0;
        int index = -1;
        int minIndex = 0;
        int maxIndex = arr.length-1;
        int midIndex = 0;

        Scanner input = new Scanner(System.in);

        //asign each index to random value
        for(int i = 0; i < arr.length; i++){
            arr[i] = (int)(Math.random()*10);
            
        }

        System.out.println("Please enter value to search for: ");
        //get target value from user
        target = input.nextInt();

        //sort array
        selectionSort(arr);
        printArray(arr);
        
        System.out.println('\n' + "Target: " + target + '\n');

        //start timer for linear search
        long start = System.nanoTime();
        
        //linear search
        //increments both i and comparisons
        //checks if arr[i] == target if it does break out of the loop
        for(int i = 0; i < arr.length; i++, comparisons++){
            if(arr[i] == target){
                index = i;
                break;
            }
        }

        //stop timer for linear search
        long end = System.nanoTime();

        
        //print out data related to the linear search
        System.out.println("Comparisons in Linear Search: " + comparisons);
        System.out.println("Index: " + index);
        System.out.println("Time: " + (end-start) + " nanoseconds - " + (end-start)*0.000001 + " miliseconds");

        //divider between Linear and Binary data
        System.out.println("---------------------------");


        //reset variables so they can be used in binary search
        comparisons = 0;
        index = -1;

        //start timer for binary search
        start = System.nanoTime();

        //binary search
        //conitues the loop while the minIndex and MaxIndex dont overlap
        while(minIndex < maxIndex){
            
            //assign the mid index
            midIndex = (maxIndex+minIndex)/2;
            //increment the comparisons
            comparisons++;
            
            //check if we found the target
            if(arr[midIndex] == target){
                index = midIndex;
                break;
            
            //moves MinIndex to MidIndex+1 if target is bigger than the midIndex
            }else if(arr[midIndex] < target){
                minIndex = midIndex+1;

            //moves MaxIndex to MidIndex-1 if target is smaller than the midIndex
            }else if(arr[midIndex] > target){
                maxIndex = midIndex-1;
            }

        }
        //stops binary search timer
        end = System.nanoTime();

        //prints out data related to binary search
        System.out.println("Comparisons in binary search: " + comparisons);
        System.out.println("Index: " + index);
        System.out.println("Time: " + (end-start) + " nanoseconds - " + (end-start)*0.000001 + " miliseconds");
        
    }
    public static void printArray(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }
    public static void selectionSort(int[] arr){
        int minIndex;
        int temp;

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

        }
    }
    public static int binarySearch(int[] arr, int target){
        int minIndex = 0;
        int maxIndex = arr.length-1;
        int index = 0;

        while(minIndex < maxIndex){
            int midIndex = (maxIndex+minIndex)/2;
            
            if(arr[midIndex] == target){
                return midIndex;
            }else if(arr[midIndex] < target){
                minIndex = midIndex+1;
            }else if(arr[midIndex] > target){
                maxIndex = midIndex-1;
            }

        }
        return -1;
    }
}
