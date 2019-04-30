package pipedinputoutput;

import java.io.PipedInputStream;

/**
 * describe
 *
 * @author JKD
 * @version 1.0.0
 * @ClassName ThreadRead.java
 * @createTime 2019年04月30日 10:25:00
 */
public class ThreadRead extends Thread{

    private ReadData read;
    private PipedInputStream input;

    public ThreadRead(ReadData read, PipedInputStream input) {
        super();
        this.read = read;
        this.input = input;
    }

    @Override
    public void run() {
        read.readMethod(input);
    }
}
