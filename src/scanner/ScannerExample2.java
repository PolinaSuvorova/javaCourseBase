package scanner;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class ScannerExample2 {
    public static void main(String[] args) {
        Scanner scanner = null;
        Set<String> set = new TreeSet<>();
        try {
            scanner = new Scanner( new FileReader("C:\\Users\\ptatara\\Desktop\\test1.txt"));
            scanner.useDelimiter("\\W"); // любой символ не буква и не цифра
            while (scanner.hasNext()){
                String word = scanner.next();
                set.add(word);
            }
            for ( String word : set){
                System.out.println(word);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);

        }finally{
            assert scanner != null;
            scanner.close();
        }
    }
}
