package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ForEachExample {
    public static void main(String[] args) {
        List<String> list = List.of("test","example","question","lambda");
        for (String s: list )
        {     System.out.println(s);
        }
        //или
        list.forEach(s->System.out.println(s));

        List<Integer> list2 = new ArrayList<>();
        list2.add(10);
        list2.add(20);
        list2.add(330);
        list2.add(10);

        list2.forEach(el->{
            System.out.println(el);
            el+=el;
            System.out.println(el);
        });
    }
}
