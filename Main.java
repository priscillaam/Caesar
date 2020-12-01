import java.io.*;
import java.util.*;
import java.io.File;
import java.util.Scanner;

public class Main{

  public static void main(String[] args) throws Exception {
    //for reading file rather than just string
    // System.out.println(keyGen());
    // List<String> plaintext = new ArrayList<String>();
    // File file = new File("file.txt");
    
    // Scanner fileScanner = new Scanner(file);
    
    // while (fileScanner.hasNext()){
     
    //   plaintext.add(fileScanner.next());
    // }
    
    // System.out.println(plaintext);
    // fileScanner.close();
    
      
    String str = "Encrypting with AEs!";
    String ar[] = str.split("");
    System.out.println(Arrays.toString(ar));
    char key[] = 
    
    {
      1, 2, 3, 4, 
      5, 6, 7, 8, 
      9, 10, 11, 12, 
      13, 14, 15, 16
    };

    AESEncryption(ar, key);

  }
  public static void AESEncryption(String[] message, char[] key){
    int byteSize = 16; 
    String[][] state = new String[4][4];
    for(int i = 0; i < byteSize; i++){
      for(int row = 1; row < state.length; row++){
        for(int col = 1; col < state[row].length; col++){
          state[row][col] = message[i];
        }
      }
    }

    for(int i = 0; i< state.length; i++){
      for(int j = 0; j < state[i].length; j++){
        System.out.print(state[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println(Arrays.toString(state));
    int roundsN = 1;
    keyExpansion();
    roundKey();

    for(int i = 0; i < roundsN; i++){
      subB(); //takes state as param
      shift();//takes state as param
      mixC();
      roundKey();//takes state and roundkey as param
    }

    //final round excludes mix columns segment
    subB();
    shift();
    roundKey();
  }

  public static void keyExpansion(){

  }

  public static void firstRound(){

  }

  public static void subB(){

  }

  public static void shift(){

  }

  public static void mixC(){

  } 

  public static void roundKey(){

  } 
  

}