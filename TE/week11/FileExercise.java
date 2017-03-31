import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class FileExercise{
  public static void main(String[] args){
    String fileName = args[0];
    Scanner inputStream = null;
    try{
      inputStream = new Scanner(new File(fileName));
    }catch(FileNotFoundException e){
      System.out.println("Error, could not find the file " + fileName);
    }
    int count = 0;
    while(inputStream.hasNextLine()){
      inputStream.nextLine();
      count++;
    }
    inputStream.close();
    System.out.println("There are " + count + " lines in " + fileName);


  }
}
