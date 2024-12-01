import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.*;
import java.lang.Math;
public class MyProgram
{
    public static void main(String[] args)
    {
        //initilizing all variables
        ArrayList<Integer> listOne = new ArrayList<Integer>();
        ArrayList<Integer> listTwo = new ArrayList<Integer>();
        ArrayList<Integer> difference = new ArrayList<Integer>();
        int totalDiff = 0;
        //opening them files
         try {
         File myObj = new File("input.txt");
         Scanner input = new Scanner(myObj);
        while (input.hasNextLine()) {
            //adding each item line by line to the arrays
            String data = input.nextLine();
            listOne.add(Integer.parseInt(firstItem(data)));
            listTwo.add(Integer.parseInt(secondItem(data)));
            
        }
        //closing text file
        input.close();

        } 
        
        catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
        }
        
        //finding and putting difference into array
        for(int i = 0; i<listOne.size();i++){
            difference.add(Math.abs(listOne.get(i)-listTwo.get(i)));
            System.out.println(difference.get(i));
        }
        //adding up total difference
        for(int i :difference){
            totalDiff +=i;
        }
        System.out.println(totalDiff);
        
        
    }
    public static String firstItem(String s){
        return s.substring(0,s.indexOf(" "));
        
        
    }
    public static String secondItem(String s){
        //assumes spaces are all in a row (bc they are)
        String x = s.replaceAll(" ","");
        int spaces = s.length()-x.length();
        return s.substring(s.indexOf(" ")+spaces);
        
    }
}
