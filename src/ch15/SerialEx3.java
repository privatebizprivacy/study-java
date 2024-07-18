package ch15;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SerialEx3 {
    public static void main(String[] args) {

        String fileName = "UserInfo2.ser";

        try {

            FileOutputStream fos = new FileOutputStream(fileName);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream out = new ObjectOutputStream(bos);

            UserInfo2 u1 = new UserInfo2("Kim", "1234", 20);
            UserInfo2 u2 = new UserInfo2("Park", "5678", 30);
            UserInfo2 u3 = new UserInfo2("Song", "910", 40);

            List<UserInfo2> list = new ArrayList<>();
            list.add(u1);
            list.add(u2);
            list.add(u3);

            out.writeObject(list);

            out.close();

            FileInputStream fis = new FileInputStream(fileName);
            BufferedInputStream bis = new BufferedInputStream(fis);
            ObjectInputStream in = new ObjectInputStream(bis);

            List<UserInfo2> readList = (ArrayList) in.readObject();

            for(UserInfo2 u : readList) {
                System.out.println(u.toString());
            }

            in.close();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }
}
