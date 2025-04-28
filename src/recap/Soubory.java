package recap;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Soubory {
    public static void main(String[] args) throws IOException {
        Parsing();
    } public static void nactiText(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;
        while((line = br.readLine()) != null)
            System.out.println(line);
        br.close();
    }  public static void napisText(String path) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(path,true));

        bw.write("ahoj svete");
        bw.newLine();
        bw.close();


    } public static void Parsing() throws IOException {
        Scanner sc = new Scanner(System.in);

        ArrayList<Osoba> osoby = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("data/soubor"));
        String line;
        while ((line = br.readLine()) != null){
            String[] casti = line.split(";");
            String jmeno = casti[0];
            int vek = Integer.parseInt(casti[1]);

            osoby.add(new Osoba(jmeno,vek));
            System.out.println(jmeno + ": " + vek);
            } br.close();
        BufferedWriter bw = new BufferedWriter(new FileWriter("data/export.txt"));
        for (Osoba osoba : osoby) {
            bw.write(osoba.getJmeno() + ";" + osoba.getVek());
            bw.newLine();
        } bw.close();
        }
        static class Osoba{
            private String jmeno;
            private int vek;

            public Osoba(String jmeno, int vek) {
                this.jmeno = jmeno;
                this.vek = vek;
            }

            public String getJmeno() {
                return jmeno;
            }

            public void setJmeno(String jmeno) {
                this.jmeno = jmeno;
            }

            public int getVek() {
                return vek;
            }

            public void setVek(int vek) {
                this.vek = vek;
            }

            @Override
            public String toString() {
                return jmeno + " " + vek;
            }
    }

}

