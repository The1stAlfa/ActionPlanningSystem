/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System;

import Interface.TerminalGUI;
import Interface.WLogin;
import aps.Organization;
import java.lang.reflect.InvocationTargetException;
import javax.swing.UIManager;

/**
 *
 * @author AI-Saac
 */
public class APSys {

    /**
     *
     */
    public static Organization org = new Organization();
    private static Terminal terminal_APSys;
    private static TerminalGUI terminalGUI_APSys;
    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     * @throws java.lang.reflect.InvocationTargetException
     */
    @SuppressWarnings("Convert2Lambda")
    public static void main(String[] args) throws InterruptedException, 
            InvocationTargetException,
            Exception {
        APSys.terminalGUI_APSys = new TerminalGUI();
        terminal_APSys = new Terminal();
        try {
            Thread.sleep(1500);
	} catch (InterruptedException e) {
        }
        
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run(){            
                //WLogin loginWindow = new WLogin();
                try {
                    UIManager.setLookAndFeel(
                            "javax.swing.plaf.metal.MetalLookAndFeel");
                          // "com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                        //UIManager.getCrossPlatformLookAndFeelClassName());
                } catch (Exception ex) {
                   
                }
            }
        });
    }
    
    /**
     *
     * @return
     */
    public static Terminal getTerminal(){
        return terminal_APSys;
    }
    
    /**
     *
     * @return
     */
    public static TerminalGUI getTerminalGUI(){
        return terminalGUI_APSys;
    }
    
    /**
     *
     * @param user
     */
    public static void deploySystem(User user){
        //APSys.terminal_APSys.setUser(user);
        APSys.terminalGUI_APSys = new TerminalGUI();
    }
}
