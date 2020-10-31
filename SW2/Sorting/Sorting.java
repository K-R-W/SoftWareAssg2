import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Sorting {  // Save as HelloJNI.java
   static {
      System.loadLibrary("sort"); // Load native library hello.dll (Windows) or libhello.so (Unixes)
                                   //  at runtime
                                   // This library contains a native method called sayHello()
   }
 
   // Declare an instance native method sayHello() which receives no parameter and returns void
   public native int[] sort(int array[]);
 
   // Test Driver
   public static void main(String[] args) {
      try{

         int n;  
         Scanner sc=new Scanner(System.in);  
         System.out.print("Enter the number of elements you want to store: ");  
         //reading the number of elements from the that we want to enter  
         n=sc.nextInt();  
         //creates an array in the memory of length 10  
         int[] array = new int[n];  
         System.out.println("Enter the elements of the array: ");  
         for(int i=0; i<n; i++)  
         {  
            //reading array elements from the user   
            array[i]=sc.nextInt();  
         }  
         int sorted[] = new Sorting().sort(array);  // invoke the native method
         System.out.println("Array elements are: ");  
         // accessing array elements using the for loop  
         for (int i=0; i<n; i++)   
         {  
         System.out.println(sorted[i]);  
         }  
      }
      catch(Exception ee){
         System.out.println(ee.getMessage());
      }
   }
}