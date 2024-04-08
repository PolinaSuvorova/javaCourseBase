package reflection_wxaple;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CallMethodsFromFile {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("testCalc.txt"))) {
            String strMethod = bufferedReader.readLine();
            String strA = bufferedReader.readLine();
            String strB = bufferedReader.readLine();
            Calculator calc = new Calculator();
            Class employeeClass3 = calc.getClass();
            for ( Method method: employeeClass3.getDeclaredMethods() ) {
                if(method.getName().equals(strMethod)){
                    method.invoke(calc,Integer.parseInt(strA),Integer.parseInt(strB));
                }
            }
        } catch (IOException |
                 InvocationTargetException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
    class Calculator {
        public void sum(int a, int b) {
            int c = a + b;
            System.out.println(a + " + " + b + " = " + c);
        }

        public void sub(int a, int b) {
            int c = a - b;
            System.out.println(a + " - " + b + " = " + c);
        }

        public void div(int a, int b) {
            int c = a / b;
            System.out.println(a + " / " + b + " = " + c);
        }

        public void pro(int a, int b) {
            int c = a * b;
            System.out.println(a + " * " + b + " = " + c);
        }
    }
