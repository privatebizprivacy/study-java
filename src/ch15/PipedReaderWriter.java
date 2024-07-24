package ch15;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.io.StringWriter;

public class PipedReaderWriter {
    public static void main(String[] args) {
        //  InputThread와 OutputThread를 생성한다.
        InputThread input = new InputThread("InputThread");
        OutputThread output = new OutputThread("OutputThread");

        //  PipedReader와 PipedWriter를 연결한다.
        input.connect(output.getPipedWriter());

        //  생성한 스레드를 시작한다.
        input.start();
        output.start();

    }   //  main
}

class InputThread extends Thread {
    //  PipedReader와 StringWriter를 속성으로 선언하고 초기화한다.
    PipedReader input = new PipedReader();
    StringWriter sw = new StringWriter();

    //  생성자를 생성한다. 조상의 생성자를 호출한다.
    public InputThread(String name) {
        super(name);
    }

    //  run()을 재정의한다.
    public void run() {
        try {
            //  data를 선언하고 초기화하고, 데이터를 읽어서 StringWriter에 값을 쓴다.
            int data = 0;
            while ((data = input.read())!=-1) {
                sw.write(data);
            }

            //  스레드의 이름과 StringWriter의 문자열을 출력한다.
            System.out.println(super.getName() + " received :" + sw.toString());
        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    //  PipedReader를 반환하는 get함수를 정의한다.
    public PipedReader getPipedReader() {
        return input;
    }

    //  PipedReader와 PipedWriter를 연결하는 connect함수를 정의한다.
    public void connect(PipedWriter output) {
        try {
            input.connect(output);
        } catch (IOException e) {
            // TODO: handle exception
        } // connect
    }

}

class OutputThread extends Thread {
    //  PipedWriter를 속성으로 선언하고 초기화한다.
    PipedWriter output = new PipedWriter();

    //  생성자를 생성한다. 조상의 생성자를 호출한다.
    public OutputThread(String name) {
        super(name);
    }

    //  run()을 재정의한다.
    //  메시지를 생성해서 출력하고, PipedWriter에 쓰고 닫는다.
    public void run() {
        try {
            String msg = "Hello World";
            System.out.println(super.getName() + " sent : " + msg);
            output.write(msg);
            output.close();
        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    //  PiperWriter를 반환하는 get함수를 정의한다.
    public PipedWriter getPipedWriter() {
        return output;
    }

    //  PipedReader와 연결하는 connect함수를 정의한다.
    public void connect(PipedReader input) {
        try {
            output.connect(input);
        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

}