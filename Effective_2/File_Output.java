package Effective_2;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

public class File_Output {
    public static void main(String[] args) {
        try {
            FileOutputStream outputStream = new FileOutputStream("codeX.txt");
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
            // Buffered 얘네는 그냥 처리해야하는 값이 아주 많을 때 사용하는 임시 저장고 같은 느낌
            // productRepository 처럼
            String word = "code\ncodes\nand\ncode";

            byte[] b = word.getBytes(); // 적절한 크기의 배열 생성해서 byte 타입으로 word 의 값 입력
            outputStream.write(b); // 작성
            outputStream.close(); // 끝
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
