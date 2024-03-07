package collection;

import java.util.Stack;
import java.util.Vector;

// класс вектор и его наследник стек устаревший и предназначен для синхронизации изменений в разных потоках
// похожи на ArrayList
// Stack использует принциа LIFO.
// Если нужно использование в многопоточности, то используем другие коллекции
public class VectorStackExample {
    static void abc1() {
        System.out.println("   abc1 starts");
        System.out.println("   abc1 ends");
    }

    static void abc2() {
        System.out.println("  abc2 starts");
        abc1();
        System.out.println("  abc2 ends");
    }

    static void abc3() {
        System.out.println(" abc3 starts");
        abc2();
        System.out.println(" abc3 ends");
    }

    public static void main(String[] args) {
        Vector<String> vector = new Vector<>();
        vector.add("Aa");
        vector.add("Bb");
        vector.add("Cc");
        vector.add("Dd");
        System.out.println(vector);
        System.out.println(vector.firstElement());
        System.out.println(vector.lastElement());
        vector.remove(2);

        // Пример LIFO
        System.out.println("main starts");
        abc3();
        System.out.println("main ends");

        Stack<String> stack = new Stack<>();
        stack.push("A");
        stack.push("B");
        stack.push("C");

        System.out.println(stack);
        while (!stack.isEmpty()) {
            System.out.println(stack.peek());
            //System.out.println(stack.pop());// выбрали и удалили последний элемент
        }

    }
}
