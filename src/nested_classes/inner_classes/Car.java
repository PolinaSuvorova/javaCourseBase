package nested_classes.inner_classes;

// inner класс всегда зависим от внешнего класса
// отдельно создать иннер класс нельзя
public class Car {
    String color;
    Integer doorCount;
    Car.Engine engine;
    private static int a;

    public Car(String color, Integer doorCount, Integer horsePower) {
        this.color = color;
        this.doorCount = doorCount;
        this.engine = this.new Engine(horsePower);
    }

    public void method() {
        Car.Engine e = new Car.Engine(200);
        System.out.println(e.horsePower);
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", doorCount=" + doorCount +
                ", engine=" + engine +
                "} " + Engine.countObj;
    }

    public class Engine {
        private final int horsePower;
        static int countObj;

        public Engine(int horsePower) {
            System.out.println(a);
            //  System.out.println(doorCount); не доступны не статичные элементы
            this.horsePower = horsePower;
            countObj += 1;
        }

        @Override
        public String toString() {
            return "engine{" +
                    "horsePower=" + horsePower +
                    '}';
        }
    }
}

class TestCar {
    public static void main(String[] args) {
        Car car = new Car("Red", 4, 300);
        System.out.println(car);
    }
}

