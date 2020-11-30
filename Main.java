import java.io.*;
import java.util.*;
import java.io.File;
import java.util.Scanner;

public class Main{

  public static void main(String[] args) throws Exception {
    System.out.println(keyGen());
    List<String> plaintext = new ArrayList<String>();
    File file = new File("file.txt");
    
    Scanner fileScanner = new Scanner(file);
    
    while (fileScanner.hasNext()){
     
      plaintext.add(fileScanner.next());
    }
    
    System.out.println(plaintext);
    fileScanner.close();
    
  }


  public static int keyGen(){
    return 0;
  }

}