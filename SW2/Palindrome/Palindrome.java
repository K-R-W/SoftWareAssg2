import java.io.*;

public class Palindrome {  // Save as HelloJNI.java
   static {
      System.loadLibrary("palin"); // Load native library hello.dll (Windows) or libhello.so (Unixes)
                                   //  at runtime
                                   // This library contains a native method called sayHello()
   }
 
   // Declare an instance native method sayHello() which receives no parameter and returns void
   public native boolean palin(String ch);
 
   // Test Driver
   public static void main(String[] args) {
      try{

         System.out.println("Enter text: ");
         String str=new BufferedReader(new InputStreamReader(System.in)).readLine();
         boolean ispal = new Palindrome().palin(str);  // invoke the native method
         if(ispal){
            System.out.println("It is a palindrome");
         }
         else{
            System.out.println("It is NOT a palindrome");         
         }
      }
      catch(Exception ee){
         System.out.println(ee.getMessage());
      }
   }
}