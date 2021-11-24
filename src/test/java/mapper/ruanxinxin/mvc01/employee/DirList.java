package mapper.ruanxinxin.mvc01.employee;

import java.io.*;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DirList {
    public static void main(String[] args) throws IOException {
        File javaFile = new File("./src/test/java/mapper/ruanxinxin/mvc01/inter/TestManager.java");
        FileInputStream fis = new FileInputStream(javaFile);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1 << 16];
        int n;
        while ((n = fis.read(buffer)) != -1) {
            // bos.write(buffer, 0, n);
        }
        BufferedInputStream dataInputStream = new BufferedInputStream(
                new ByteArrayInputStream(buffer)
        );
        while (dataInputStream.read() != -1) {
            System.out.print((char) dataInputStream.read());
        }
        BufferedReader in = new BufferedReader(
                new FileReader(
                        javaFile
                )
        );

    }

    public static void rucurse(File[] all) {
        for (File item : all) {
            if (item.isDirectory()) {
                rucurse(item.listFiles());
            } else {
                System.out.println(item.getName());
            }
        }
    }

}

class DirFilter implements FilenameFilter {
    private Pattern pattern;

    public DirFilter(String regex) {
        pattern = Pattern.compile(regex);
    }

    @Override
    public boolean accept(File dir, String name) {
        return pattern.matcher(name).matches();
    }


}

class testAnous {
    public testAnous(String arg) {
    }

}