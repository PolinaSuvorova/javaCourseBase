package nested_classes;

// Используем когда вложенные классы тесто связаны с основным классом и без него нет смысла использовать
public class TestNestedClass {
    // Статичный вложенный класс (STATIC)
    static class A {
    }

    // Внутренний класс innerclass (INNER)
    class B {
    }

    //Локальный класс (класс в блоке кода)(LOCAL)
    void method() {
        class C {
        }
    }
    // Анонимные классы (ANONIMUS)

}
