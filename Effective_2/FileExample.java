package Effective_2;

import java.io.File;
import java.io.IOException;

public class FileExample {
    public static void main(String[] args) throws IOException {
        File file = new File("File파일.txt");
        File file1 = new File("./","new파일.txt"); // 파일 생성을 위해 인스턴스화
                                                                // 주소, 이름
        file1.createNewFile(); // 파일 생성 메소드

        System.out.println(file.getPath()); // 파일 이름? 위치?
        System.out.println(file.getParent()); // 아 이거 상위 폴더 체크
        System.out.println(file.getCanonicalPath()); // 이거 주소 찍어줌
        System.out.println(file.canWrite()); // 작성 가능 여부

        // 파일명에 덧붙이기
        File file2 = new File("./"); // 앞선 파일들 인스턴스화
        File[] list = file2.listFiles(); // 파일 타입의 배열 생성 후 담기
        String fix = "code";

        for (int i = 0; i < list.length; i++) { // 배열에 담긴 파일 개수만큼 반복
            String name = list[i].getName(); // 파일 이름 얻어오기
            if (name.endsWith("txt") && !name.startsWith("code")) { // txt로 끝나거나 code로 시작하지 않는 파일 거르기
                list[i].renameTo(new File(file2,fix+name));
                // i 차수에 걸린 파일 인스턴스 화 후 이름 다시 변경
            }
        }
    }
}
