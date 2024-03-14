package nested_classes.static_nested;

// Статический класс можем использовать как обычный внешний класс Car.Engine
// физически находится внутри другого класса
class Car {
    String color;
    Integer doorCount;
    Engine engine;
    private static int a;

    public Car(String color, Integer doorCount, Engine engine) {
        this.color = color;
        this.doorCount = doorCount;
        this.engine = engine;
    }

    public void method() {
        Engine e = new Engine(200);
        System.out.println(e.horsePower);
    }


    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", doorCount=" + doorCount +
                ", engine=" + engine +
                "} count obj " + Engine.countObj;
    }

    public static class Engine {
        private int horsePower;
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
        Car car = new Car("Red", 4, new Car.Engine(500));
        System.out.println(car);
    }
}
