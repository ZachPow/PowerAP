import java.util.Scanner;

public class Anagram {
    public static void main(String args[]){

        String val1;
        String val2;
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter two words");

        
        String temp = input.nextLine();

        System.out.println(temp);

        val1 = temp.substring(0, temp.indexOf(' '));
        val2 = temp.substring(temp.indexOf(' ') + 1);

        //System.out.println("length 1: " + val1.length());
        //System.out.println("length 2: " + val2.length());

        if(val1.length() != val2.length()){
            System.out.println("these are not anagrams");
        }else{
            System.out.println(isAnagram(val1.toLowerCase(), val2.toLowerCase()));
        }

    }
    
    public static boolean isAnagram(String val1, String val2){
        int[] chars1 = new int[26];
        int[] chars2 = new int[26];

        for(int i = 0; i < val1.length(); i++){
            chars1[(int)val1.charAt(i)-97]++;
            chars2[(int)val2.charAt(i)-97]++;
        }

        for(int i = 0; i < chars1.length; i++){
            if(chars1[i] != chars2[i]){
                return false;
            }
        }
        return true;
    } 

}


