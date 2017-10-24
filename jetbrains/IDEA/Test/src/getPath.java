import java.io.File;
import java.io.IOException;
import java.net.URL;

public class getPath {

    // .class文件根目录
    public void getPath1() {
        File file = new File(getClass().getResource("/").getPath());
        System.out.println(file);
    }

    // .class文件绝对路径
    public void getPath2() {
        File file = new File(getClass().getResource("").getPath());
        System.out.println(file);
    }

    // 项目根路径
    public void getPath3() throws IOException {
        File directory = new File("");// 参数为空
        String courseFile = directory.getCanonicalPath();
        System.out.println(courseFile);
    }

    private void getPath4() {
        URL xmlpath = this.getClass().getClassLoader().getResource("./Test.iml");
        System.out.println(xmlpath);
    }
    // 项目根路径
    private void getPath5() {
        System.out.println(System.getProperty("user.dir"));
    }

    private void getPath6() {
        System.out.println(System.getProperty("java.class.path"));
    }

    public static void main(String[] args) throws IOException {
        getPath path = new getPath();
        path.getPath1();
        path.getPath2();
        path.getPath3();
        System.out.println("------------------------");
        path.getPath4();
        path.getPath5();
        path.getPath6();
    }
}
