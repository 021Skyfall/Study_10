package Effective_2;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream; // 바이트 기반 스트림

public class File_Output {
    public static void main(String[] args) {
        try {
            FileOutputStream outputStream = new FileOutputStream("code.txt");
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
            // Buffered 얘네는 그냥 처리해야하는 값이 아주 많을 때 사용하는 임시 저장고 같은 느낌
            // productRepository 처럼
//            String word = "code\ncodes\nand\ncode";
            String word = "한글 입력";

            byte[] b = word.getBytes(); // 파일 입출력 스트림은 바이트 기반임
            outputStream.write(b); // 작성
            outputStream.close(); // 끝
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
