package multithrading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

// Игра камень ножницы бумага
// Обмен информацией в один момент от разных потоков
// Двухсторонний обмен информацией
// Переиспользование объектов
// Может учавствовать только два потока, имеет ограниченый инструмент использования
public class ExchangerExample {
    public static void main(String[] args) {
     Exchanger<Action> exchanger = new Exchanger<>();
     List<Action> friend1Action = new ArrayList<>();
        friend1Action.add(Action.NOJNICI);
        friend1Action.add(Action.BUBAGA);
        friend1Action.add(Action.BUBAGA);

        List<Action> friend2Action = new ArrayList<>();
        friend2Action.add(Action.KAMEN);
        friend2Action.add(Action.KAMEN);
        friend2Action.add(Action.BUBAGA);

        new BestFriend("Friend1", exchanger, friend1Action);
        new BestFriend("Friend2", exchanger, friend2Action);

    }
}

enum Action {
    KAMEN, NOJNICI, BUBAGA;
}

class BestFriend extends Thread {
    private String name;
    private Exchanger<Action> exchanger;

    private List<Action> myActions;

    public BestFriend(String name, Exchanger<Action> exchanger, List<Action> myActions) {
        this.name = name;
        this.exchanger = exchanger;
        this.myActions = myActions;
        this.start();
    }

    @Override
    public void run() {
        Action reply;
        for ( Action action : myActions  ) {
            try {
                reply = exchanger.exchange(action);
                whoWins(action,reply);
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void whoWins(Action myAction, Action friendAction) {
        if ((myAction.equals(Action.NOJNICI) && friendAction.equals(Action.BUBAGA) ||
                (myAction.equals(Action.BUBAGA) && friendAction.equals(Action.KAMEN)) ||
                (myAction.equals(Action.KAMEN) && friendAction.equals(Action.NOJNICI)))) {
            System.out.println("Выиграл " + name);
        }else if ((myAction.equals(Action.NOJNICI) && friendAction.equals(Action.NOJNICI) ||
                (myAction.equals(Action.BUBAGA) && friendAction.equals(Action.BUBAGA)) ||
                (myAction.equals(Action.KAMEN) && friendAction.equals(Action.KAMEN)))) {
            System.out.println("Ничья");
        }
    }
}