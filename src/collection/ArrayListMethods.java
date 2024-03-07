package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListMethods {
    public static void main(String[] args) {
        StringBuilder sb1 = new StringBuilder("A");
        StringBuilder sb2 = new StringBuilder("B");
        StringBuilder sb3 = new StringBuilder("C");
        StringBuilder sb4 = new StringBuilder("D");
        StringBuilder[] array = {sb1,sb2,sb3,sb4};
        List<StringBuilder> list = Arrays.asList(array);
        // Длина list всегда будет такой же как у массива. Меняя массив мы меняем и лист
        array[0].append("FFF");
        System.out.println(list);

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Test1");
        arrayList.add("Test2");
        arrayList.add("Test3");
        arrayList.add("Test3");
        arrayList.add("Test4");
        System.out.println(arrayList);

        // Ракурс от arrayList не существует отдельно от arrayList. Является его представлением

        List<String> myList = arrayList.subList(0,4);// 0,1,2,3 - элемент
        System.out.println(myList);
        myList.add("Fedor"); // добавится в arrayList также 4
        System.out.println(arrayList);

        Object[] arrayObject = arrayList.toArray();
        String[] arrayString = arrayList.toArray(new String[0]);

        // Создание через List.of List.copyOf статичных листов(изменять нельзя) не могут содеожать элементы null
        List<Integer> listStatic = List.of(3,8,13);
        System.out.println(listStatic);
        //listStatic.add(100); этот Лист изменять нельзя
        List<String> listStaticStr = List.copyOf(arrayList);// не могу содержать значения null

//        List<String> arrayList2 = new ArrayList<>();
//        arrayList2.add("Test1");
//        arrayList2.add("Test5");

        //Удаляем все элементы arrayList2 из arrayList
//        arrayList.removeAll(arrayList2);
//        System.out.println(arrayList);
        // Содержит ли все элементы arrayList2 из arrayList
//        boolean result = arrayList.containsAll(arrayList2);
//        System.out.println(result);



    }
}
