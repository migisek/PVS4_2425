package recap.OOP;

public class Ucitel extends Osoba {
    private String predmet;
    public Ucitel(String jmeno, String predmet) {
        super(jmeno);
        this.predmet = predmet;
    } public void Uc(){
        System.out.println(jmeno + " učí " + predmet);
    }
}

