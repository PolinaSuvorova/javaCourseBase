package lambda;

public class Dog {
    private String name;
    private Character sex;
    private Integer age;
    private Integer schoolLevel;

    public Dog(String name, Character sex, Integer age, Integer schoolLevel) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.schoolLevel = schoolLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Character getSex() {
        return sex;
    }

    public void setSex(Character sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSchoolLevel() {
        return schoolLevel;
    }

    public void setSchoolLevel(Integer schoolLevel) {
        this.schoolLevel = schoolLevel;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", schoolLevel=" + schoolLevel +
                '}';
    }
}
