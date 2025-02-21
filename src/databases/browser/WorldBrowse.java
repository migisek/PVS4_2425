package databases.browser;

import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.*;

public class WorldBrowse extends JFrame {
    private static final String USER = "infis";
    private static final String PASSWORD = "infis";
    private static final String DB_URL = "jdbc:mysql://10.1.12.18:3306/world";

    MyText IDText, countryText, populationText, nameText;

    static ResultSet set;

    public WorldBrowse() throws SQLException {
        setSize(700, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        JPanel gridPanel = new JPanel(new GridLayout(4, 2, 2, 2));
        JPanel flowPanel = new JPanel(new FlowLayout());

        //ID
        MyLabel IDLabel = new MyLabel("ID:");
        gridPanel.add(IDLabel);
        IDText = new MyText(set.getString("ID"));
        gridPanel.add(IDText);

        //Name
        MyLabel nameLabel = new MyLabel("City name:");
        gridPanel.add(nameLabel);
        nameText = new MyText(set.getString("Name"));
        gridPanel.add(nameText);

        //CountryCode
        MyLabel countryLabel = new MyLabel("Country:");
        gridPanel.add(countryLabel);
        countryText = new MyText(set.getString("CountryCode"));
        gridPanel.add(countryText);

        //Population
        MyLabel populationLabel = new MyLabel("Population:");
        gridPanel.add(populationLabel);
        populationText = new MyText(String.valueOf(set.getInt("Population")));
        gridPanel.add(populationText);

        //flow-buttons:

        MyButton prevButton = new MyButton("Prev");
        MyButton nextButton = new MyButton("Next");
        nextButton.addActionListener(e -> next());
        prevButton.addActionListener(e -> previous());

        MyButton firstButton = new MyButton("First");
        MyButton lastButton = new MyButton("Last");

        lastButton.addActionListener(e -> last());
        firstButton.addActionListener(e -> first());
        flowPanel.add(firstButton);
        flowPanel.add(prevButton);
        flowPanel.add(nextButton);
        flowPanel.add(lastButton);
        add(gridPanel, BorderLayout.CENTER);
        add(flowPanel, BorderLayout.SOUTH);
    }

    void next() {
        try {
            if (set.next()){
                IDText.setText(set.getString("ID"));
                nameText.setText(set.getString("Name"));
                countryText.setText(set.getString("CountryCode"));
                populationText.setText(String.valueOf(set.getInt("Population")));
            } else {
                set.previous();
                JOptionPane.showMessageDialog(this, "Konec seznamu");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Problem s SQL: " + e.getMessage(), ":(", JOptionPane.ERROR_MESSAGE);
        }
    }

    void last() {
        try {
            if (set.last()){
                IDText.setText(set.getString("ID"));
                nameText.setText(set.getString("Name"));
                countryText.setText(set.getString("CountryCode"));
                populationText.setText(String.valueOf(set.getInt("Population")));
            } else {
                set.previous();
                JOptionPane.showMessageDialog(this, "Konec seznamu");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Problem s SQL: " + e.getMessage(), ":(", JOptionPane.ERROR_MESSAGE);
        }
    }

    void first() {
        try {
            if (set.first()){
                IDText.setText(set.getString("ID"));
                nameText.setText(set.getString("Name"));
                countryText.setText(set.getString("CountryCode"));
                populationText.setText(String.valueOf(set.getInt("Population")));
            } else {
                set.next();
                JOptionPane.showMessageDialog(this, "Konec seznamu");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Problem s SQL: " + e.getMessage(), ":(", JOptionPane.ERROR_MESSAGE);
        }
    }

    void previous() {
        try {
            if (set.previous()){
                IDText.setText(set.getString("ID"));
                nameText.setText(set.getString("Name"));
                countryText.setText(set.getString("CountryCode"));
                populationText.setText(String.valueOf(set.getInt("Population")));
            } else {
                set.next();
                JOptionPane.showMessageDialog(this, "Konec seznamu");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Problem s SQL: " + e.getMessage(), ":(", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String queryAll = "SELECT * FROM city";
            set = statement.executeQuery(queryAll);
            set.next();

            new WorldBrowse().setVisible(true);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Problem s SQL: " + e.getMessage(), ":(", JOptionPane.ERROR_MESSAGE);
        }
    }
}

class MyLabel extends JLabel {
    public MyLabel(String text) {
        super(text);
        setFont(new Font("Consolas", Font.PLAIN, 18));
        // TODO: 17.02.2025 Design

        setOpaque(true);
        setBackground(new Color(0x53A84F));
        setForeground(new Color(0x00ffff));
    }
}

class MyText extends JTextField {
    public MyText(String text) {
        super(text);
        setFont(new Font("Consolas", Font.PLAIN, 18));
        // TODO: 17.02.2025 Design

        setOpaque(true);
        setBackground(new Color(0x08FF00));
        setForeground(new Color(0xFF001E));

    }
}

class MyButton extends JButton {
    public MyButton(String text) {
        super(text);
        setFont(new Font("Consolas", Font.PLAIN, 18));
        // TODO: 17.02.2025 Design
//
        setOpaque(true);
        setBackground(Color.BLUE);
        setForeground(Color.WHITE);
    }
}
