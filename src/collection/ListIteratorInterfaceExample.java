package collection;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

// Проверка полиндрома с использованием интерфейса ListIterator
public class ListIteratorInterfaceExample {
    public static void main(String[] args) {

        String s = "madam";
        List<Character> list = new LinkedList<>();
        for (char ch : s.toCharArray()) {
            list.add(ch);
        }
        ListIterator<Character> liLeft = list.listIterator();
        ListIterator<Character> liRight = list.listIterator(list.size());

        boolean isPalindrom = true;

        while (liLeft.hasNext() && liRight.hasPrevious()) {
            if (liLeft.next() != liRight.previous()) {
                isPalindrom = false;
                break;
            }
        }
        System.out.println("word " + s + " is " + isPalindrom);
    }
}
