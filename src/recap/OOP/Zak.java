package recap.OOP;

public class Zak extends Osoba implements Studujici {
    private String trida;
    public Zak(String jmeno, String trida) {
        super(jmeno);
        this.trida = trida;
    }

    @Override
    public void Studuj() {
        System.out.println(jmeno + " " + trida);
    }
}

