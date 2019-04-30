package pipedinputoutput;

import java.io.PipedOutputStream;

/**
 * describe
 *
 * @author JKD
 * @version 1.0.0
 * @ClassName ThreadWrite.java
 * @createTime 2019年04月30日 10:31:00
 */
public class ThreadWrite extends Thread {

    private WriteData write;
    private PipedOutputStream out;

    public ThreadWrite(WriteData write, PipedOutputStream out){
        super();
        this.write = write;
        this.out = out;
    }

    @Override
    public void run() {
        write.writeMethod(out);
    }
}

