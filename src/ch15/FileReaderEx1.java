package ch15;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderEx1 {
    public static void main(String[] args) {
        try {
            String fileName = "test.txt";
            FileInputStream fis = new FileInputStream(fileName);
            FileReader fos = new FileReader(fileName);

            int data = 0;

            while((data=fis.read())!=-1) {
                System.out.print(data);
            }

            System.out.println();

            while((data=fos.read())!=-1) {
                System.out.print(data);
            }

            System.out.println();

            fis.close();
            fos.close();

        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
