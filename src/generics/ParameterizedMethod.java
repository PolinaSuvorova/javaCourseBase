package generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParameterizedMethod {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);list.add(2);list.add(3);
        int a = GenMethod.getSecondElement(list);
        System.out.println(a);

        List<String> listString = new ArrayList<>();
        listString.add("1"); listString.add("2");listString.add("3");
        String str = GenMethod.getSecondElement(listString);
        System.out.println(str);
    }
}

class GenMethod{
    public static <T> T getSecondElement(List<T> al){
        return al.get(1);
    }
}
