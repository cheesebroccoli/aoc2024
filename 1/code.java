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
        //still need to sort from smallest to largest
        quickSort(listOne,0,listOne.size()-1);
        quickSort(listTwo,0,listTwo.size()-1);
        //finding and putting difference into array
        for(int i = 0; i<listOne.size();i++){
            difference.add(Math.abs(listOne.get(i)-listTwo.get(i)));
           // System.out.println(i+ " " + difference.get(i));
        }
        //adding up total difference
        for(int i :difference){
            totalDiff +=i;
        }
       System.out.println(totalDiff);
       
       similarity(listOne,listTwo);
        
        
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
    public static void quickSort(ArrayList<Integer> arr, int low, int high) {
        if (low < high) {
            
            // pi is the partition return index of pivot
            int pi = partition(arr, low, high);

            // Recursion calls for smaller elements
            // and greater or equals elements
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

     static int partition(ArrayList<Integer> arr, int low, int high) {
        
        // Choose the pivot
        int pivot = arr.get(high);
        
        // Index of smaller element and indicates 
        // the right position of pivot found so far
        int i = low - 1;

        // Traverse arr[low..high] and move all smaller
        // elements to the left side. Elements from low to 
        // i are smaller after every iteration
        for (int j = low; j <= high - 1; j++) {
            if (arr.get(j) < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        
        // Move pivot after smaller elements and
        // return its position
        swap(arr, i + 1, high);  
        return i + 1;
    }

    // Swap function
    static void swap(ArrayList<Integer> arr, int i, int j) {
        int temp = arr.get(i);
        arr.set(i,arr.get(j));
        arr.set(j,temp);
    }
    
    //number * frequency = similarity score
    static void similarity(ArrayList<Integer> one, ArrayList<Integer> two){
        int score = 0;
        int frequency = 0;
        for(int x : one){
            for(int y: two){
                if(x==y){
                    frequency++;
                }
            }
            score += x*frequency;
            frequency = 0;
        }
        System.out.println(score);
        
    }
}
