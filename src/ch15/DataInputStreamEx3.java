package ch15;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;

public class DataInputStreamEx3 {
    public static void main(String[] args) {
        //  sum과 score를 초기화합니다.
        int sum = 0;
        int score = 0;

        //  try-with-resources
        try (FileInputStream fis = new FileInputStream("score.dat");
            DataInputStream dis = new DataInputStream(fis)
        ) {
            //  score를 읽고 출력L합니다. 그리고 score를 sum에 더합니다.            
            while (true) {
                score = dis.readInt();
                System.out.println("score: " + score);
                sum += score;
            }
        //  catch EOFException
        } catch (EOFException e) {
            // TODO: handle exception
            System.out.println("sum:    " + sum);
        //  catch IOException
        } catch (IOException e ) {
            e.printStackTrace();
        }
        
    }
}
