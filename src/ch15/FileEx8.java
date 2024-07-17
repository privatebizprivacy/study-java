package ch15;

import java.io.File;

public class FileEx8 {
    static int deletedFiles = 0;

    public static void main(String[] args) {

        //  입력이 올바른지 학인합니다.
        if (args.length != 1) {
            System.out.println("USAGE : java FileEx8 Extension");
            System.exit(0);
        }

        //  현재 경로를 추출합니다.
        String currDir = System.getProperty("user.dir");

        //  현재 경로를 대상으로하는 파일 객체를 만들고, 확장자를 추출한다.
        File dir = new File(currDir);
        String ext = args[0];

        //  확장자를 가진 파일들을 삭제하고, 완료를 출력한다.
        delete(dir, ext);
        System.out.println(deletedFiles + "개의 파일이 삭제되었습니다.");
    }

    public static void delete(File dir, String ext) {
        //  파일 및 폴더 목록을 리스트로 추출한다.
        File[] files = dir.listFiles();

        //  다음을 반복한다.
        for(int i=0; i<files.length; i++) {

            //  1. 폴더인지 확인하고, 폴더면 이 메소드를 다시 실행한다.
            if(files[i].isDirectory()) {
                delete(files[i], ext);
            
            //  2. 파일의 절대경로를 추출한다.
            }else{
                String fileName = files[i].getAbsolutePath();
                //  1. 파일의 확장자가 일치하는지 확인한다. 일치하면 파일을 삭제하고 성공이라는 메시지를 출력한다.
                if(fileName.endsWith(ext)){

                    if(files[i].delete()){
                        //  그리고 삭제한 파일의 개수를 증가시킨다.
                        System.out.println("- 삭제 성공");
                        deletedFiles++;
                    }else {
                        //  2. 삭제실패 시 실패라는 메시지를 출력한다.
                        System.out.println("- 삭제 실패");
                    }
                }
            }
        }
    }
}
