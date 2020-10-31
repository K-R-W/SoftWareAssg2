import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

class Except {
    private native void catchThrow() throws IllegalArgumentException;
    // private void callback() throws NullPointerException {
    //   throw new NullPointerException("thrown in CatchThrow.callback");
    // }
    public static void main(String args[]) {
      Except c = new Except();
      try {
        c.catchThrow();
      } catch (Exception e) {
        System.out.println("In Java:\n  " + e);
      }
    }
    static {
      System.loadLibrary("except");
    }
  }