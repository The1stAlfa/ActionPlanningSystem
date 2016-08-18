/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interface;

import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author LoboAlfa2.0
 */
public class MovieOptionsFrame extends JFrame {
    
    MovieOptionsFrame(){
        
    }
    
    MovieOptionsFrame(int xPosition, int yPosition,int height){
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setUndecorated(true);
        this.setVisible(false);
        this.getContentPane().setBackground(Color.decode("#202020"));
        this.setBounds(xPosition+180,yPosition,250,height);
    }
}
