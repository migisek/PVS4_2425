package recap.OOP2;

public class Kocka extends Zvire implements Mluvi {
    public Kocka(String jmeno) {
        super(jmeno);
    }

    @Override
    public void Mluv() {
        System.out.println("Mňau");
    }
}

