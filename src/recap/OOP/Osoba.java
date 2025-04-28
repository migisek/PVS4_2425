package recap.OOP;

public class Osoba {
    protected String jmeno;

    public Osoba(String jmeno) {
        this.jmeno = jmeno;
    }
    public void Predstavse(){
        System.out.println("Jsem "+ jmeno);
    }
}
