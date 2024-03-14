package nested_classes.local_inner_class;

// Локал иннер классы располаггаются внутри кода, не мгут быть статик
// видны только там где объявлены
// могут обращаться к прайват переменнами внешнего класса
// может обращаться к переменным блока если она финал или эфиктивал финал (переменные не должны менять значение)
public class LocalInner {
    public static void main(String[] args) {
        Math1 math1 = new Math1();
        math1.getResult();
    }
}

class Math1 {
    public void getResult() {
        class Delenie {
            private int delimoe;
            private int delitel;

            public void setDelimoe(int delimoe) {
                this.delimoe = delimoe;
            }

            public void setDelitel(int delitel) {
                this.delitel = delitel;
            }

            public int getChastnoe() {
                return delimoe / delitel;
            }
        }
        Delenie delenie = new Delenie();
        delenie.setDelimoe(1);
        delenie.setDelitel(1);
        System.out.println(delenie.getChastnoe());
    }
}