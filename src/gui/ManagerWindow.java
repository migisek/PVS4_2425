package gui;

import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagerWindow extends JFrame {
    DefaultTableModel tableModel;
    JTable table;

    static final Font DEAFULT_FONT = new Font("Consolas", Font.BOLD, 18);
    static final Font DEAFULT_BUTTON_FONT = new Font("Consolas", Font.BOLD, 14);


    ManagerWindow() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 400);
        setTitle("Manager");
        setLayout(new BorderLayout());

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
        tableModel.addRow(new String[]{"Tester", "111222333", "City", "41", "Yes"});


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
                    JOptionPane.showMessageDialog(this, "Entry deleted", "Success", JOptionPane.INFORMATION_MESSAGE);
                }

            }
        });


        buttonPanel.add(addButton);
        buttonPanel.add(viewButton);
        buttonPanel.add(deleteButton);
        add(buttonPanel, BorderLayout.SOUTH);

    }

    void addRow(String name, String phone, String destination, int days, boolean studentDiscount) {
        tableModel.addRow(new String[]{
                name,
                phone,
                destination,
                String.valueOf(days),
                studentDiscount ? "Yes" : "No"
        });
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        FlatDarkLaf.setup();
        UIManager.setLookAndFeel(new FlatDarkLaf());

        new ManagerWindow().setVisible(true);
    }
}
