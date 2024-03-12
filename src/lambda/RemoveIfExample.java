package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class RemoveIfExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("test");
        list.add("test2");
        list.add("test3");
        list.add("AG");
        list.add("GHG");
        list.add("AGAAAAA");

        list.removeIf(element -> element.length()<5);
        Predicate<String> p = element -> element.length()>5;
        list.removeIf(p);
    }
}
