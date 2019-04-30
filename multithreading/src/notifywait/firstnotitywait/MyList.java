package notifywait.firstnotitywait;

import java.util.ArrayList;
import java.util.List;

/**
 * describe
 *
 * @author JKD
 * @version 1.0.0
 * @ClassName MyList.java
 * @createTime 2019年04月30日 09:23:00
 */
public class MyList {

    private static List<String> list = new ArrayList<>();

    public static void add() {
        list.add("anyString");
    }

    public static int size() {
        return list.size();
    }
}
