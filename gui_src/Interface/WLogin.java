package Interface;


import System.APSys;
import System.User;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LoboAlfa2.0
 */
public class WLogin extends JFrame{
    private final Dimension nativeScreenSize;
    private int xPosition=0, yPosition=0;
    private JLabel goOnLabel,checkLabel ;
    private JTextField usernameTF;
    private final JPasswordField passwordTF;
    private final JPanel mainPanel;
    private final String resource;
    
    public WLogin(){
        super("System Access");
        resource = new String("resources/images/");
        this.setUndecorated(true);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.decode("#464646")));
        this.setContentPane(mainPanel);
        this.getContentPane().setBackground(Color.decode("#282828"));
        nativeScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
        
        JLabel wlTitleLabel = new JLabel("   Login");
        wlTitleLabel.setForeground(Color.WHITE);
        wlTitleLabel.setFont(new Font("title",Font.BOLD,16));
        JLabel wlExitLabel = new JLabel();
        wlExitLabel.setIcon(new ImageIcon(resource+"appbar.close3.png"));
        wlExitLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        wlExitLabel.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                System.exit(0);
            }  
        });
        JLabel wlImageLabel = new JLabel();
        wlImageLabel.setIcon(new ImageIcon(resource+"logomtm-white1.png"));
        
        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setForeground(Color.WHITE);
        
        usernameTF = new JTextField();
        usernameTF.addKeyListener(new KeyListener(){
            public void keyPressed(KeyEvent e){}
            public void keyTyped(KeyEvent e){}
            public void keyReleased(KeyEvent e){
                //User user = APSys.getTerminal().searchUser(usernameTF.getText());
                //if(user != null){
                  //  checkLabel.setVisible(true);
                //}
                //else
                    //checkLabel.setVisible(false);
            }
        });
        
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setForeground(Color.WHITE);
        
        passwordTF = new JPasswordField();
        passwordTF.addKeyListener(new KeyListener(){
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    validateDataInput();
                }
            }

            @Override
            public void keyTyped(KeyEvent e){
                int keyTypedChar = e.getKeyChar();
                System.out.println(keyTypedChar);
                if(keyTypedChar != 10){
                    goOnLabel.setVisible(true);
                }
            }

            @Override
            public void keyReleased(KeyEvent e){}
        });
        
        JLabel blankLabel = new JLabel();     
        checkLabel = new JLabel();
        checkLabel.setIcon(new ImageIcon(resource+"appbar.check1.png"));
        checkLabel.setVisible(false);
        
        goOnLabel = new JLabel();
        goOnLabel.setIcon(new ImageIcon(resource+"appbar.arrow.right1.png"));
        goOnLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        goOnLabel.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                validateDataInput();
            }
        });
        goOnLabel.setVisible(false);
        
        GroupLayout layoutWLogin = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layoutWLogin);
        layoutWLogin.setAutoCreateGaps(true);
        layoutWLogin.setAutoCreateContainerGaps(true);
        
        layoutWLogin.setHorizontalGroup(
            layoutWLogin.createParallelGroup(GroupLayout.Alignment.CENTER)
                    .addComponent(wlTitleLabel)
                    .addGroup(layoutWLogin.createSequentialGroup()
                        .addComponent(wlImageLabel)
                        .addGroup(layoutWLogin.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(usernameLabel)
                            .addGroup(layoutWLogin.createSequentialGroup()
                                .addComponent(usernameTF,GroupLayout.DEFAULT_SIZE,120,120)
                                .addComponent(blankLabel,GroupLayout.PREFERRED_SIZE,12,12))
                            .addComponent(passwordLabel)
                            .addComponent(passwordTF,GroupLayout.DEFAULT_SIZE,120,120)))
        );
                
        layoutWLogin.setVerticalGroup(
            layoutWLogin.createSequentialGroup()
                    .addComponent(wlTitleLabel)
                    .addGap(10)
                    .addGroup(layoutWLogin.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(wlImageLabel)
                        .addGroup(layoutWLogin.createSequentialGroup()
                            .addGap(25)
                            .addComponent(usernameLabel)
                            .addGroup(layoutWLogin.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(usernameTF,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                                .addComponent(blankLabel))
                            .addComponent(passwordLabel)
                            .addComponent(passwordTF,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)))
        );
        
        pack();
        xPosition = (int)((nativeScreenSize.getWidth()/2)-(this.getWidth()/2));
        yPosition = (int)((nativeScreenSize.getHeight()/2)-(this.getHeight()/2));
        this.setBounds(xPosition,yPosition,this.getWidth(),this.getHeight());
        this.getContentPane().add(wlExitLabel);
        this.getContentPane().add(goOnLabel);
        this.getContentPane().add(checkLabel);
        wlExitLabel.setBounds(this.getWidth()-22,0,24,24);
        goOnLabel.setBounds(this.getWidth()-37,this.getHeight()-74,32,32);
        checkLabel.setBounds(this.getWidth()-37,this.getHeight()-124,32,32);
    }
    
    private void initSystem(User user){
        this.dispose();
        APSys.deploySystem(user);
    }
    
    private void validateDataInput(){
        if(!(usernameTF.getText().isEmpty())){
                        if(!(String.valueOf(passwordTF.getPassword()).isEmpty())){
                            if(APSys.getTerminal().authenticate(usernameTF.getText(), String.valueOf(passwordTF.getPassword()))){
                                    initSystem(APSys.getTerminal().searchUser(usernameTF.getText()));
                            }
                            else if(checkLabel.isVisible()){
                                passwordTF.setText(null);
                                goOnLabel.setVisible(false);
                                JOptionPane.showMessageDialog(null,"Password Incorrect.","Error",JOptionPane.ERROR_MESSAGE);
                                
                            }
                            else{
                                usernameTF.setText(null);
                                checkLabel.setVisible(false);
                                passwordTF.setText(null);
                                goOnLabel.setVisible(false);
                                JOptionPane.showMessageDialog(null,"Username or Password Incorrect.","Error",JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                    else{
                        if((String.valueOf(passwordTF.getPassword()).isEmpty())){
                            goOnLabel.setVisible(false);
                        }
                        JOptionPane.showMessageDialog(usernameTF,"Data Input Invalid. Username is Empty.","Error",JOptionPane.ERROR_MESSAGE);
                    }
    }
}
