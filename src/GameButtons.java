
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GameButtons extends JPanel implements ActionListener {

    protected List<JButton> btns = new ArrayList<>();
    protected boolean won = false;

    public GameButtons() {

        setLayout(new GridLayout(4, 4));

        for (int i = 1; i < 16; i++) { // Denna skapar alla knappar 0-16
            JButton btn = new JButton(String.valueOf(i));
            btn.setHorizontalAlignment(JButton.CENTER);
            btn.setFont(new Font("Helvetica", Font.BOLD, 20));
            btn.setForeground(Color.white);
            btn.setBackground(Color.black);
            btns.add(btn);
            btn.addActionListener(this); // dedikerar en lyssnare, för knappen btn
        }
        
        JButton emptyBtn = new JButton("");
        emptyBtn.setFont(new Font("Helvetica", Font.BOLD, 20));
        emptyBtn.setForeground(Color.white);
        emptyBtn.setBackground(Color.black);
        emptyBtn.addActionListener(this);
        btns.add(emptyBtn);

        NewGame();

    }

    /**
     * Metoden NewGame gör att knapparna blandas om vid nytt spel. Detta gör
     * vi med hjälp av Collection.shuffel. Metoden revalidate begär att
     * barnkomponenterna placeras om.
     */
    public void NewGame() { 
        Collections.shuffle(btns);
        for (JButton knapp : btns) {
            add(knapp);
        }
        revalidate();
    }
    
    /**
     * Denna actionListner talar om för den tomma rutan att ersätta sitt värde
     * med rutan bredvid som användaren klickat på. Den talar även om ifall 
     * du har vunnit spelet beroende på vart komponenterna befinner sig.
     * @param e nödvändig för att vi ska kunna "flytta" texten i knapparna. 
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        JButton btn = (JButton) e.getSource(); // vad gör denna?

        int emptyIndex = 0; // tom index
        int currentIndex = 0; // nuvarande index

        for (int i = 0; i < btns.size(); i++) { 
            if (btns.get(i).getText().equals("")) { // returnerar elementet där inehållet är det samma med ""
                emptyIndex = i; // då blir emptyIndex positionen i ArrayListan i.

            } else if (btns.get(i).getText().equals(btn.getText())) {
                currentIndex = i;
            }
        }

        int left = currentIndex - 1; // Om det ska gå till vänster, blir flyttpositionen -1 
        int right = currentIndex + 1; // Om det ska gå till höger , blir flyttpositionen +1
        int top = currentIndex - 4; // Om det ska gå upp, blir flyttpositionen -4
        int bottom = currentIndex + 4; // Om det ska gå ner, blir flyttpositionen +4

        if (emptyIndex == left || emptyIndex == right || emptyIndex == top
                || emptyIndex == bottom) {
            JButton emptyBtn = btns.get(emptyIndex);
            emptyBtn.setText(btn.getText());
            btn.setText("");
        }
        
       // kollar om man vunnit 
        String allNumbers = "";
        for (JButton b : btns) {
            allNumbers += b.getText();
        }
        if (allNumbers.equals("123456789101112131415")) {
            JOptionPane.showMessageDialog(null, "Grattis, du vann!");
            won = true;
        } else {
            won = false;
        }
    }
}
