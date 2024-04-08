package scanner;

import java.util.Scanner;

public class ScannerExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число: ");
        int i = scanner.nextInt();
        System.out.println("Ввели " + i);

        System.out.println("Введите 2 числа: ");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        System.out.println("Ввели x/y = " + x/y);

        System.out.println("Введите пару слов: ");
        String s = scanner.nextLine();
        String s2 = scanner.nextLine();
        System.out.println("Ввели " + s + "Ввели " + s2);
        String s3 = scanner.next();
        System.out.println("Ввели " + s3);

        Scanner scanner2 = new Scanner("Privet moi drug");
        while (scanner.hasNextLine()) {
            s = scanner.nextLine();
            System.out.println("Ввели " + s);
        }
    }
}
