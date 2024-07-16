package ch15;

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccess {

    public static void main(String[] args) {

        int[] score = {
            1, 100, 90, 90,
            2, 70, 90, 100,
            3, 100, 100, 100,
            4, 70, 60, 80,
            5, 70, 90, 100
        };
        int sum = 0;

        try {
            RandomAccessFile raf = new RandomAccessFile("score.dat", "rw");

            for(int i=0; i<score.length; i++) {
                raf.writeInt(score[i]);
            }

            int i = 4;

            while (true) {
                raf.seek(i);
                sum += raf.readInt();
                i+=16;
            }

        } catch (EOFException eof) {
            // TODO: handle exception
            System.out.println("합계: " + sum);
        }catch (IOException e) {
            e.printStackTrace();
        }

    }

}
