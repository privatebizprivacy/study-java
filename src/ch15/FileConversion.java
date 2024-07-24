package ch15;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileConversion {
    public static void main(String[] args) {
        //  try
        try {
            //  파일입출려문자스트림을 선언한다.
            FileReader fr = new FileReader(args[0]);
            FileWriter fw = new FileWriter(args[1]);

            //  받을 data변수를 선언하고, 입력스트림으로 받은 데이터를 출력스트림에 공백문자를 제외한 문자를 쓴다.
            int data = 0;
            while((data = fr.read()) != -1) {
                if(data != '\n' && data != ' ' && data != '\t' && data != '\r') {
                    fw.write(data);
                }
            }
            //  스트림을 모두 닫는다.
            fr.close();
            fw.close();
        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
