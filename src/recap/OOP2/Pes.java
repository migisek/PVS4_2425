package recap.OOP2;

public class Pes extends Zvire implements Mluvi {
    String mluva = "Haf Haf!";
    public Pes(String jmeno) {
        super(jmeno);
    }

    @Override
    public void Mluv() {
        System.out.println(mluva);
    }
}
