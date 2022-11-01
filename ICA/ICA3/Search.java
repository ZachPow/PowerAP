import java.util.Scanner;

public class Search {
    public static void main(String args[]){
        
        
        //variable declaration
        int[] arr = new int[10000];
        int comparisons = 0;
        int target = 0;
 

        Scanner input = new Scanner(System.in);

        //asign each index to random value
        for(int i = 0; i < arr.length; i++){
            arr[i] = (int)(Math.random()*20000);
            
        }

        System.out.println("Please enter value to search for: ");

        //get target value from user
        target = input.nextInt();

        System.out.println("Max: " + getMax(arr));
        System.out.println("Min: " + getMin(arr));

        //sort array
        selectionSort(arr);
        //printArray(arr);
        
        System.out.println('\n' + "Target: " + target + '\n');

        //start timer for linear search
        long start = System.nanoTime();
        
        comparisons = linearSearch(arr, target);

        long end = System.nanoTime();

        
        //print out data related to the linear search
        System.out.println("Comparisons in Linear Search: " + comparisons);
        System.out.println("Time: " + (end-start) + " nanoseconds - " + (end-start)*0.000001 + " miliseconds");

        //divider between Linear and Binary data
        System.out.println("---------------------------");


        //reset variables so they can be used in binary search
        comparisons = 0;

        //start timer for binary search
        start = System.nanoTime();

        //binary search
        //conitues the loop while the minIndex and MaxIndex dont overlap
        comparisons = binarySearch(arr, target);

        //stops binary search timer
        end = System.nanoTime();

        //prints out data related to binary search
        System.out.println("Comparisons in binary search: " + comparisons);
        System.out.println("Time: " + (end-start) + " nanoseconds - " + (end-start)*0.000001 + " miliseconds");
        
    }
    public static int getMax(int[] arr){
        int max = arr[0];

        for(int i : arr){
            if(max < i){
                max = i;
            }
        }
        return max;
    }
    public static int getMin(int[] arr){
        int min = arr[0];

        for(int i : arr){
            if(min > i){
                min = i;
            }
        }
        return min;
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
    public static int linearSearch(int[] arr, int target){

        int comparisons = 0;
        for(int i = 0; i < arr.length; i++, comparisons++){
            if(arr[i] == target){
                return comparisons;
            }
        }
        return comparisons;

    }
    public static int binarySearch(int[] arr, int target){
        int minIndex = 0;
        int maxIndex = arr.length-1;
        int index = 0;
        int comparisons = 0;
        
        while(minIndex < maxIndex){

            int midIndex = (maxIndex+minIndex)/2;

            comparisons++;
            
            if(arr[midIndex] == target){
                return comparisons;
            }else if(arr[midIndex] < target){
                minIndex = midIndex+1;
            }else if(arr[midIndex] > target){
                maxIndex = midIndex-1;
            }

        }
        return comparisons;
    }
}
