package ch15;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class SerialEx2 {
    public static void main(String[] args) {
        //  try

        try {
                //  파일이름과 파일입력스트림을기반으로하는 버퍼입력스트림을 선언하고 초기화해줍니다.
                String fileName = "UserInfo.ser";
                FileInputStream fis = new FileInputStream(fileName);
                BufferedInputStream bis = new BufferedInputStream(fis);

                //  역직렬화스트림을 선언하고 초기화해줍니다.
                ObjectInputStream input = new ObjectInputStream(bis);

                //  역직렬화스트림으로 출력한 순으로 객체를 읽어옵니다.
                UserInfo2 u1 = (UserInfo2) input.readObject();
                UserInfo2 u2 = (UserInfo2) input.readObject();
                List<UserInfo2> list = (ArrayList) input.readObject();

                //  역직렬화한 객체들을 출력하여주고, 역직렬화스트림을 닫습니다.
                System.out.println(u1.toString());
                System.out.println(u2.toString());
                System.out.println(list.toString());
                input.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        //  catch
    }
}
