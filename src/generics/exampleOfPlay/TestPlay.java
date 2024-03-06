package generics.exampleOfPlay;

public class TestPlay {
    public static void main(String[] args) {
        Team<Schoolar> teamSchoolar = new Team<>("TeamSchoolar");
        teamSchoolar.addParticipant(new Schoolar("Petr Ivanovich", 99));
        teamSchoolar.addParticipant(new Schoolar("Petr Schoolar", 10));

        Team<Schoolar> teamSchoolar2 = new Team<>("TeamSchoolar2");
        teamSchoolar2.addParticipant(new Schoolar("Petr2 Ivanovich", 99));
        teamSchoolar2.addParticipant(new Schoolar("Petr2 Schoolar", 10));

        teamSchoolar.playWith(teamSchoolar2);

        Team<Student> teamStudent = new Team<>("TeamStudent");
        teamStudent.addParticipant(new Student("Petr Ivanovich", 19));
        teamStudent.addParticipant(new Student("Petr Student", 29));
        Team<Student> teamStudent2 = new Team<>("TeamStudent2");
        teamStudent2.addParticipant(new Student("Petr Ivanovich", 19));
        teamStudent2.addParticipant(new Student("Petr Student", 29));

        teamStudent2.playWith(teamStudent2);

        Team<Employee> teamEmployee = new Team<>("TeamEmployee");
        teamEmployee.addParticipant(new Employee("Sofia Espinal", 19));
        teamEmployee.addParticipant(new Employee("Sofia El Eter", 29));
    }
}
