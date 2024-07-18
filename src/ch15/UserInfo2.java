package ch15;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * SuperUser
 */ 
class SuperUser {
    //  속성 name과 password를 선언합니다.
    String name;
    String password;

    //  기본생성자를 아래의 생성자를 통해 구현합니다.
    public SuperUser() {
        this("Unknown", "Unknown");    
    }

    //  name과 password를 파라미터로 하는 생성자를 구현합니다.
    public SuperUser(String name, String password) {
        this.name = name;
        this.password = password;
    }
    
}


/**
 * UserInfo2
 */
//  SuperUser와 Serializable을 상속받는 클래스를 선언합니다.
public class UserInfo2 extends SuperUser implements java.io.Serializable {

    //  age 속성을 선언합니다.
    int age;

    //  name, password, age를 파라미터로하는 생성자를 선언하고 구현합니다.
    public UserInfo2(String name, String password, int age) {
        super(name, password);
        this.age = age;
    }

    //  속성들을 보여주는 toString()을 구현합니다.
    public String toString() {
        return String.format("%s %s %d", super.name, super.password, this.age);
    }

    //  상속받는 name과 password를 쓸 수 있는 writeObject를 오버라이딩 합니다.
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.writeObject(name);
        out.writeObject(password);
        out.defaultWriteObject();
    }

    //  상속받은 name과 password으로 값을 읽을 수 있는 readObject를 오버라이딩 합니다.
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        this.name = (String)in.readObject();
        this.password = (String) in.readObject();
        in.defaultReadObject();
    }
    
}
