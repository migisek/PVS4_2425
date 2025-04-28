package recap.OOP3;

import java.util.ArrayList;

public class Vozidlo {
    String znacka;
    int rychlost;

    public Vozidlo(String znacka, int rychlost) {
        this.znacka = znacka;
        this.rychlost = rychlost;
    }

    public String getZnacka() {
        return znacka;
    }

    public int getRychlost() {
        return rychlost;
    }

    public void VypisInfo(){
        System.out.println("vozidlo znacky: " + znacka + "jede rychlostí: " + rychlost + " km/h.");
    }

    public static void main(String[] args) {
        ArrayList<Vozidlo> vozidlo = new ArrayList<Vozidlo>();
        Auto auto = new Auto("BMW", 230);
        Auto auto2 = new Auto("Mercedes", 240);
        Motorka motorka = new Motorka("Yamaha",100);
        Motorka motorka2 = new Motorka("Kawasaki",200);


        vozidlo.add(motorka);
        vozidlo.add(motorka2);
        vozidlo.add(auto2);
        vozidlo.add(auto);
        vozidlo.sort(((o1, o2) -> o2.getRychlost() - o1.getRychlost()));
        for(Vozidlo voz : vozidlo) {
            System.out.println(voz.getZnacka() + "," + voz.getRychlost());
        }

        motorka.VypisInfo();
        motorka.jezdi();

        auto.VypisInfo();
        auto.jezdi();
    }
}
