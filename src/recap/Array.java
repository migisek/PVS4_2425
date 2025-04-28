package recap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Array{
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("cauky");
        list.add("mnau");
        list.remove("mnau");
        for(String polozka : list) System.out.println(polozka);
        System.out.println("Počet v listu:" + list.size());

        HashSet<String> list2 = new HashSet<String>();
        list2.add("set");
        list2.add("six");

        HashMap<String, String> telefonniSeznam = new HashMap<>();
        telefonniSeznam.put("Petr", "727904777");
        telefonniSeznam.put("Petra", "727904977");

        System.out.println(telefonniSeznam.get("Petra"));
    }
}
