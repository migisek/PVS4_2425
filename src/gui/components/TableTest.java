package gui.components;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TableTest extends JFrame {
    JTable table;
    DefaultTableModel model;
    JScrollPane sp;

    public TableTest(String title) {
        super(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
        String[] columns = {"Col1", "Col2", "Col3", "Col4"};
        setLayout(new BorderLayout());

        model = new DefaultTableModel(columns, 0);


        table = new JTable(model);

        sp = new JScrollPane(table);

        for (int i = 0; i < 30; i++) {
            model.addRow(new String[]{"A", "B", "C", "D"});
        }

//        table.setEnabled(false);//do tabulky nebude mozne psat
        table.setFont(new Font("Consolas", Font.PLAIN, 16));
        table.setBackground(Color.yellow);
        table.setSelectionBackground(Color.cyan);



        table.setGridColor(Color.red);
        table.setRowHeight(20);

        add(sp, BorderLayout.CENTER);

        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clear();
            }
        });
        add(clearButton, BorderLayout.NORTH);
    }

    void clear(){
        model.setRowCount(0);
    }

    public static void main(String[] args) {
        new TableTest("Table Demo").setVisible(true);
    }
}
