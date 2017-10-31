/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Amanda
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class GameGUI extends JFrame { 
        
        GameButtons gameButtons = new GameButtons(); //Anropar Klassen med knapparna och metoderna
        protected JButton shuffleBtn = new JButton("Nytt spel");  //skapar en knapp
        
    GameGUI() {
        
        //Här anpassas design och positionering i vår JFrame
        setTitle("Puzzle Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout()); 
        add(gameButtons);
        add(shuffleBtn, BorderLayout.SOUTH);
        setSize(700,700);
        setLocationRelativeTo(null);
        setVisible(true);
        
        // en anonym inner-klass
        shuffleBtn.setForeground(Color.white);
        shuffleBtn.setBackground(Color.black);
        shuffleBtn.setFont(new Font("Arial", Font.BOLD, 50));
        shuffleBtn.addActionListener((ActionEvent e) -> {
            gameButtons.NewGame();
        });
    }
  
    public static void main(String[] args) {
       GameGUI ett = new GameGUI();  // skapar en instans av klassen 
    }
    
}