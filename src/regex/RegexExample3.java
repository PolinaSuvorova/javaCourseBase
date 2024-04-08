package regex;

import java.util.regex.Pattern;

public class RegexExample3 {
    public static void main(String[] args) {
        // 0-255.0-255.0-255.0-255
    String ip = "126.26.126.122";
    String regex = "(25(0-5)|2(0-4)\\d|[01]?\\d?\\d(\\.)){3}(25(0-5)|2(0-4)\\d|[01]?\\d?\\d)";
    boolean b = Pattern.matches(regex, ip);
        System.out.println(b);
    }

}
