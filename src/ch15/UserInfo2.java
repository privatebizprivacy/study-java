package ch15;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * SuperUser
 */ 
class SuperUser {
    String name;
    String password;

    public SuperUser() {
        this("Unknown", "1111");
    }

    public SuperUser(String name, String password) {
        this.name = name;
        this.password = password;
    }
    
}


/**
 * UserInfo2
 */
public class UserInfo2 extends SuperUser implements Serializable {

    int age;

    public UserInfo2() {
        this("Unknown", "1111",0);
    }

    public UserInfo2(String name, String password, int age) {
        super(name, password);
        this.age = age;
    }

    @Override
    public String toString() {
        return "("+name+","+ password+","+age+")";
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.writeUTF(name);
        out.writeUTF(password);
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException{
        this.name = in.readUTF();
        this.password = in.readUTF();
        in.defaultReadObject();
    }
    
}
