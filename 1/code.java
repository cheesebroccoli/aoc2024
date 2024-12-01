//I am making an assumption that nextLine does not split my spaces so I'm doing it manually
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.*;

public class dayOne {
  public static void main(String[] args) {
    List<Integer> listOne = new ArrayList<>();
    List<Integer> listOne = new ArrayList<>();
    try {
      File myObj = new File("input.txt");
      Scanner input = new Scanner(myObj);
      while (input.hasNextLine()) {
        String data = myReader.nextLine();
        
      }
      
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    public static void split(String data){
      
  }
}
