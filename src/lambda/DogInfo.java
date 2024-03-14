package lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class DogInfo {
    void testDogs(List<Dog> a1, DogChecks dch) {
        for (Dog d : a1) {
            if (dch.check(d)) {
                System.out.println(d);
            }
        }
    }

    void testDogsPredicate(List<Dog> a1, Predicate<Dog> predicate) {
        for (Dog d : a1) {
            if (predicate.test(d)) {
                System.out.println(d);
            }
        }
    }

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

        Collections.sort(dogs, new Comparator<Dog>() {
            @Override
            public int compare(Dog o1, Dog o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        Collections.sort(dogs, (dog1, dog2) -> dog1.getAge() - dog2.getAge());
        DogInfo di = new DogInfo();
        // реализация во внешнем классе
        di.testDogs(dogs, new CheckOverGrade());
        // реализация в анонимном классе
        di.testDogs(dogs, new DogChecks() {
            @Override
            public boolean check(Dog d) {
                return d.getAge() < 3;
            }
        });

        di.printDogsMixCondition(dogs, 4, 5);
        di.printDogsUnderAge(dogs, 6);

        // Лямбда выражение
        di.testDogs(dogs, d -> {
            boolean a = d.getAge() < 3;
            return a;
        });
        di.testDogs(dogs, d -> d.getSchoolLevel() < 8);
        DogChecks dogChecksLambda = (d -> d.getSchoolLevel() < 8);
        di.testDogs(dogs, dogChecksLambda);

        // Лямбда выражение в вызывающем методе без функционального класса
        di.testDogsPredicate(dogs, d -> {
            boolean a = d.getAge() < 3;
            return a;
        });
        di.testDogsPredicate(dogs, d -> d.getSchoolLevel() < 8);

        // Объединение проверок через Predicate.or() Predicate.and() Predicate.negate()
        Predicate<Dog> p1 = dog -> dog.getAge() > 2;
        Predicate<Dog> p2 = dog -> dog.getAge() < 14;
        Predicate<Dog> np3 = dog -> dog.getAge() == 0;
        di.testDogsPredicate(dogs, p1.and(p2.and(np3.negate())));
    }

    void printDogsUnderAge(List<Dog> list, int age) {
        for (Dog d : list) {
            if (d.getAge() > age) {
                System.out.println(d);
            }
        }
    }

    void printDogsMixCondition(List<Dog> list, int grade, int age) {
        for (Dog d : list) {
            if (d.getSchoolLevel() < grade && d.getAge() > age) {
                System.out.println(d);
            }
        }
    }

    void printDogsOverGrade(List<Dog> list, int grade) {
        for (Dog d : list) {
            if (d.getSchoolLevel() < grade) {
                System.out.println(d);
            }
        }
    }
}

interface DogChecks {
    boolean check(Dog d);
}

class CheckOverGrade implements DogChecks {

    @Override
    public boolean check(Dog d) {
        return d.getSchoolLevel() > 8;
    }
}