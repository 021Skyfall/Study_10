package Effective_2;

import java.io.BufferedInputStream;
import java.io.FileInputStream; // 바이트 기반 스트림

public class File_Input {
    public static void main(String[] args) {
        try {
            FileInputStream input = new FileInputStream("code.txt");
            BufferedInputStream bufferedInputStream = new BufferedInputStream(input);
            int i = 0;
            while ((i=input.read()) != -1) {// input.read() 의 리턴 값을 i 에 저장하고
                                                // 값이 -1 인지 확인
                System.out.println((char) i);
            }
            input.close(); // 말 그대로 인풋 로직을 끝냄
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
// 한글 뽑아내려 했더니í
//
//
//ê
//¸
//
//
//ì
//
//
//ë
// 
//¥
// 이따구로 나옴 >> 유니코드 변환이 안된다는 뜻
