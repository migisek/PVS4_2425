package gui.basics;

import javax.swing.*;
import java.io.File;

public class Options {
    public static void main(String[] args) {
//        try {
//            UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
//        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException |
//                 IllegalAccessException e) {
//            throw new RuntimeException(e);
//        }
        String s = JOptionPane.showInputDialog("Neco zadej");
        System.out.println("Zadal jsi: " + s);

        int answer = JOptionPane.showConfirmDialog(null,
                "Uzavrena otazka",
                "nejaky titulek",
                JOptionPane.YES_NO_CANCEL_OPTION);

        JOptionPane.showMessageDialog(null, "Uzitecna zprava",
                "Titulek", JOptionPane.QUESTION_MESSAGE);

        JFileChooser fileChooser = new JFileChooser();
        int code = fileChooser.showOpenDialog(null);
        System.out.println("Code: " + code);
        System.out.println("Zadana cesta byla: " + fileChooser.getSelectedFile().getName());
    }
}
