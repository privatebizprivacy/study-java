package ch15;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class FileEx6 {
    static int found = 0;
    public static void main(String[] args) {
        if(args.length != 2) {
            System.out.println("USAGE : java FileEx6 DIRECTORY KEYWORED");
            System.exit(0);
        }

        File directroy = new File(args[0]);
        String word = args[1];

        if(!directroy.exists()||!directroy.isDirectory()) {
            System.out.println("유효하지 않은 디렉토리입니다.");
            System.exit(0);
        }

        try {
            findInFiles(directroy, word);
        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        System.out.println();
        System.out.println("총 " + found + "개의 라인에서 '" + word +"'을/를 발견하였습니다.");

    }

    public static void findInFiles(File dir, String keyword) throws IOException {

        // 파일리스트를 꺼냅니다.
        File[] files = dir.listFiles();

        // 꺼낸 파일 리스트들을 다음과 같이 반복합니다.

        for(int i=0; i<files.length; i++) {

            if(files[i].isDirectory()) {
                // 1. 파일 객체가 디렉토리라면 위 메소드를 반복합니다.
            }else{
                // 2. 파일 객체가 파일이라면 다음과 같은 처리를 합니다.
        
            /**
             * 파일 객체의 파일 이름을 알아냅니다.
             *  
             * 파일 객체의 확장자를 알아냅니다.
             * 
             * 알아낸 확장자 앞뒤에 ,를 붙여줍니다.
             * 
             * 확장자가 java,txt,bak인지 확인하고 아니면 넘어갑니다.
             * 
             * 절대경로와 파일이름을 구분자를 사용하여 합쳐주고 파일이름에 저장합니다.
             * 
             * 파일 객체를 읽을 스트림과 보조스트림을 생성합니다.
             * 
             * 데이터와 라인수를 초기화합니다.
             * 
             * 생성한 스트림으로부터 데이터를 읽어서 키워드가 있다면 파일이름과 줄을 출력합니다.
             */

             String fileName = files[i].getName();

             String exetension = fileName.substring(fileName.lastIndexOf(".")+1);

             exetension = "," + exetension + ",";

             if(",java,txt,bak,".indexOf(exetension) == -1) continue;

             fileName = dir.getAbsolutePath() + File.separator + fileName;

             FileReader fr = new FileReader(fileName);
             BufferedReader br = new BufferedReader(fr);

             String data = "";
             int lineNum = 0;

             while((data = br.readLine()) != null){

                lineNum++;

                if(data.indexOf(keyword)!=-1){
                    System.out.println("["+fileName+"]"+"("+lineNum+")" + data);
                }

             }
             br.close();
            }
        }

    }
}
