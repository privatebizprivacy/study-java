package ch15;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderEx1 {
    public static void main(String[] args) {
        //  try
        try {
        //  fileName, FileInputStream, FileReader 생성
        String fileName = "README.md";
        FileInputStream fis = new FileInputStream(fileName);
        FileReader fr = new FileReader(fileName);

        //  data 선언
        int data = 0;

        //  FileInputStream을 이용해서 파일내용을 읽어 화면에 출력한다.
        while ((data=fis.read())!=-1) {
            System.out.print((char)data);
        }
        fis.close();
        System.out.println();

        //  FileReader를 이용해서 파일내용을 읽어 화면에 출력한다.
        while ((data=fr.read())!=-1) {
            System.out.print((char)data);
        }
        fr.close();
        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        //  catch IOException
    }
}
