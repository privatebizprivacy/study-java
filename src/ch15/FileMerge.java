package ch15;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileMerge {
    public static void main(String[] args) {
        //  입력이 올바른지 확인합니다.
        if(args.length != 1) {
            System.out.println("USAGE : java FileMerge filename");
            System.exit(0);
        }

        //  합칠 파일의 이름을 추출합니다.
        String mergeFileName = args[0];

        //  try
        try {
            //  임시파일을 생성합니다.
            File tempFile = File.createTempFile("~mergetemp", ".tmp");
            tempFile.deleteOnExit();

            //  파일출력스트림을 선언하고 임시파일로 초기화합니다.
            FileOutputStream fos = new FileOutputStream(tempFile);
            BufferedOutputStream bos = new BufferedOutputStream(fos);

            //  버퍼입력스트림을 선언합니다.
            BufferedInputStream bis = null;

            //  첫번째로 합칠 파일의 객체를 선언하고 초기화합니다.
            int i = 1;
            File file = new File(mergeFileName +"_."+i);
            
            //  합칠 파일이 존재하지 않을때까지 파일을 합칩니다.
            while (file.exists()) {
            //  중간에 파일이 변경되지 않도록 파일을 읽기전용으로 셋팅합니다.
                file.setReadOnly();

                //  합칠 파일 읽기위해 버퍼입력스트림을 적절히 초기화합니다.
                bis = new BufferedInputStream(new FileInputStream(file));

                //  버퍼입력스트림에서 데이터를 읽어 버퍼출력스트림에 써줍니다.
                int data =0;
                while((data=bis.read())!=-1){
                    bos.write(data);
                }
                //  버퍼 입력 스트림을 닫습니다.
                bis.close();

                //  다음 합칠 파일의 파일 객체를 선언하고 초기화하도록합니다.
                i++;
                file = new File(mergeFileName + "_." +i);
                System.out.println(file.toString());
            }

            //  버퍼출력스트림을 닫습니다.
            bos.close();
            //  합칠 파일의 이름으로 파일객체를 선언하고 초기화합니다.
            File mergedFile = new File(mergeFileName);
            //  합칠 파일의 이름이 존재하면 삭제합니다.
            if(mergedFile.exists()) {
                mergedFile.delete();
            }
            //  임시파일의 이름을 합칠파일의 이름으로 바꿉니다.
            tempFile.renameTo(mergedFile);

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        //  catch
    }
}
