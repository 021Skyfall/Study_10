package Effective_2;

import java.io.FileOutputStream;

public class File_Output {
    public static void main(String[] args) {
        try {
            FileOutputStream outputStream = new FileOutputStream("code.txt");
            String word = "code\ncodes\nand\ncode";

            byte[] b = word.getBytes();
            outputStream.write(b);
            outputStream.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
