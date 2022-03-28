package algorithm;


import java.util.ArrayList;
import java.util.List;

/**
 * @author 熊乾坤
 * @date 2020-10-28 8:29
 */
public class Test1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.removeIf("2"::equals);
        System.out.println(list);
    }
}
