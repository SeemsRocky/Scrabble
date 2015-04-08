package code.ui;
 
import java.awt.*;
import java.util.*;
 

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import code.model.Scrabble;
 
public class ScrabbleWindow implements Observer, Runnable {
 
        private Scrabble _scrabble;
        private ArrayList<JButton> _buttons;
 
//        public ScrabbleWindow() {      
//                _scrabble = new Scrabble();
//                _scrabble.addObserver(this);
//                _buttons = new ArrayList<JButton>();
//        }
 
        @Override
        public void run() {
                JFrame window = new JFrame("Scabble");
                window.setMinimumSize(new Dimension(800, 800));
                JPanel p1 = new JPanel();
                JPanel p2 = new JPanel();
                p1.setSize(400, 400);
                p1.setBackground(Color.CYAN);
                p2.setBackground(Color.BLUE);
                p1.setLayout(new GridLayout(20, 20, 4, 4));
                p2.setLayout(new GridLayout(4, 12, 0, 25));
               
                /*
                 * For Save and Open button
                 */
               
                JPanel p3 = new JPanel();
               
                JButton save = new JButton("save");
                JButton open = new JButton("open");
                p3.setBackground(Color.WHITE);
                p3.add(save);
                p3.add(open);
               
 
                for (int i = 0; i < 400; i++) {
                        JButton b = new JButton("x");
                        p1.add(b);
                        b.setMinimumSize(new Dimension(100,100));
                        b.addActionListener(new ButtonHandler(i, _scrabble));
                }
                for (int i = 0; i < 48; i++) {
                        JButton b = new JButton("y");
                        p2.add(b);
                        b.addActionListener(new ButtonHandler(i, _scrabble));
                }
               
               
 
                window.setLayout(new BorderLayout());
                window.add("North", p1);
                window.add("South", p2);
                window.add("Center", p3);
                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                window.setVisible(true);
                window.pack();
                window.setBackground(Color.BLACK);
 
        }
 
        @Override
        public void update(Observable o, Object arg) {
                String s = _scrabble.toString();
                for (int i = 0; i < s.length(); i++) {
                        _buttons.get(i).setText("" + s.charAt(i));
 
                }
        }
 
        public static void main(String[] args) {
                SwingUtilities.invokeLater(new ScrabbleWindow());
        }
 
}