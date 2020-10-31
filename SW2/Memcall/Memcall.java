import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Memcall {  // Save as HelloJNI.java
   static {
      System.loadLibrary("memc"); // Load native library hello.dll (Windows) or libhello.so (Unixes)
                                   //  at runtime
                                   // This library contains a native method called sayHello()
   }

   String Name,Univ,Branch;
   static String City;
   static int Pin;
   Memcall(String Name_, String Univ_, String Branch_, String City_,int Pin_){
       Name=Name_;
       Univ=Univ_;
       Branch=Branch_;
       City=City_;
       Pin=Pin_;
   }
 
   public static void staticcall(){
       System.out.println("This is static class method called from Native");
       System.out.println("Pin: "+Pin+"\tCity: "+City);
       
   }
   public void objectcall(){
      System.out.println("This is object method call from Native");
      System.out.println("Name: "+Name+"\tUniversity: "+Univ+"\tBranch: "+Branch);
   }

   // Declare an instance native method sayHello() which receives no parameter and returns void
   public native void call();
   
   // Test Driver
   public static void main(String[] args) {
      try{  
        System.out.println("We are in Java now going to C");    
        Memcall objec = new Memcall("Shani","Oxenfurt","Medicine","Oxenfurt",222212);
        objec.call();  // invoke the native method
        System.out.println("We are back in java");    
      }
      catch(Exception ee){
         System.out.println(ee.getMessage());
      }
   }
}