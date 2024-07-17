package ch15;

import java.io.File;
import java.io.FilenameFilter;

public class FileEx7 {
    public static void main(String[] args) {

        //  입력받은 패턴이 올바르게 입력됬는지 확인한다.
        if(args.length != 1) {
            System.out.println("USAGE : java FileEx7 pattern");
            System.exit(0);
        }

        //  현재 파일을의 경로를 입력받는다.
        String currDir = System.getProperty("user.dir");

        //  파일 객체와 패턴을 초기화한다.
        File file = new File(currDir);
        final String pattern = args[0];

        //  파일 객체에서 파일 이름들을 뽑아내는데, 파일이름필터를 이용하여 뽑아낸다.
            //  1. FilenaeFilter의 익명 객체를 선언하여 생성한다.
        String[] list = file.list(new FilenameFilter() {

            @Override
            public boolean accept(File dir, String name) {
                // TODO Auto-generated method stub
                return name.indexOf(pattern) != -1;
            }
            
        });

        //  뽑아낸 파일이름들을 출력한다.
        for(int i=0; i<list.length; i++){
            System.out.println(list[i]);
        }

    }
}
