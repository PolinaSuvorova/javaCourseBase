package generics.exampleOfPlay;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Team<T extends Participant> {
    private String name;
    private List<T> participantList = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addParticipant(T participant) {
        this.participantList.add(participant);
        System.out.println("Was added new participant " + participant.getName() + " to team " + name);
    }

    public void playWith(Team<T> team) {
        String winnerName;
        Random random = new Random();
        int i = random.nextInt(2);
        if (i == 0) {
            winnerName = this.name;
        } else {
            winnerName = team.getName();
        }

        System.out.println(" Winner is " + winnerName + " team");
    }

    ;

}
