package pipedinputoutput;

import java.io.IOException;
import java.io.PipedOutputStream;

/**
 * describe
 *
 * @author JKD
 * @version 1.0.0
 * @ClassName WriteData.java
 * @createTime 2019年04月30日 10:16:00
 */
public class WriteData {

    public void writeMethod(PipedOutputStream outputStream) {
        System.out.println("写方法：");
        try {
            System.out.println("write :");
            for (int i = 0; i < 100; i++) {
                String outData = "" + (i+1);
                outputStream.write(outData.getBytes());
                System.out.print(outData);
            }
            System.out.println();
            System.out.println("写结束！");
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
