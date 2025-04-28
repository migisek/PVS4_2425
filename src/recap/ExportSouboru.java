package recap;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ExportSouboru {
    public static void main(String[] args) throws IOException {
        ArrayList<Osoba> osoby = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String path = "data/exportation.txt";
        ArrayList<String> list = new ArrayList<String>();
        BufferedWriter bw = new BufferedWriter(new FileWriter(path,true));
        System.out.println("Kolik chceš přidat lidí?");
        int pocet = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < pocet; i++) {
            System.out.println("Zadej jméno");
            String jmeno = sc.nextLine();
            System.out.println("Zadej skore");
            int skore = Integer.parseInt(sc.nextLine());
            osoby.add(new Osoba(jmeno, skore));
        }
        System.out.println("Konec přidávání ");

        for(Osoba osoba : osoby) {
            bw.write(osoba.getJmeno() + "," + osoba.getScore());
            bw.newLine();

        }bw.close();

    }static class Osoba {
        private String jmeno;
        private int score;

        public Osoba(String jmeno, int score) {
            this.jmeno = jmeno;
            this.score = score;
        }

        public String getJmeno() {
            return jmeno;
        }

        public void setJmeno(String jmeno) {
            this.jmeno = jmeno;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }
    }
}
