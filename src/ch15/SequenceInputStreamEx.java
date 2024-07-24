package ch15;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Arrays;
import java.util.Vector;

public class SequenceInputStreamEx {
    public static void main(String[] args) {
        //  arr1, arr2, arr3, outSrc를 선언하고 초기화합니다.
        byte[] arr1 = {0, 1, 2};
        byte[] arr2 = {3, 4, 5};
        byte[] arr3 = {7, 8, 9};
        byte[] outSrc = null;

        //  Vector를 초기화하여 arr1, arr2, arr3을 대상으로하는 ByteArrayInpuStream들을 추가시켜줍니다.
        Vector v = new Vector<>();
        v.add(new ByteArrayInputStream(arr1));
        v.add(new ByteArrayInputStream(arr2));
        v.add(new ByteArrayInputStream(arr3));
        
        //  SequenceInputStream을 vector를 파라미터삼아 초기화하고, ByteArray출력스트림을 생성합니다.
        SequenceInputStream s = new SequenceInputStream(v.elements());
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        //  읽고 출력할 data 변수를 선언하고 초기화합니다.
        int data = 0;

        //  try
        try {
            //  SequenceInputStream으로부터 데이터를 읽고 출력합니다.
            while ((data = s.read())!= -1) {
                output.write(data);
            }

            //  catch IOException e
        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        //  ByteArray출력스트림으로부터 데이터를 읽어옵니다.
        outSrc = output.toByteArray();

        //  arr1~3과 outSrc를 출력합니다.
        System.out.println("arr1    :" + Arrays.toString(arr1));
        System.out.println("arr2    :"  + Arrays.toString(arr2));
        System.out.println("arr3    :" + Arrays.toString(arr3));
        System.out.println("outSrc  :" + Arrays.toString(outSrc));
        
    }
}
