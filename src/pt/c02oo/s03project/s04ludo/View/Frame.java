package pt.c02oo.s03project.s04ludo.View;

import javax.swing.JFrame;

public class Frame extends JFrame{
    public Frame(ViewGrafico view) { 
        add(view);
        setTitle("Super Ludo");
        setSize(740,755);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.setResizable(true);
        setVisible(true);
    }    
}
