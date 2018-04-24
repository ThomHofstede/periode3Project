
package Schermen;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;


public class ProjectTZT {


    public static void main(String[] args) {
        Welkomstscherm welkomstscherm = new Welkomstscherm();
        welkomstscherm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        welkomstscherm.setVisible(true);
    }
    /*private JButton login, registreer;
    
    public Startscherm(){
        setTitle("TZT Post");
        setLayout(new FlowLayout());
        setSize(1200,700);
        
        login = new JButton("Login");
        login.addActionListener(this);
        this.add(login);
        registreer = new JButton("Registreer");
        registreer.addActionListener(this);
        this.add(registreer);
        
        this.setVisible(true);
    } */
}
