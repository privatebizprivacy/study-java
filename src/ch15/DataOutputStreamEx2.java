package ch15;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class DataOutputStreamEx2 {
    public static void main(String[] args) {
        //  바이트배열스트림과 스트림기반문자보조스트림을 선언하고 null로 초기화하여줍니다.
        ByteArrayOutputStream bos = null;
        DataOutputStream dos = null;

        //  출력할 결과값을 null로 초기화하여줍니다.
        byte[] result = null;

        //  try
        try {
            //  스트림들의 인스턴스를 각 각 할당하여주고 10, 20.f, true를 씁니다.
            bos = new ByteArrayOutputStream();
            dos = new DataOutputStream(bos);
            dos.writeInt(10);
            dos.writeFloat(20);
            dos.writeBoolean(true);

            //  출력소스로부터 바이트배열을 추출합니다.
            result = bos.toByteArray();

            //  String배열을 선언하고 바이트배열의 크기만큼 인스턴스를 초기화하여 줍니다.
            String[] hex = new String[result.length];

            //  바이트배열의 값을 각각 String으로 변환하여 배열에 16진수형태로 할당하여 줍니다.
                //  바이트배열의 값이 0보다 작으면 256을 더하여주고 아니면 그냥 할당합니다.
            for(int i=0; i<hex.length; i++) {
                if(result[i]<0) {
                    hex[i] = String.format("%02x", result[i]+256);
                }else {
                    hex[i] = String.format("%02x", result[i]);
                }
            }

            //  바이트배열과 문자열을 출력하여 줍니다.
            System.out.println("10진수  :" + Arrays.toString(result));
            System.out.println("16진수  :" + Arrays.toString(hex));

            dos.close();
        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        //  IOException e
    }
}
