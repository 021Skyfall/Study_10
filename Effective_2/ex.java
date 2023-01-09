package Effective_2;

import java.io.File;

public class ex {
    public static void main(String[] args) {
        File file = new File("./");
        File[] files = file.listFiles();
        String str = "안녕 ";

        for (int i = 0; i < files.length; i++ ) {
            String name = files[i].getName();
            if (name.startsWith("code"))
                files[i].renameTo(new File("./",str+name));
        }
    }
}
