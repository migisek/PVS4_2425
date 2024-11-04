package gui.components;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TableDemo extends JFrame {

    public TableDemo(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Table showcase");
        setSize(700, 700);

        String[] columns = {"Col 1","Col 2","Col 3","Col 4"};

        DefaultTableModel model = new DefaultTableModel(columns,0);

        JTable table = new JTable(model);
        table.setFont(new Font("Consolas", Font.BOLD, 18 ));
//        table.setBackground(Color.CYAN);
        table.setForeground(Color.RED);
        table.setSelectionBackground(Color.YELLOW);

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);

        model.addRow(new String[]{"A", "B", "C", "D"} );
        model.addRow(new String[]{"I", "II", "III", "IV"} );

        model.setRowCount(0);//smaze vse

        for (int i = 0; i < 10; i++) {
            model.addRow(new String[]{"I", "II", "III", "IV", "V"} );
        }
        table.setEnabled(false);
        table.setRowHeight(26);
//        table.setRowMargin(6);
        pack();
    }

    public static void main(String[] args) {
        FlatLightLaf.setup();

        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }
        new TableDemo().setVisible(true);
    }
}
