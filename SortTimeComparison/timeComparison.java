import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Calendar;
/**
* This program demonstrates how to draw lines using Graphics2D object.
 * @author www.codejava.net
 *
 */
public class timeComparison extends JFrame {

    static ArrayList<Integer> selectionSortTimes = new ArrayList<Integer>();
    static ArrayList<Integer> insertionSortTimes = new ArrayList<Integer>();

    public timeComparison() {
        super("Lines Drawing Demo");

        setSize(700, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        setUpLabels();
    }

    void drawLines(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        int currentSelectionY = 550;
        int currentSelectionX = 100;
        int currentInsertionY = 550;
        int counter = 0;

        g2d.drawLine(100, 50, 100, 550);
        g2d.drawLine(100, 550, 550, 550);

        for(int i = 0; i < selectionSortTimes.size(); i++){
            g2d.setColor(Color.blue);
            
            
            g2d.fillOval(currentSelectionX-5, currentSelectionY-5, 10, 10);
            g2d.draw(new Line2D.Double(currentSelectionX, currentSelectionY, currentSelectionX+50, currentSelectionY-selectionSortTimes.get(i)));
            
            currentSelectionY -= selectionSortTimes.get(i);


            g2d.setColor(Color.green);
            g2d.fillOval(currentSelectionX-5, currentInsertionY-5, 10, 10);
            g2d.draw(new Line2D.Double(currentSelectionX, currentInsertionY, currentSelectionX+50, currentInsertionY-insertionSortTimes.get(i)));
            
            currentSelectionX += 50;
            currentInsertionY -= insertionSortTimes.get(i);
            

        }
        
        
        
        //g2d.draw(new Line2D.Double(100d, 10d, 200d, 100d));
        //g2d.draw(new Line2D.Double(59.2d, 99.8d, 419.1d, 99.8d));

    }
    public void setUpLabels(){
        JLabel elementLabel = new JLabel("Elements");
        
        elementLabel.setBounds(325, 525, 100, 25);
        add(elementLabel);

        for(int i = 100; i < 600; i += 100){
            JLabel temp = new JLabel(Integer.toString((5000*(i/100))+1000));
            temp.setBounds(i, 550, 100, 25);

            add(temp);
        }
    }
    public static void calculateSelectionTimes(){

        int[] arr;

        for(int i = 1000; i < 100000; i += 5000){
            
            arr = new int[i];

            for(int j = 0; j < arr.length; j++){
                arr[j] = (int)(Math.random()*100);
            }
            
            selectionSortTimes.add(SelectionSort(arr));
        }
        for(int i : selectionSortTimes){
            System.out.print(i + " ");
        }
    }
    public static void calculateInsertionTimes(){
        
        int[] arr;

        for(int i = 1000; i < 100000; i += 5000){
            
            arr = new int[i];

            for(int j = 0; j < arr.length; j++){
                arr[j] = (int)(Math.random()*100);
            }
            
            insertionSortTimes.add(InsertionSort(arr));
        }
    
    }

    public void paint(Graphics g) {
            super.paint(g);
            drawLines(g);
    }

    public static void main(String[] args) {
        
        
        Thread th = new Thread(){
            public void run(){
                calculateSelectionTimes();
                System.out.println("th done");
            }
        };
        Thread th2 = new Thread(){
            public void run(){
                calculateInsertionTimes();
                System.out.println("th2 done");
            }
        };

        th2.start();
        th.start();

        try{
            th.join();
            th2.join();
        }catch(Exception e){
            System.out.println("couldnt join thread");
        }

        for(int i : selectionSortTimes){
            System.out.print(i + " ");
        }
        System.out.println();
        for(int i : insertionSortTimes){
            System.out.print(i + " ");
        }

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new timeComparison().setVisible(true);
                
            }
        });

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
