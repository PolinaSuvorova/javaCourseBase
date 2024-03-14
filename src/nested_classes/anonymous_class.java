package nested_classes;

public class anonymous_class {
    public static void main(String[] args) {
        Math2 math2 = new Math2() {
            @Override
            public int doOperation(int a, int b) {
                return a + b;
            }
        };
        System.out.println(math2.doOperation(1, 2));
    }
}

interface Math2 {
    int doOperation(int a, int b);
}
