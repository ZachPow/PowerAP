public class Insertion {
    public static void main(String args[]){
        
        int[] arr = new int[10];
        int swapIndex = 0;
        int element = 0;

        for(int i = 0; i < arr.length; i++){
            arr[i] = (int)(Math.random()*100);
        }

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
