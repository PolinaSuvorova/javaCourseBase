package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample2 {
    public static void main(String[] args) {
        String s = "ABCD7DBCE ABCF ABCG ABCH";

        // abc - соответсвует подстроке в строке
        search(s, "ABC");
        // [abc] - или а или b или c
        search(s, "[ABC]");
        // [a-c3-8A-C] - диапазоны (или а или b или c ) и (3 или 5... или 8) и (A или B или С)
        search(s, "A[A-C]A");

        s = "55ABCD7DBCE ABC45555№ ABCG! ABCH";

        // (a|b) - или а или b
        search(s, "ABC(D|C)");
        //  . - соответсвует любому символу
        search(s, "ABC.");
        //  ^ - начало строки
        search(s, "^5ABC");
        // $ - коенц строки
        search(s, "BCH$");

        //  \d - цифра
        search(s, "\\d");
        //  \D - не цифра
        search(s, "\\D");

        // \w - цифра или буква или _
        search(s, "\\w");
        // \W - не (цифра или буква или _ )
        search(s, "\\W");

        // + - один или более символ из шаблона
        search(s, "\\w+");
        // {n} - количество повторений
        search(s, "\\w{4}");

        // \\s - пробелы == [\t\n\r\f] - табуляция, переход на новую строку, раздел страницу
        search(s, "\\w\\s+\\w");
        // \\s - пробелы == [\t\n\r\f] - табуляция, переход на новую строку, раздел страницу
        // {2,6} - от 2 до 6 символов {2,} - от 2 до бесконености
        search(s, "\\D{2,6}");

        // подстроки (AB) повторение от 2 до 6 раз
        s = "DABAB FFABDA";
        search(s, "(AB){2,6}");

        // ? - 0 или 1 повторение
        // * - 0 или несколко повторений
        search(s, "D(AB)?");

        // \A - начало стринга
        // \Z - конец стринга
        search(s, "\\ADAB");
        search(s, "BDA\\Z");
    }

    public static void search(String s, String p) {
        Pattern pattern1 = Pattern.compile(p);
        Matcher matcher = pattern1.matcher(s);
        System.out.println("-----Pattern search " + p );
        while (matcher.find()) {
            System.out.println("position " + matcher.start() + " substring " + matcher.group());
        }
    }
}