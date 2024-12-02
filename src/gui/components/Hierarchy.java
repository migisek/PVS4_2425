package gui.components;

import javax.swing.*;
import javax.swing.plaf.basic.BasicTableHeaderUI;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Hierarchy extends Base implements ActionListener {

    public Hierarchy() {
        setLayout(new BorderLayout());

//        JPanel tbd = new JPanel();
//        tbd.setBackground(Color.red);
//        add(tbd, BorderLayout.CENTER);


        DefaultMutableTreeNode root = new DefaultMutableTreeNode("MainNode");
        DefaultTreeModel model = new DefaultTreeModel(root);
        JTree tree = new JTree(model);
        JScrollPane treePane = new JScrollPane(tree);

        DefaultMutableTreeNode example = new DefaultMutableTreeNode("Example");
        root.add(example);

        for (int i = 0; i < 5; i++) {
            root.add(new DefaultMutableTreeNode("Ukazka " + (i+1)));
        }

        for (int i = 0; i < 5; i++) {
            example.add(new DefaultMutableTreeNode("test " + (i+1)));
        }



        JTextArea textArea = new JTextArea();
        JScrollPane textPane = new JScrollPane(textArea);
        textPane.setPreferredSize(new Dimension(200,getHeight()));

        add(textPane, BorderLayout.EAST);
        add(treePane, BorderLayout.CENTER);
        JButton b = new JButton("neco");

        b.addActionListener(this);
    }

    public static void main(String[] args) {
        new Hierarchy().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
