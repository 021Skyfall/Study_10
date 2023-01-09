package Effective_2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWrite { // 문자 기반 스트림 (2byte)
    public static void main(String[] args) {
        try {
            String name = "File파일.txt";
            FileWriter writer = new FileWriter(name);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            String str = "write 작성";
            writer.write(str);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
