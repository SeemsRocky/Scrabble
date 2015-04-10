package code.ui;
 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
 
 

import code.model.Scrabble_055;
import code.model.Tile_024_055;
 
public class ButtonHandler_055 implements ActionListener{
        private Scrabble_055 _model;
        private int _col;
        private int _row;
        private Tile_024_055 _til;
       
        public ButtonHandler_055 (int i, Scrabble_055 model) {
                _model = model;
                _row = i/20;
                _col = i%20;
        }
 
        @Override
        public void actionPerformed(ActionEvent arg0) {
                _model.mark(_til, _row, _col);
               
        }
 
}