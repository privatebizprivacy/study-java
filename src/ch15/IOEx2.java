package ch15;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class IOEx2 {
    public static void main(String[] args) {
        //  입력, 출력, 임시배열을 선언하고, 입력과 임시배열을 초기화합니다.
        byte[] inSrc = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        byte[] outSrc = null;
        byte[] temp = new byte[10];

        //  ByteArrayInpuStream과 ByteArrayOutputStream을 선언하고 null로 초기화합니다.
        ByteArrayInputStream input = null;
        ByteArrayOutputStream output = null;

        //  ByteArrayInputStream과 ByteArrayOutputStream에 각각의 인스턴스를 할당합니다.
        input = new ByteArrayInputStream(inSrc);
        output = new ByteArrayOutputStream();

        //  입출력 스트림으로 임시배열에 데이터를 쓰고 읽습니다.
        input.read(temp, 0, inSrc.length);
        output.write(temp, 5, 5);

        //  앞서 선언한 출력배열에 출력스트림의 값들을 할당합니다.
        outSrc = output.toByteArray();

        //  입력, 임시배열, 출력 순으로 배열의 값들을 출력합니다.
        System.out.println(Arrays.toString(inSrc));
        System.out.println(Arrays.toString(temp));
        System.out.println(Arrays.toString(outSrc));

    }
}
