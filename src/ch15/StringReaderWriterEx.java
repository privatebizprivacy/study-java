package ch15;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class StringReaderWriterEx {
    public static void main(String[] args) {
        String inputData = "ABCD";
        //  inputData를 대상으로하는 입력소스와 출력소스를 생성합니다.
        StringReader input = new StringReader(inputData);
        StringWriter output = new StringWriter();

        //  읽고 쓸 데이터 변수를 선언하고 0으로 초기화합니다.
        int data = 0;

        //  try
        try {
            //  데이터를 읽고 씁니다.
            while((data = input.read())!=-1) {
                output.write(data);
            }
        //  catch IOException e
        //  입력과 출력스트림의 데이터를 출력합니다.    
        System.out.println(inputData);
        System.out.println(output.getBuffer().toString());
        System.out.println(output.toString());
        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
