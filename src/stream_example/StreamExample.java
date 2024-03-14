package stream_example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// все методы стрим не меняют своей исходной коллекции
public class StreamExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("privet");
        list.add("test1");
        list.add("test2");

        for (int i = 0; i < list.size(); i++) {
            list.set(i, String.valueOf(list.get(i).length()));
        }
        System.out.println(list);

        // list превращаем в стрим, через меп элемнет списка превращаем в стрим
        // новых знаений 6 9 2 4
        List<Integer> list2 = list.stream()
                .map(element -> element.length())
                .collect(Collectors.toList());

        System.out.println(list2);

        int[] array = {3, 5, 9, 10, 11};
        // 3 5 3 10 11
        array = Arrays.stream(array)
                .map(
                        element -> {
                            if (element % 3 == 0) {
                                element = 3;
                            }
                            return element;
                        })
                .toArray();
        System.out.println(Arrays.toString(array));

        Set<String> treeSet = new TreeSet<>();
        treeSet.add("privet");
        treeSet.add("test1");
        treeSet.add("test2");

        System.out.println(treeSet);
        // Ставит в соответствие значения одного списка другому
        Set<Integer> set2 = treeSet.stream().map(e -> e.length()).collect(Collectors.toSet());
        System.out.println(set2);

        Pet dog1 = new Pet("Sharik", 3, 1);
        Pet dog2 = new Pet("Tuzik", 4, 1);
        Pet dog3 = new Pet("Garry", 3, 2);
        Pet dog4 = new Pet("Joni", 14, 3);
        Pet dog5 = new Pet("Djeck", 11, 1);
        List<Pet> dogs = new ArrayList<>();
        dogs.add(dog1);
        dogs.add(dog2);
        dogs.add(dog3);
        dogs.add(dog4);
        dogs.add(dog5);
        // Фильтр также возврашает стрим
        List<Pet> pet2 = dogs.stream()
                .filter(el -> el.getAge() < 3 && el.getCourse() == 1)
                .toList();

        // ForEach возвращает Void
        int[] arrayForEach = {10, 12, 33, 55, 66};
        Arrays.stream(arrayForEach)
                .forEach(el -> {
                    el *= 2;
                    System.out.println(el);
                });

        // краткая запись вызова метода
        Arrays.stream(arrayForEach)
                .forEach(Utils::myMethod);

        Stream<Pet> myStream = Stream.of(dog1, dog2, dog3);
        List<Pet> pets = myStream.toList();

        // REDUCE Уменьшение до 1 элемена
        int result = list2.stream()
                .reduce((accumulator, element) -> accumulator * element)
                .get();
        System.out.println(result);

        int result2 = list2.stream()
                .reduce(1, (accumulator, element) -> accumulator * element);
        System.out.println(result2);

        List<Integer> list100 = new ArrayList<>();
        Optional<Integer> result100 = list100.stream()
                .reduce((accumulator, element) -> accumulator * element);
        if (result100.isPresent()) {
            System.out.println(result100.get());
        }

        List<String> listStr = new ArrayList<>(list);

        String resultStr = list.stream().reduce((a, e) -> a + " " + e).get();
        System.out.println(resultStr);

        // SORT сотировка
        int[] arrayUnSort = {3, 8, 1, 5, 9, 12, 11};
        int[] arraySorted = Arrays.stream(arrayUnSort).toArray();
        System.out.println(Arrays.toString(arraySorted));

        List<Pet> dogsSort = dogs.stream().sorted(Comparator.comparing(Pet::getAge)).toList();
        System.out.println(dogs);

        // метод CHAINING вызов нескольких методов

        int[] arrayChaining = {3, 8, 1, 5, 9, 12, 11, 4, 2};
        int resultChaining = Arrays.stream(arrayChaining)
                .filter(e -> e % 2 == 1)
                .map(e -> {
                    int olde = e;
                    if (e % 3 == 0) {
                        e /= 3;
                    }
                    System.out.println(olde + " -->" + e);
                    return e;
                })
                .reduce((a, e) -> a + e)
                .getAsInt();
        System.out.println("resultChaining " + resultChaining);

        // Промежуточные методы обрабатывают стримы
        // терминальные методы запускают исполнение промежуточных методов
        List<Pet> petChain = dogs.stream()
                .filter(e -> e.getCourse() <= 2)
                .peek(e -> e.setName(e.getName().toLowerCase()))
                .sorted(Comparator.comparing(Pet::getAge))
                .toList();
        System.out.println("dogsChaining " + petChain);

        // Метод соедниения стримов
        Stream<Integer> stream1 = Stream.of(3, 8, 1, 1, 9, 12, 11, 4, 2);
        Stream<Integer> stream2 = Stream.of(0, 8, 9, 6);
        Stream<Integer> streamConcat = Stream.concat(stream1, stream2);

        // Уникальные значения, обрабатываются по иквелс
        Stream<Integer> stream5 = Stream.of(1, 1, 1, 1, 9, 12, 11, 4, 2);
        //stream5.distinct().forEach(System.out::println);

        //  Long count1 = stream5.count(); // стримы нельзя переиспользовать
        Long count = stream5.distinct().peek(System.out::println).count();
        System.out.println(" count " + count);

        HouseForPet h1 = new HouseForPet("House1");
        HouseForPet h2 = new HouseForPet("House2");
        h1.addPet(dog1);
        h1.addPet(dog2);
        h1.addPet(dog3);
        h2.addPet(dog1);
        h2.addPet(dog4);
        h2.addPet(dog5);

        List<HouseForPet> houses = new ArrayList<>();
        houses.add(h1);
        houses.add(h2);


        // FLATMAP
        List<Pet> dogFilter = houses.stream()
                .flatMap(h -> h.getPets()
                        .stream()
                        .filter(p -> p.getAge() < 20))
                .peek(System.out::println)
                .toList();

        // Группировка по
       Map<Integer,List<Pet>> mapDogsCourse = dogs.stream()
                .peek(p-> p.setName(p.getName().toUpperCase()))
                .collect(Collectors.groupingBy(Pet::getCourse));
        System.out.println(mapDogsCourse);

        //Разделение по
        Map<Boolean,List<Pet>> mapDogsCourse2 = dogs.stream()
                .peek(p-> p.setName(p.getName().toUpperCase()))
                .collect(Collectors.partitioningBy(p->p.getCourse() >=3));
        System.out.println(mapDogsCourse2);

        //Возврат первого элмента стрима

        Pet petFirst = dogs.stream()
                .filter(e -> e.getCourse() <= 2)
                .sorted(Comparator.comparing(Pet::getAge))
                .findFirst()
                .get();
        System.out.println("dogsChaining " + petFirst);

        Pet petMin = dogs.stream()
                .min(Comparator.comparing(Pet::getAge))
                .get();
        System.out.println("dogsMin " + petMin);

        // Limit оставляет первые н элментов стрима
        List<Pet> petLimit= dogs.stream()
                .filter(e -> e.getCourse() <= 2)
                .sorted(Comparator.comparing(Pet::getAge))
                .limit(2)
                .toList();

       // Пропускает первые стоп элемнтов
        List<Pet> petSkip= dogs.stream()
                .filter(e -> e.getCourse() <= 2)
                .sorted(Comparator.comparing(Pet::getAge))
                .skip(1)
                .toList();

        // Список целочисленных значений из списка объектов
        List<Integer> ages = dogs.stream()
                .mapToInt(Pet::getAge)
                .boxed() // конвертирует int в Integer
                .toList();

        // метод суммирования
        int sum = dogs.stream().mapToInt(e1->e1.getCourse()).sum();

        //среднеарефмитическое
        double sumAvg = dogs.stream().mapToInt(Pet::getAge).average().getAsDouble();

        int min = dogs.stream().mapToInt(Pet::getAge).min().getAsInt();
    }
}

class Utils {
    public static void myMethod(int a) {
        a += 5;
        System.out.println(a);
    }
}

class HouseForPet {
    private String name;
    private List<Pet> pets;

    public HouseForPet(String name) {
        this.name = name;
        pets = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void addPet(Pet pet) {
        pets.add(pet);
    }
}

class Pet {
    private String name;
    private Integer age;
    private Integer course;

    public Pet(String name, Integer age, Integer course) {
        this.name = name;
        this.age = age;
        this.course = course;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getCourse() {
        return course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pet dog = (Pet) o;

        if (getName() != null ? !getName().equals(dog.getName()) : dog.getName() != null) return false;
        return getAge() != null ? getAge().equals(dog.getAge()) : dog.getAge() == null;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", course=" + course +
                '}';
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getAge() != null ? getAge().hashCode() : 0);
        return result;
    }
}



