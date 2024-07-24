package ch15;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputStreamEx3 {
    public static void main(String[] args) {

        //  int배열을 선언하고 100, 90, 95, 85, 50으로 초기화하여 줍니다.
        int[] score = {100, 90, 95, 85, 50};

        //  try
        try {
            //  sample.txt을 대상으로하는 FileOutpuStream과 DataOutputStream을 초기화하여줍니다.
            FileOutputStream fos = new FileOutputStream("sample.txt");
            DataOutputStream dos = new DataOutputStream(fos);

            //  반복문으로 int배열을 출력소스에 써줍니다.
            for(int i=0; i<score.length; i++) {
                dos.writeInt(score[i]);
            }

            //  출력소스를 닫습니다.
            dos.close();
        //  catch(IOException e)
        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        

    }
}
