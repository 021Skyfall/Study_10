package Effective_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileRead { // 문자 기반 스트림 (2byte)
    public static void main(String[] args) {
        try {
            String name = "File파일.txt";
            FileReader reader = new FileReader(name);
            BufferedReader bufferedReader = new BufferedReader(reader);

            int i = 0;
            while ((i=bufferedReader.read()) != -1) {
                System.out.println((char) i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
