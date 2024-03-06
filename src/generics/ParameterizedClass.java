package generics;

public class ParameterizedClass {
    public static void main(String[] args) {
        Info<String> infoString = new Info<>("Privet");
        System.out.println(infoString);
        String s1 = infoString.getValue();

        Info<Integer> infoInteger = new Info<>(222);
        System.out.println(infoInteger);
        Integer s2 = infoInteger.getValue();

        System.out.println("--------------------------------");
        Pair<String,Integer> pair = new Pair<>("Test",1);
        System.out.println(pair.getValue1() + "  " + pair.getValue2());

        Pair<Integer,Integer> pair2 = new Pair<>(2,1);
        System.out.println(pair2.getValue1() + "  " + pair2.getValue2());

        System.out.println("--------------------------------");
        OtherPair<Integer> pair3 = new OtherPair<>(2,1);
        System.out.println(pair3.getValue1() + "  " + pair3.getValue2());

        System.out.println("--------------------------------");
        InfoNumber<Integer> integerInfoNumber = new InfoNumber<>(222);
        System.out.println(integerInfoNumber);
        Integer s4 = integerInfoNumber.getValue();

        InfoNumber<Double> doubleInfoNumber = new InfoNumber<>(3.14);
        System.out.println(doubleInfoNumber);
        Double s5 = doubleInfoNumber.getValue();
    }
}

class Info<T> {
    private T value;

    public Info(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "[{" + value + "}]";
    }

    public T getValue() {
        return value;
    }
}
class InfoNumber<T extends Number> {
    private T value;

    public InfoNumber(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "[{" + value + "}]";
    }

    public T getValue() {
        return value;
    }
}

class InfoNumberWithInterface<T extends Number&I1&I2> {
    private T value;

    public InfoNumberWithInterface(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "[{" + value + "}]";
    }

    public T getValue() {
        return value;
    }
}
interface I1{}
interface I2{}
class Pair<V1,V2>{
    private V1 value1;
    private V2 value2;

    public Pair(V1 value1, V2 value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public V1 getValue1() {
        return value1;
    }

    public V2 getValue2() {
        return value2;
    }
}

class OtherPair<V>{
    private V value1;
    private V value2;

    public OtherPair(V value1, V value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public V getValue1() {
        return value1;
    }

    public V getValue2() {
        return value2;
    }
}


