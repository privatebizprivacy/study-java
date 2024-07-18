package ch15;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class IOEx1 {
    public static void main(String[] args) {

        //  입력과 출력할 바이트배열을 선언합니다.
        byte[] inSrc = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        byte[] outSrc = null;

        //  ByteArray입출력스트림을 선언합니다.
        ByteArrayInputStream input = null;
        ByteArrayOutputStream output = null;

        //  ByteArray입출력스트림을 초기화합니다.
        input = new ByteArrayInputStream(inSrc);
        output = new ByteArrayOutputStream();

        //  입력스트림으로부터 데이터를 읽고 출력스트림에 데이터를 씁니다.
        int data = -1;

        while((data = input.read())!=-1) {
            output.write(data);
        }

        //  출력스트림의 내용을 byte배열로 바꾸어 앞서 선언한 출력 바이트배열에 대입합니다.
        outSrc = output.toByteArray();

        //  입력과 출력 바이트배열을 출력합니다.
        System.out.println(Arrays.toString(inSrc));
        System.out.println(Arrays.toString(outSrc));

    }
}
