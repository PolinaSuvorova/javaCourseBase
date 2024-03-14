package stream_example;

import java.util.ArrayList;
import java.util.List;

// Использование нескольких ядер процессора для потока
public class parallelStreamExample {
    public static void main(String[] args) {
        List<Double> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add((double) (i * 0.5));
        }

        double sum = list.parallelStream().reduce((a,e)->a+e).get();
        System.out.println(sum);

        // Если порядок элементов важен, то параллельность лучше не использовать т.к. результат будет не предсказуем
        double sumError = list.parallelStream().reduce((a,e)->a/e).get();
        double sumGood = list.stream().reduce((a,e)->a/e).get();
        System.out.println(sumGood==sumError);
    }
}
