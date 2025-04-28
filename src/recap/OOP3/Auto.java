package recap.OOP3;

public class Auto extends Vozidlo implements Pojizdne {


    public Auto(String znacka, int rychlost) {
        super(znacka, rychlost);
    }

    @Override
    public void jezdi() {
        System.out.println("Auto značky " + znacka + " jede po silnici");
    }
}
