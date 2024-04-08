package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample5 {
    public static void main(String[] args) {
        String s = "12345678912345670325967;12345678912345670325967;12345678912345670325967";
        System.out.println(s);
        // 03/25 1234 5678 9123 4567 (967)
        Pattern pattern = Pattern.compile("(\\d{4})(\\d{4})(\\d{4})(\\d{4})(\\d{2})(\\d{2})(\\d{3})");
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()){
            System.out.println(matcher.group());
        }
        String myNewString = matcher.replaceAll("$5/$6 $1 $2 $3 $4 ($7)");
        System.out.println(myNewString);

    }
}
