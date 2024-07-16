package ch15;

import java.util.Date;

public class PrintStreamEx1 {
    public static void main(String[] args) {
        int i = 65;
        float f = 1234.56789f;

        Date d = new Date();

        System.out.printf("%1$d%1$3d%1$-3d %n", i);
        System.out.printf("%f%1$8.2f%1$-8.2f %n",f);
        System.out.printf("%1$5s %1$5s %n",i);
        System.out.printf("%2$e %1$o %1$x %n",i,f);
        System.out.printf("%1$tH %1$tM %1$S",d);

        }
}
