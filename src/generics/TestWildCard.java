package generics;

import java.util.ArrayList;
import java.util.List;

public class TestWildCard {
    public static void main(String[] args) {
    //    List<Number> list = new ArrayList<Integer>();
    // Вместо вопроса может быть подставлен любой класс
        List<Double> list = new ArrayList<>();
        list.add(3.14);list.add(3.15);list.add(3.16);
        showListInfo(list);
        Double sum = summ(list);

        List<String> listString = new ArrayList<>();
        listString.add("1q");listString.add("2w");listString.add("3e");
        showListInfo(listString);

        List<? extends Number> list30 = new ArrayList<Integer>(); // Number Integer  Double ... все подклассы
        List<? super   Number> list31 = new ArrayList<Object>(); //  Number Object (все суперклассы)


    }

    static void showListInfo(List<?> list){
        System.out.println("My list consists by elements " + list);
    }

   static double summ(List<? extends Number> list) {
       double summ = 0;
       for (Number n : list) {
           summ += n.doubleValue();
       }
       return summ;
    }
}
