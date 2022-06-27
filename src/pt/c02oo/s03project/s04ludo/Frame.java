package pt.c02oo.s03project.s04ludo;

import javax.swing.JFrame;

public class Frame extends JFrame{
    public Frame(View view) { 
        add(view);
        setTitle("Super Ludo");
        setSize(740,755);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.setResizable(true);
        setVisible(true);
    }    
}
