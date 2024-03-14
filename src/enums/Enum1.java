package enums;

import java.util.Arrays;

public class Enum1 {
    public static void main(String[] args) {
        Today today = new Today(WeekDays.MONDAY);
        today.dayInfo();
        WeekDays w1 = WeekDays.MONDAY;
        WeekDays w2 = WeekDays.MONDAY;
        WeekDays w3 = WeekDays.FRIDAY;
        System.out.println(w1 == w2);
        System.out.println(WeekDays.FRIDAY.equals(WeekDays2.FRIDAY));
        WeekDays w15 = WeekDays.valueOf("MONDAY");
        System.out.println(w15);

        WeekDays[] array = WeekDays.values();
        System.out.println(Arrays.toString(array));
    }

}

enum WeekDays {
    MONDAY("1 - понедельник"),
    TUESDAY("2 - dnjhybr"),
    WEDNESDAY("3 - среда"),
    THURSDAY("4 - четверг"),
    FRIDAY("5 - пятница"),
    SATURDAY("6 - суббота"),
    SUNDAY("7 - воскресенье");

    private final String name;

    private WeekDays(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}

enum WeekDays2 {
    MONDAY("1 - понедельник"),
    TUESDAY("2 - dnjhybr"),
    WEDNESDAY("3 - среда"),
    THURSDAY("4 - четверг"),
    FRIDAY("5 - пятница"),
    SATURDAY("6 - суббота"),
    SUNDAY("7 - воскресенье");

    private final String name;

    private WeekDays2(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}

class Today {
    WeekDays weekDay;

    public Today(WeekDays wd) {
        this.weekDay = wd;
    }

    void dayInfo() {
        switch (weekDay) {
            case MONDAY, FRIDAY, SUNDAY, TUESDAY, SATURDAY, THURSDAY, WEDNESDAY ->
                    System.out.println(weekDay.getName() + " is weekday");
        }
    }
}
