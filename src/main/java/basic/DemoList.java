package basic;


import java.util.HashSet;
import java.util.Set;

public class DemoList {
    public static void main(String[] args) {
        Set set = new HashSet();
        set.add(null);
        set.add(null);
        System.out.println(set.size());
    }
}
