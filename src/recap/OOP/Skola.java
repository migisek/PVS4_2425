package recap.OOP;

public class Skola {
    public static void main(String[] args) {
    Zak zak1 = new Zak("Jan","4F");
    Ucitel ucitel1 = new Ucitel("Jan","Matematika");

    zak1.Studuj();
    zak1.Predstavse();

    ucitel1.Uc();
    ucitel1.Predstavse();
    }
}
