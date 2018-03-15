import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class App {

    private JFrame window;
    private JLabel labelName;
    private JTextField txtName;
    private JButton insertButton, listButton;
    private Collection<String> nameList;

    public App() {
        nameList = new HashSet<>();

        window = new JFrame("My App");
        window.setLayout(new FlowLayout());
        
        labelName = new JLabel("Name: ");
        txtName = new JTextField(10);
        insertButton = new JButton("Insert");
        listButton = new JButton("List");

        insertButton.addActionListener(e -> this.add(txtName.getText()));
        listButton.addActionListener(e -> this.list());

        window.add(labelName);
        window.add(txtName);
        window.add(insertButton);
        window.add(listButton);

        window.pack();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void add(String name) {
        nameList.add(name);
    }

    public void list() {
        if (nameList.size() > 0)
            nameList.forEach(System.out::println);
        
        else
            System.out.println ("The list is empty");
    }

    public static void main(String[] args) {
        new App().window.setVisible(true);        
    }
}
