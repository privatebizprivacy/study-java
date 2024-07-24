package ch15;

import java.util.Date;

public class PrintStreamEx1 {
    public static void main(String[] args) {
        int i = 65;
        float f = 1234.56789f;

        Date d = new Date();

        System.out.printf("문자 %c의 코드는 %d%n",  i,  i);
        System.out.printf("%d는 8진수로 %o, 16진수로 %x%n", i, i, i);
        System.out.println();
        System.out.printf("123456789012345678901234567890%n");
        System.out.printf("%s%-5s%5s%n", "123", "123", "123");
        System.out.println();
        System.out.printf("%-8.1f%8.1f  %e%n", f, f, f);
        System.out.println();
        System.out.printf("오늘은 %tY년 %tm월 %td일 입니다.", d,d,d);
        System.out.printf("지금은 %tH시 %tM분 %tS초입니다.%n", d,d,d);
        System.out.printf("지금은 %1$tH시 %1$1tM분 %1$tS초입니다.%n", d);
    }
}
