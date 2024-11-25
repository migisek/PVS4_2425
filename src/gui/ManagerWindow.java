package gui;

import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ManagerWindow extends JFrame {
    DefaultTableModel tableModel;
    JTable table;
    ArrayList<Vacation> vacations;
    static final Font DEAFULT_FONT = new Font("Consolas", Font.BOLD, 18);
    static final Font DEAFULT_BUTTON_FONT = new Font("Consolas", Font.BOLD, 14);


    ManagerWindow() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 400);
        setTitle("Manager");
        setLayout(new BorderLayout());
        vacations = new ArrayList<>();
        //header - north
        JLabel headerLabel = new JLabel("Manage vacation applications", JLabel.CENTER);
        headerLabel.setFont(DEAFULT_FONT);
        add(headerLabel, BorderLayout.NORTH);

        // CENTER - table
        String[] columns = {"Name", "Phone", "Destination", "Days", "Student discount"};
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        Vacation tester = new Vacation("Tester", "111222333", "City", 42, true);
        vacations.add(tester);
        tableModel.addRow(tester.returnAsTableRow());

        //SOUTH - buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton addButton = new JButton("New application");
        addButton.setFont(DEAFULT_BUTTON_FONT);
        JButton viewButton = new JButton("View details");
        viewButton.setFont(DEAFULT_BUTTON_FONT);
        JButton deleteButton = new JButton("Delete");
        deleteButton.setFont(DEAFULT_BUTTON_FONT);

        //funkcionality buttonu
        addButton.addActionListener(e -> new Booking(this).setVisible(true));

        deleteButton.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "You need to select a row in order to delete it.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                int confirm = JOptionPane.showConfirmDialog(this, "You sure?", "Confirm delete", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION){
                    tableModel.removeRow(selectedRow);
                    vacations.remove(selectedRow);
                    JOptionPane.showMessageDialog(this, "Entry deleted", "Success", JOptionPane.INFORMATION_MESSAGE);
                }

            }
        });

        viewButton.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "You need to select a row in order to view it.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                Vacation v = vacations.get(selectedRow);
                new DetailView(v.returnAsTableRow()).setVisible(true);
            }
        });


        buttonPanel.add(addButton);
        buttonPanel.add(viewButton);
        buttonPanel.add(deleteButton);
        add(buttonPanel, BorderLayout.SOUTH);

    }


    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        FlatDarkLaf.setup();
        UIManager.setLookAndFeel(new FlatDarkLaf());

        new ManagerWindow().setVisible(true);
    }
}
