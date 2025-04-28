package recap;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ExportQuit {
    public static void main(String[] args) throws IOException {
        String path = "export.txt";
        ArrayList<Osoba> osoby = new ArrayList<Osoba>();
        BufferedWriter bw = new BufferedWriter(new FileWriter(path, true));
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("Zadej jméno - pokud už nechceš zadávat, napiš 'quit'");
            String jmeno = sc.nextLine();
            if (jmeno.equals("quit")) {
                System.out.println("Konec");
                break;
            }
            System.out.println("Zadej skóre v testu žáka: " + jmeno);
            int score = Integer.parseInt(sc.nextLine());
            osoby.add(new Osoba(jmeno, score));
            bw.write(jmeno + "," + score);
            bw.newLine();
        } bw.close();
        File file = new File(path);
        if(file.exists()) {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                String[] split = line.split(",");
                String jmeno = split[0];
                int score = Integer.parseInt(split[1]);
                osoby.add(new Osoba(jmeno, score));
            } br.close();
        }


        osoby.sort((o1, o2) -> o2.getScore() - o1.getScore());
        for(Osoba osoba : osoby) {
            System.out.println(osoba.getJmeno() + "," + osoba.getScore());
        }

    }
    static class Osoba {
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
