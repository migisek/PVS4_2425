package gui.datavisual;

import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DataTable extends JFrame {
    ArrayList<Record> data;
    DefaultTableModel model;
    String[] COLUMNS = {"Name", "Year of Release", "Rating", "Duration"};
    JPanel controlPanel;

    public DataTable() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 850);
        setLocationRelativeTo(null);
        setTitle("Vizualizace dat");

        setLayout(new BorderLayout());

        JButton loadButton = new JButton("Load Data");
        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        JRadioButton nameButton = new JRadioButton("Name");
        JRadioButton yearButton = new JRadioButton("Year");
        JRadioButton ratingButton = new JRadioButton("Rating");
        JRadioButton durationButton = new JRadioButton("Duration");

        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadData("Movies.txt");
                fillTable();
            }
        });

        model = new DefaultTableModel(COLUMNS, 0);

        JTable table = new JTable(model);
        table.setEnabled(false);
        JScrollPane sp = new JScrollPane(table);

        ButtonGroup group = new ButtonGroup();
        group.add(nameButton);
        group.add(yearButton);
        group.add(ratingButton);
        group.add(durationButton);

        controlPanel.add(nameButton);
        controlPanel.add(yearButton);
        controlPanel.add(ratingButton);
        controlPanel.add(durationButton);
        controlPanel.add(loadButton);

        JButton clearButton = new JButton("Clear table");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearTable();
            }
        });
        controlPanel.add(clearButton);


        add(controlPanel, BorderLayout.NORTH);
        add(sp, BorderLayout.CENTER);
    }

    void fillTable(){
        for (Record record : data){
            model.addRow(record.formattedRow());
        }
        // lambda varianta
//        data.forEach(record -> model.addRow(record.formattedRow()));

    }

    void clearTable(){
        model.setRowCount(0);
    }

    void loadData(String fileName){
        data = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            String[] params;
            for (String line : lines){
                params = line.split(";");
                Record toAdd = new Record(
                        params[0],
                        Integer.parseInt(params[1]),
                        Double.parseDouble(params[2]),
                        Integer.parseInt(params[3])
                );
                data.add(toAdd);
            }
            if (data.isEmpty()){
                JOptionPane.showMessageDialog(null, "No data loaded!");
            }
        } catch (IOException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        FlatDarkLaf.setup();
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }

        new DataTable().setVisible(true);
    }
}
