package  ch15;

import java.io.File;
import java.io.IOException;

public class FileEx9 {
    public static void main(String[] args) throws IOException {
        // //  입력이 올바른지 확인합니다.
        // if(args.length == -1){
        //     System.out.println("USAGE : java FileEx9 DIRECTORY");
        //     System.exit(0);
        // }

        // //  파일 객체를 선언한다.
        // File dir = new File(args[0]);

        // //  파일 객체가 존재하는지 디렉터리인지 확인한다.
        // if(!dir.exists() || !dir.isDirectory()) {
        //     System.out.println("유효하지 않는 디렉토리입니다.");
        //     System.exit(0);
        // }

        String currDir = System.getProperty("user.dir");
        String newDir = currDir + File.separator + "test";
        File dir = new File(newDir);
        dir.mkdirs();

        for(int i=0; i<10; i++){
            File testFile = new File(dir,"test"+i+".txt");
            testFile.createNewFile();
        }

        //  디렉터리라면 파일 및 폴더 리스트를 추출한다.
        File[] list = dir.listFiles();

        //  추출한 파일 및 폴더들의 이름을 1부터 시작하여 숫자로 바꾼다.
        for(int i=0; i<list.length; i++) {
            //  파일 및 폴더의 이름을 추출한다.
            String fileName = list[i].getName();

            //  이름 앞에 "0000"을 붙여서 newFileName을 초기화한다.
            String newFileName = "0000" + fileName.replace("test", "");

            //  초기화한 newFileName의 이름을 끝에서 7문자를 추출하여 대입한다.
            newFileName = newFileName.substring(newFileName.length()-7);

            //  파일의 이름을 추출한 newFileName으로 바꾼다.
            list[i].renameTo(new File(dir,newFileName));

        }
    }
}
