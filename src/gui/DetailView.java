package gui;

import javax.swing.*;
import java.awt.*;

public class DetailView extends JFrame {

    DetailView(String[] data){
        setTitle("Detail view");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel headerLabel = new JLabel("GetAway", JLabel.CENTER);
        headerLabel.setFont(new Font("Consolas", Font.BOLD, 18));
        add(headerLabel, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));


        JLabel nameLabel = new JLabel("Full Name:");
        nameLabel.setFont(new Font("Consolas", Font.PLAIN, 14));
        JLabel nameDetail = new JLabel(data[0], JLabel.CENTER);
        nameDetail.setFont(new Font("Consolas", Font.PLAIN, 14));
        formPanel.add(nameLabel);
        formPanel.add(nameDetail);

        JLabel phoneLabel = new JLabel("Phone Number:");
        phoneLabel.setFont(new Font("Consolas", Font.PLAIN, 14));
        JLabel phoneDetail = new JLabel(data[1], JLabel.CENTER);
        phoneDetail.setFont(new Font("Consolas", Font.PLAIN, 14));
        formPanel.add(phoneLabel);
        formPanel.add(phoneDetail);

        JLabel discountLabel = new JLabel("Student Discount:");
        discountLabel.setFont(new Font("Consolas", Font.PLAIN, 14));
        JLabel discountLabelDetail = new JLabel(data[4], JLabel.CENTER);
        discountLabelDetail.setFont(new Font("Consolas", Font.PLAIN, 14));
        formPanel.add(discountLabel);
        formPanel.add(discountLabelDetail);

        JLabel destinationLabel = new JLabel("Destination:");
        destinationLabel.setFont(new Font("Consolas", Font.PLAIN, 14));
        JLabel destinationInfo = new JLabel(data[2], JLabel.CENTER);
        destinationInfo.setFont(new Font("Consolas", Font.PLAIN, 14));
        formPanel.add(destinationLabel);
        formPanel.add(destinationInfo);

        JLabel daysLabel = new JLabel("Days:");
        daysLabel.setFont(new Font("Consolas", Font.PLAIN, 14));
        JLabel daysInfo = new JLabel(data[3], JLabel.CENTER);
        daysInfo.setFont(new Font("Consolas", Font.PLAIN, 14));
        formPanel.add(daysLabel);
        formPanel.add(daysInfo);

        add(formPanel,BorderLayout.CENTER);
    }

}
