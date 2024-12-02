package gui.components;

import javax.swing.*;
import javax.swing.plaf.basic.BasicTableHeaderUI;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Hierarchy extends Base implements ActionListener {

    HashMap<String, HashMap<String, HashSet<String>>> loadData(String filePath){
        HashMap<String, HashMap<String, HashSet<String>>> bigMap = new HashMap<>();

        try {
            List<String> lines = Files.readAllLines(Paths.get("Cities.txt"));
            String[] parts;
            for (String line : lines){
                parts = line.split(",");
                //continent
                if (!bigMap.containsKey(parts[2])) {
                    //kontinent tam neni, pridam bez zeme, zatim
                    bigMap.put(parts[2], new HashMap<>());
                }

                //continent, ma uz zemi?
                if (!bigMap.get(parts[2]).containsKey(parts[1])){
                    //vezmi kontinent, vloz do nej zemi, do zeme dej prazdnou mnozinu mest
                    bigMap.get(parts[2]).put(parts[1], new HashSet<>());
                }

                bigMap.get(parts[2]).get(parts[1]).add(parts[0]);
            }
        }catch (IOException e){
            System.out.println(":/");
        }
        return bigMap;
    }

    public Hierarchy() {
        setLayout(new BorderLayout());

//        JPanel tbd = new JPanel();
//        tbd.setBackground(Color.red);
//        add(tbd, BorderLayout.CENTER);

        HashMap<String, HashMap<String, HashSet<String>>> bigMap = loadData("Cities.txt");

        DefaultMutableTreeNode root = new DefaultMutableTreeNode("World");
        DefaultTreeModel model = new DefaultTreeModel(root);
        JTree tree = new JTree(model);
        JScrollPane treePane = new JScrollPane(tree);

        for (String continent : bigMap.keySet()){
            DefaultMutableTreeNode continentNode = new DefaultMutableTreeNode(continent);
            for(String country : bigMap.get(continent).keySet()){
                DefaultMutableTreeNode countryNode = new DefaultMutableTreeNode(country);
                for (String city : bigMap.get(continent).get(country)){
                    DefaultMutableTreeNode cityNode = new DefaultMutableTreeNode(city);
                    countryNode.add(cityNode);
                }
                continentNode.add(countryNode);
            }
            root.add(continentNode);
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
