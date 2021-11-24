package mapper.ruanxinxin.mvc01.io;

import mapper.ruanxinxin.mvc01.inter.Manager;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.*;

public class Echo implements Serializable{
    public static void main(String[] args) throws IOException {
        File f = new File("/Users/xinxin/desktop/test.txt");
        FileOutputStream fos = new FileOutputStream(f);
        OutputStreamWriter writer = new OutputStreamWriter(fos, "gbk");
        writer.append("232423");
        writer.append("/n/r");
        writer.append("\n\r");
        writer.append("世2342342界");

        writer.close();
        fos.close();
    }

    @Test
    public void outPutStream() throws IOException {
        //byte[] bytes = new byte[]{11, 22, 33, 34, 44, 55, 66, 77, 88, 99, 111, 127};
        File fileSrc = new File("/Users/xinxin/IdeaProjects/mybatisProj01/src/test/java/mapper/ruanxinxin/mvc01/io/test11111.file");

        ObjectOutputStream outputStream=new ObjectOutputStream(
                new FileOutputStream(fileSrc)
        );
        outputStream.writeObject(new Manager());

        outputStream.flush();
        outputStream.close();
    }

    @Test
    public void inputTest() throws IOException, ClassNotFoundException {
        File fileSrc = new File("/Users/xinxin/IdeaProjects/mybatisProj01/src/test/java/mapper/ruanxinxin/mvc01/io/test11111.file");
        ObjectInputStream inputStream=new ObjectInputStream(
                new FileInputStream(fileSrc)
        );
        Object obj=inputStream.readObject();
        System.out.println(obj.getClass().getName());

    }
}
