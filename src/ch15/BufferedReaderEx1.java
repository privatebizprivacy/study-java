package ch15;

import java.io.BufferedReader;
import java.io.FileReader;

public class BufferedReaderEx1 {
    public static void main(String[] args) {
        //try
        try {
            //FileReader와 BufferedReader를 생성한다.
            FileReader fr = new FileReader("./src/ch15/BufferedReaderEx1.java");
            BufferedReader br = new BufferedReader(fr);

            //데이터를 읽고 쓰는데 사용할 변수를 선언하고 초기화한다.
            String line = "";

            //특정문자를 포함하는 경우에만 라인수와 데이터를 출력하도록 한다.
            for(int i=1; (line = br.readLine())!=null; i++) {
                if(line.indexOf(';')!=-1){
                    System.out.println(i + ":" + line);
                }
            }

            //BufferedReader를 닫는다.
            br.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        //catch IOException e
    }
}
