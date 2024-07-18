package ch15;

import java.util.Arrays;

public class IOEx3 {
    public static void main(String[] args) {

        //  입력, 출력, temp 바이트배열을 선언하고 초기화합니다.
        byte[] inSrc = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        byte[] outSrc = null;
        byte[] temp = new byte[4];

        //  ByteArray 입출력 스트림을 선언하고 null로 초기화합니다.
        

        //  앞서 선언한 스트림객체들에 각 각의 인스턴스를 할당합니다.

        //  입력 바이트배열을 출력합니다.

        //  try IOException

        //  입력스트림으로부터 블락킹없이 데이터를 temp에 읽고, 읽은데이터를 출력스트림에 씁니다.
        //  출력스트림으로부터 바이트배열을 추출하고 temp와 바이트배열을 출력합니다.

    }

    public static void printArrays(byte[] temp, byte[] outSrc) {
        System.out.println("temp        :" + Arrays.toString(temp));
        System.out.println("outSrc      :" + Arrays.toString(outSrc));
    }

}
