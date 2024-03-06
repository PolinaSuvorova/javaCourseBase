package generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestGenerics {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();// всегда ставим <> иначе объявляем сырой тип
        list.add("jncjdnc");list.add("test");
        for (String o: list ) {
            System.out.println(o + " " + o.length());
        }
    }
}
