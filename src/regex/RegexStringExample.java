package regex;

import java.util.Arrays;

public class RegexStringExample {
    public static void main(String[] args) {
        String s =
                "Ivanov Ivan, Russia, Moscow, Lenin Street, 51, Flat 78, " +
                        "email: ivano@gmail.com, Postcode: AA123, PhoneNumber: +7888888888;" +
                        "Petrov Petr, Russia, Moscow, Osennia Street, 18, Flat 567, " +
                        "email: petrov@gmail.com, Postcode: 121654, PhoneNumber: +7888588877;" +
                        "Sidorov Sidr, Russia, Moscow, Vesennia Street, 20, Flat 234, " +
                        "email: sidorov@gmail.com, Postcode: 521654, PhoneNumber: +7926588877";

        String s2 = "sidorov@gmail.com";
        System.out.println( s2.matches("\\w+@\\w+\\.(com|ru)") );
        String[] subString = s.split(";");
        for (int i = 0; i < subString.length; i++) {
            System.out.println( subString[i] );
        }
        System.out.println( Arrays.toString(subString) );

    }
}
