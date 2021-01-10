import java.io.*;
import java.util.*;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Main {
  public int [] encryptionTime = new int[10];
    public static String decryptCaesar(String text, int k) {
      long start = System.currentTimeMillis();
      if(k < 0){
        k = -(k);
        return encryptCaesar(text, k);
      }
      if(k==0){
        return text;
      }
      int m = k; 
        if(k>=26){
          m = (k%26);
        }
        StringBuffer result= new StringBuffer();
        for (int i=0; i<text.length(); i++){
          if (Character.isUpperCase(text.charAt(i))){ 
              
              if((90 - ((int)text.charAt(i))) < (m) ){

                  char ch = (char)((int)text.charAt(i) - m);
                  result.append(ch);
                

              }
                
              
              else if((90 - ((int)text.charAt(i))) <= 25 && (90 - ((int)text.charAt(i))) > (25-m)){
                  char ch = (char)((int)text.charAt(i) + (26-m));
                  result.append(ch);                
              }
              else
              {
                char ch = (char)((((int)text.charAt(i) +m - 65) % 26 + 65-(m*2)));
                result.append(ch);
              }

            
             
          }else if(Character.isLowerCase(text.charAt(i))){ 
           
            if((122 - ((int)text.charAt(i))) < m){
              char ch = (char)((int)text.charAt(i) - m);
              result.append(ch);              
            }else if((122 - ((int)text.charAt(i))) <= 25 && (122 - ((int)text.charAt(i))) > (25-m)){
                char ch = (char)((int)text.charAt(i) + (26-m));
                result.append(ch);
            }else{
              char ch = (char)(((int)text.charAt(i) + m - 97) % 26 + 97-(m*2)); 
              result.append(ch);              
            }
         
          }else if((int)text.charAt(i) == 32){
             
            result.append(" "); 
          }else{
            result.append(text.charAt(i));
          }

        }
        long stop = System.currentTimeMillis();
        long total = stop - start;
        System.out.println("Time taken by decryption: " + total + " ms.");
        return result.toString();
      
    }

    public static String encryptCaesar(String text, int k) {
      long start = System.currentTimeMillis();
      if(k < 0){
        k = -(k);
        return decryptCaesar(text, k);
      }
      
      int m = k; 
        if(k>26){
          m = (k%26);
        } 
        
        StringBuffer result= new StringBuffer();
        for (int i=0; i<text.length(); i++){
          
          if (Character.isUpperCase(text.charAt(i))){ 
            
            char ch = (char)(((int)text.charAt(i) + m - 65) % 26 + 65); 
            result.append(ch);
         
          }else if(Character.isLowerCase(text.charAt(i))){ 
          
           
            char ch = (char)((((int)text.charAt(i) + m - 97) % 26) + 97); 
            result.append(ch);
            
             
          }else if((int)text.charAt(i) == 32){
             
            result.append(" "); 
          }else{
            result.append(text.charAt(i));
          }
System.out.println();
        }
        long stop = System.currentTimeMillis();
        long total = stop - start;
        System.out.println("Time taken by encryption: " + total + " ms.");
        return result.toString();
    }

    public static void main(String[] args) throws FileNotFoundException{
        File file = new File("file3.txt");
        Scanner fileScanner = new Scanner(file);
        Scanner keyboard = new Scanner(System.in);
        StringBuilder plaintext = new StringBuilder();
        while (fileScanner.hasNextLine()){
          
          plaintext.append(fileScanner.nextLine());
          
        }
    
        int key;

        System.out.print("key: ");
        key = keyboard.nextInt();



        long[] start = new long[10];
        long[] stop = new long[10];
        long[] total = new long[10];
        for (int i = 0; i < 10; i++) {
        System.out.println("Plaintext:\n" + plaintext.toString());
        String encryption = encryptCaesar(plaintext.toString(), key);
        start[i] = System.currentTimeMillis();
        System.out.println("Encrypted:\n" + encryption);
        System.out.println("Decrypted:\n" + decryptCaesar(encryption, key));
        stop[i] = System.currentTimeMillis();
        total[i] = stop[i] - start[i];
        
        }

    for (int i = 0; i < 10; i++) {
      System.out.println("Time taken for decryption: " + total[i] + " ms.");
    }

    fileScanner.close();
    keyboard.close();
    }
    
}


// AES
// import java.io.*;
// import java.util.*;
// import java.io.File;
// import java.util.Scanner;
// import javax.crypto.Cipher;
// import javax.crypto.KeyGenerator;
// import javax.crypto.SecretKey;
// import javax.xml.bind.DatatypeConverter;

// public class Main{

//   public static void main(String[] args) throws Exception {
//     //for reading file rather than just string
//     // System.out.println(keyGen());
//     // List<String> plaintext = new ArrayList<String>();
//     // File file = new File("file.txt");
    
//     // Scanner fileScanner = new Scanner(file);
    
//     // while (fileScanner.hasNext()){
     
//     //   plaintext.add(fileScanner.next());
//     // }
    
//     // System.out.println(plaintext);
//     // fileScanner.close();
    
      
//     String str = "Encrypting with AEs!";
//     byte ar[] = str.getBytes();
//     System.out.println(Arrays.toString(ar));
//     char key[] = 
    
//     {
//       1, 2, 3, 4, 
//       5, 6, 7, 8, 
//       9, 10, 11, 12, 
//       13, 14, 15, 16
//     };

//     AESEncryption(ar, key);

//   }
//   public static void AESEncryption(byte[] message, char[] key){
//     int byteSize = 16; 
//     byte[][] state = new byte[4][4];
//     //for(int i = 0; i < byteSize; i++){
//       int k = 0; 
//       while(k <= byteSize-1){
      
//       for(int row = 0; row < state.length-1; row++){
        
//         for(int col = 1; col < state[0].length; col++){
          
//           System.out.print(state[row][col] = message[k]);
//           System.out.print("                 ");
//         }
        
//       }
//       k++;
//       System.out.println();
      

//     }
    
//      // }
//     System.out.println();
//     for(int i = 0; i< state.length; i++){
//       for(int j = 0; j < state[i].length; j++){
//         System.out.print(state[i][j]);
        
//       }
//       System.out.println();
//     }
//     System.out.print(Arrays.toString(state));
//     int roundsN = 1;
//     keyExpansion();
//     roundKey();

//     for(int i = 0; i < roundsN; i++){
//       subB(); //takes state as param
//       shift();//takes state as param
//       mixC();
//       roundKey();//takes state and roundkey as param
//     }

//     //final round excludes mix columns segment
//     subB();
//     shift();
//     roundKey();
//   }

//   public static void keyExpansion(){

//   }

//   public static void firstRound(){

//   }

//   public static void subB(){

//   }

//   public static void shift(){

//   }

//   public static void mixC(){

//   } 

//   public static void roundKey(){

//   } 
  

// }AB