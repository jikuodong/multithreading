package dirtyreading;

/**
 * describe 公共的值
 *
 * @author JKD
 * @version 1.0.0
 * @ClassName PublicVar.java
 * @createTime 2019年04月29日 14:16:00
 */
public class PublicVar {
    public String userName = "A";
    public String passWord = "AA";

    synchronized public void setValue(String userName, String passWord) {
        try {
            this.userName = userName;
            Thread.sleep(5000);
            this.passWord = passWord;
            System.out.println("赋值方法线程名称=" + Thread.currentThread().getName()+"姓名="+userName+"密码="+passWord);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 该方法前加上synchronized关键字就同步了
    synchronized public void getValue() {
        System.out.println("获取值方法线程名称="+Thread.currentThread().getName()+"姓名="+userName+"密码="+passWord);
    }
}
