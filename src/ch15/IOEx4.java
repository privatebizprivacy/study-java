package ch15;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class IOEx4 {
    public static void main(String[] args) {
        //  입력, 출력, 버퍼를 선언하고 초기화합니다.
        byte[] inSrc = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        byte[] outSrc = null;
        byte[] temp = new byte[4];

        //  입출력 스트림들을 선언하고 null로 초기화합니다.
        ByteArrayInputStream input = null;
        ByteArrayOutputStream output = null;

        //  입출력 스트림들에 각 각의 인스턴스를 대입합니다.
        input = new ByteArrayInputStream(inSrc);
        output = new ByteArrayOutputStream();

        //  try
        //  입출력스트림으로 데이터를 읽고 쓴다.
        try {
            while(input.available()>0){

                int len = input.read(temp);
                output.write(temp, 0, len);
                
            }
        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        //  catch

        //  출력스트림에서 데이터들을 추출하고 출력한다.
        outSrc = output.toByteArray();

        System.out.println("Input Source    :"  +   Arrays.toString(inSrc));
        System.out.println("Temp            :"  +   Arrays.toString(temp));
        System.out.println("Output Source   :"  +   Arrays.toString(outSrc));
    }
}
