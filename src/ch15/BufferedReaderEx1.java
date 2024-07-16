package ch15;

import java.io.BufferedReader;
import java.io.FileReader;

public class BufferedReaderEx1 {
    public static void main(String[] args) {

        try (FileReader fr = new FileReader("src/ch15/BufferedReaderEx1.java");
        BufferedReader br = new BufferedReader(fr);) {

            String line;

            for(int i=1; (line=br.readLine())!=null; i++) {

                if(line.contains(";")) {
                    System.out.println(i + ":" + line);
                }

            }

        } catch (Exception e) {
            // TODO: handle exception
        }

    }    
}
