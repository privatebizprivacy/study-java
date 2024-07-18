package ch15;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SerialEx1 {
    public static void main(String[] args) {
        try {
            //  직렬화 데이터를 저장할 파일 이름과 파일스트림을 기반으로하는 버퍼출력스트림을 선언하고 초기화합니다.
            String fileName = "UserInfo.ser";
            FileOutputStream fos = new FileOutputStream(fileName);
            BufferedOutputStream bos = new BufferedOutputStream(fos);

            //  앞서 선언한 버퍼출력스트림을 기반으로하는 직렬화스트림을 선언하고 초기화합니다.
            ObjectOutputStream out = new ObjectOutputStream(bos);

            //  UserInfo 객체 2개를 선언하고 초기화합니다.
            UserInfo2 u1 = new UserInfo2("Kim", "1234", 20);
            UserInfo2 u2 = new UserInfo2("Wexler", "1234", 22);

            //  UserInfo객체 리스트를 선언하고 앞서 2개의 객체를 추가합니다.
            List<UserInfo2> list = new ArrayList<>();
            list.add(u1);
            list.add(u2);

            //  앞서 선언한 2개의 객체와 리스트를 직렬화합니다. 그리고 직렬화스트림을 닫고 완료를 출력합니다.
            out.writeObject(u1);
            out.writeObject(u2);
            out.writeObject(list);
            out.close();
            System.err.println("직렬화를 완료하였습니다.");

        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
