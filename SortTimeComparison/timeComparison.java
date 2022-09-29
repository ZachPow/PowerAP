import javax.swing.*;

public class timeComparison {
    public static void main(String[] args){
        
        int[] arr;
        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setVisible(true);


        for(int i = 0; i < 200; i += 25){
            
        }
    }

    public static int InsertionSort(int[] arr){
        
        final long startTime = System.currentTimeMillis();
        int swapIndex = 0;
        int element = 0;

        for(int i = 0; i < arr.length; i++){
            
            //find index to insert
            for(int k = i-1; k >= 0; k--){
                if(arr[i] > arr[k]){
                    swapIndex = k+1;
                    break;
                }
                if(k == 0){
                    swapIndex = 0;
                }
            }

            //store element
            element = arr[i];

            //shift elements
            for(int k = i; k > swapIndex; k--){
                arr[k] = arr[k-1];
            }

            //insert element
            arr[swapIndex] = element;
        }
        final long endTime = System.currentTimeMillis();

        return (int)(endTime-startTime);
    }

    public static int SelectionSort(int[] arr){

        final long startTime = System.currentTimeMillis();
        int minIndex = 0;
        int temp = 0;

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

        final long endTime = System.currentTimeMillis();

        return (int)(endTime-startTime);

    }
}
