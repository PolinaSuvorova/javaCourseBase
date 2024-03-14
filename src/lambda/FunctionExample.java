package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionExample {
    public static void main(String[] args) {


        Dog d1 = new Dog("Garry", 'M', 3, 1);
        Dog d2 = new Dog("Tom", 'M', 6, 5);
        Dog d3 = new Dog("Rex", 'M', 11, 6);
        Dog d4 = new Dog("Sam", 'F', 2, 2);
        Dog d5 = new Dog("Gerda", 'F', 5, 4);
        List<Dog> dogs = new ArrayList<>();
        dogs.add(d1);
        dogs.add(d2);
        dogs.add(d3);
        dogs.add(d4);
        dogs.add(d5);

        DogInfo info = new DogInfo();

        double res = avgOfSmth(dogs, dog -> Double.valueOf(dog.getAge()));
        System.out.println(res);

    }

    private static double avgOfSmth(List<Dog> list, Function<Dog, Double> f) {
        double result = 0;
        for (Dog dog : list) {
            result += f.apply(dog);
        }
        return result / list.size();
    }
}
