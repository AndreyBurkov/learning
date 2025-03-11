import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class MainTest {

    public static void main(String[] args) throws URISyntaxException, InterruptedException {
        URI uri = new MainTest().getClass().getClassLoader().getResource("test.txt").toURI();


        int[] arr = new int[3];
        arr[0] = 10;
        arr[1] = 20;
        arr[2] = 30;

        List<int[]> list = new ArrayList<>();
        list.add(arr);

        if (arr instanceof int[]) {
            System.out.println("Class name: " + arr.getClass().getName());
        }
        foo(arr);
    }

    private static void foo(Object o) {
        System.out.println(o);
    }


}







