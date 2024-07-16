package ch15;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class SerialEx2 {
    public static void main(String[] args) {
        try {
            String filename = "UserInfo.txt";
            FileInputStream fis = new FileInputStream(filename);
            BufferedInputStream bos = new BufferedInputStream(fis);

            ObjectInputStream out = new ObjectInputStream(bos);

            UserInfo2 u1 = (UserInfo2)out.readObject();
            UserInfo2 u2 = (UserInfo2)out.readObject();
            List<UserInfo2> list = (List)out.readObject();

            System.out.println(u1);
            System.out.println(u2);
            System.out.println(list);

        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
