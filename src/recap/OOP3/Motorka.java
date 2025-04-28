package recap.OOP3;

public class Motorka extends Vozidlo implements Pojizdne {
    public Motorka(String znacka, int rychlost) {
        super(znacka, rychlost);
    }

    @Override
    public void jezdi() {
        System.out.println("Motorka znacky: " + znacka + " sviští po dálnici");
    }
}
