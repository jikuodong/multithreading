package pipedinputoutput;

import java.io.IOException;
import java.io.PipedInputStream;

/**
 * describe
 *
 * @author JKD
 * @version 1.0.0
 * @ClassName ReadData.java
 * @createTime 2019年04月30日 10:11:00
 */
public class ReadData {

    public void readMethod(PipedInputStream inputStream) {
        try {
            System.out.println("read :");
            byte[] byteArray = new byte[20];
            int readLength = inputStream.read(byteArray);
            while (readLength != -1) {
                String newData = new String(byteArray,0,readLength);
                System.out.print(newData);
                readLength = inputStream.read(byteArray);
            }
            System.out.println();
            System.out.println("读取结束");
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
