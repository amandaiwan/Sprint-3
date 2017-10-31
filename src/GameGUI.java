
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
   
        shuffleBtn.setForeground(Color.white);
        shuffleBtn.setBackground(Color.black);
        shuffleBtn.setFont(new Font("Arial", Font.BOLD, 50));
         // en anonym inner-klass
        shuffleBtn.addActionListener((ActionEvent e) -> {
            gameButtons.NewGame();
        });
    }
  
    public static void main(String[] args) {
       GameGUI ett = new GameGUI();  // skapar en instans av klassen 
    }
    
}