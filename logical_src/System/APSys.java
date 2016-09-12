/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System;

import Interface.LoginForm;
import Interface.SplashWindow;
import Interface.TerminalGUI;
import Interface.WLogin;
import aps.*;
import java.awt.FontFormatException;
import java.awt.Frame;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import javax.swing.JProgressBar;
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
        terminal_APSys = new Terminal();
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run(){            
                SplashWindow w = new SplashWindow("gui_src\\images\\planB-182x263.png", 
                new Frame(), 2500);
                LoginForm login = new LoginForm();
                try {
                    UIManager.setLookAndFeel(
                            "javax.swing.plaf.metal.MetalLookAndFeel");
                          // "com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                        //UIManager.getCrossPlatformLookAndFeelClassName());
                    login.setVisible(true);
                } catch (Exception ex) {
                    System.out.println("MAL");
                    ex.printStackTrace();
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
    public static void initSystem() throws IOException, FontFormatException{
        try{
            terminal_APSys.loadBusinessInformation();
            terminalGUI_APSys = new TerminalGUI();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
