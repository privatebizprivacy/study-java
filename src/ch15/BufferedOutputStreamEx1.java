package ch15;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * BufferedOutputStreamEx1
 */
public class BufferedOutputStreamEx1 {

    public static void main(String[] args) {

        try {
            FileOutputStream fos = new FileOutputStream("123.txt", true);
            //  BufferedOutputStream의 버퍼크기를 5로한다.
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            //  파일 123.txt.에 1부터 9까지 출력한다.

            for(int i='0'; i<='9'; i++){
                bos.write(i);
            }

            bos.close();
        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }
    
}