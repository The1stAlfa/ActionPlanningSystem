/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interface;

import System.APSys;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

/**
 *
 * @author LoboAlfa2.0
 */
public class HallOptionsFrame extends JPopupMenu {
    private JLabel optionLabel;
    private JPanel mainPanel;
    private String resource;
    
    HallOptionsFrame(){
    
    }
    
    HallOptionsFrame(int xPosition, int yPosition,int height){
        resource = new String("resources/images/");
        //this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        //this.setUndecorated(true);
        this.setVisible(true);
        //this.getContentPane().setBackground(Color.decode("#202020"));
        this.setBackground(Color.decode("#202020"));
        //this.setBounds(xPosition+180,yPosition,250,height);
        this.setSize(250, height);
        mainPanel = new JPanel();
        mainPanel.setBackground(Color.decode("#202020"));
        optionLabel = new JLabel();
        //this.setContentPane(mainPanel);
        mainPanel.add(optionLabel);
        /*mainPanel.addMouseListener(new MouseAdapter() {
            public void mouseEntered(){
                JPanel panel = APSys.getTerminalGUI().movieLabelContainer;
                JLabel label = APSys.getTerminalGUI().movieLabel;
                panel.setBackground(Color.decode("#202020"));
                label.setIcon(new ImageIcon(resource+"appbar.movie.clapper.select2.png"));
                panel.repaint();
                label.repaint();
                
            }
            public void mouseExited(MouseEvent e) {
                disposeWindow();
            }
        });*/
    }
    
    public void disposeWindow(){
        this.setVisible(false);
        //this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }
}
