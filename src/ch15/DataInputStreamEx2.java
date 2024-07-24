package ch15;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;

public class DataInputStreamEx2 {
    public static void main(String[] args) {
        //  합과 점수를 선언하고 0으로 초기화하여줍니다.
        int sum = 0;
        int score = 0;

        //  score.dat을 대상으로하는 FileInputStream과 DataInputStream을 null로 초기화하여줍니다.
        FileInputStream fis = null;
        DataInputStream dis = null;

        //  try
        try {
            //  앞의 스트림들을 각각의 인스턴스들로 초기화하여줍니다.
            fis = new FileInputStream("score.dat");
            dis = new DataInputStream(fis);
            //  score.dat으로부터 데이터를 읽어서 출력하고 합에 더하여줍니다.
            while (true) {
                score = dis.readInt();
                sum += score;
            }
        //  catch (EOFException e)
        //  점수의 총합을 출력하여줍니다.
        } catch (EOFException e) {
            // TODO: handle exception
            System.out.println("총합 :" + sum);
        //  catch (IOException ie)
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        //  finally
            //  try
            try {
            // dis!=null인경우에 close()를 합니다.
                if(dis!=null) {
                    dis.close();
                }
            //  IOException   
            } catch (IOException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
    }
}
