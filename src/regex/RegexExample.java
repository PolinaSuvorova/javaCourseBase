package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample {
    public static void main(String[] args) {
        String s =
                "Ivanov Ivan, Russia, Moscow, Lenin Street, 51, Flat 78, " +
                        "email: ivano@gmail.com, Postcode: AA123, PhoneNumber: +7888888888;" +
                        "Petrov Petr, Russia, Moscow, Osennia Street, 18, Flat 567, " +
                        "email: petrov@gmail.com, Postcode: 121654, PhoneNumber: +7888588877;" +
                        "Sidorov Sidr, Russia, Moscow, Vesennia Street, 20, Flat 234, " +
                        "email: sidorov@gmail.com, Postcode: 521654, PhoneNumber: +7926588877";

        search(s,"\\w+");
        // \b - граница слова (ни числа ни буквы)
        search(s,"\\b\\d{2}\\b");
        //Телефоны
        search(s,"\\+\\d{10}");
        //email
        search(s,"\\w+@\\w+\\.(ru|com)");
    }

    public static void search(String s, String p) {
        Pattern pattern1 = Pattern.compile(p);
        Matcher matcher = pattern1.matcher(s);
        System.out.println("-----Pattern search " + p );
        while (matcher.find()) {
            System.out.println("substring " + matcher.group());
        }
    }
}
