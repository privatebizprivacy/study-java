package ch15;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class StringReaderWriterEx {
    public static void main(String[] args) {
        String inputData = "ABCDE";
        StringReader input = new StringReader(inputData);
        StringWriter output = new StringWriter();

        try {
            int data = 0 ;
            while((data=input.read())!=-1){
                output.write(data);
            }
        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        System.out.println("Input Date : " + inputData);
        System.out.println("Output Data : " + output.toString());
        System.out.println("Output Data : " + output.getBuffer().toString());
    }
}
