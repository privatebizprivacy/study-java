package ch15;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileSplit {
    public static void main(String[] args) {
        //  입력값이 올바른지 확인한다.
        if(args.length < 2  ) {
            System.out.println("USAGE : java FileSplit filename SIZE_KB");
        }

        //  나눌 파일의 단위 크기를 정한다.
        final int VOLUME = Integer.parseInt(args[1]);

        try {
            //  파일이름을 추출한다.
            String filename = args[0];
        
            //  파일입력스트림을 선언하고 초기화한다.
            FileInputStream fis = new FileInputStream(filename);
            BufferedInputStream bis = new BufferedInputStream(fis);

            //  파일출력스트림을 선언한다.
            FileOutputStream fos = null;
            BufferedOutputStream bos = null;

            //  데이터, 크기, 숫자를 선언하고 0으로 초기화한다.
            int i=0;
            int data = 0;
            int number =0;

            //  데이터를 읽어서 각각 다른 파일에 출력한다.
            while ((data = bis.read()) != -1) {
                //  크기가 단위 크기의 배수인지 확인한다.
                    if(i%VOLUME==0){
                    //  크기가 0이아니면 출력을 닫는다.
                        if(i!=0){
                            bos.close();
                        }
                    //  파일출력스트림을 순서를 확장자로하여 선언하고 초기화한다.
                        fos = new FileOutputStream(filename + "_." + ++number);
                        bos = new BufferedOutputStream(fos);
                    }
                    

                //  출럭스트름에 쓰고 크기를 증가시킨다.
                bos.write(data);
                i++;
            
            }
            //  입력과 출력스트림을 닫는다.
            bis.close();
            bos.close();

        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }
}
