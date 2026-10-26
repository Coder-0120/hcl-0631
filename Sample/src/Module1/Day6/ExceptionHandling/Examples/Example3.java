package Module1.Day6.ExceptionHandling.Examples;

import java.io.IOException;

public class Example3 {
    static  void readFile() throws IOException{
        throw  new IOException("cannot find file to read");
    }
    public static void main(String[] args) {
//        throws: declares an exception in a method signature
        try{
            readFile();
        }
        catch (IOException e){
            System.out.println("cannot reaad file ");
        }


    }
}
