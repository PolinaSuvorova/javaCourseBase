package lambda;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Supplier;

// Supplier Возвращает объект
// Consumer Принимает объект, чтобы изменить. Противоположен саплаеру
public class SupplierConsumerExample {
    public static void main(String[] args) {

        // Пример с саплаером
        ArrayList<Car> cars = createThreeCars(() -> new Car("Nissan", "silver", 1.6));
        System.out.println(cars);

        // Пример с консумер
        changeCar(cars.get(0), car -> {
            car.setColor("red");
            car.setEngine(1.9);
            System.out.println(car);
        });


    }

    public static void changeCar(Car car, Consumer<Car> carConsumer) {
        carConsumer.accept(car);
    }

    public static ArrayList<Car> createThreeCars(Supplier<Car> carSupplier) {
        ArrayList<Car> al = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            al.add(carSupplier.get());
        }
        return al;
    }
}

class Car {
    String model;
    String color;
    Double engine;

    public Car(String model, String color, Double engine) {
        this.model = model;
        this.color = color;
        this.engine = engine;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setEngine(Double engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", engine=" + engine +
                '}';
    }
}
