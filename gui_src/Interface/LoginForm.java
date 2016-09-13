/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import System.APSys;
import System.User;
import java.awt.Dimension;
import java.awt.FontFormatException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author AI-Saac
 */
public class LoginForm extends JFrame {
    // Variables declaration - do not modify                     
    private JLabel minimizeLabel, closeLabel, logoLabel, systemLogoLabel, 
            userIconLabel, lockIconLabel,feedbackLabel; 
    private JPanel mainPanel, usernamePanel, passwordPanel;
    private JPasswordField passwordField;
    private  JTextField usernameTextField;
    private JButton  loginButton; 
    // End of variables declaration            
    
    /**
     * Creates new form login
     */
    public LoginForm() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {
        Dimension nativeScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
        String resource = "gui_src/images/";
        mainPanel = new javax.swing.JPanel();
        logoLabel = new javax.swing.JLabel();
        systemLogoLabel = new javax.swing.JLabel();
        usernamePanel = new javax.swing.JPanel();
        userIconLabel = new javax.swing.JLabel();
        usernameTextField = new javax.swing.JTextField();
        passwordPanel = new javax.swing.JPanel();
        passwordField = new javax.swing.JPasswordField();
        lockIconLabel = new javax.swing.JLabel();
        loginButton = new JButton();
        feedbackLabel = new JLabel();
        minimizeLabel = new javax.swing.JLabel();
        closeLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(48, 49, 50));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(412, 442));
        int x = (nativeScreenSize.width/2)-(getPreferredSize().width/2);
        int y = (nativeScreenSize.height/2)-(getPreferredSize().height/2);
        setLocation(x,y);
        setResizable(false);

        mainPanel.setBackground(new java.awt.Color(48, 49, 50));
        mainPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        mainPanel.setPreferredSize(new java.awt.Dimension(400, 400));

        logoLabel.setIcon(new ImageIcon(resource+"holcim-logo-370x152.png"));

        systemLogoLabel.setFont(new java.awt.Font("Dialog", 1, 44)); // NOI18N
        systemLogoLabel.setForeground(new java.awt.Color(250, 250, 250));
        systemLogoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        systemLogoLabel.setIcon(new ImageIcon(resource+"planB-27x32.png")); // NOI18N
        systemLogoLabel.setText("PlanB");
        systemLogoLabel.setIconTextGap(10);

        usernamePanel.setBackground(new java.awt.Color(252, 254, 252));
        usernamePanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        usernamePanel.setMaximumSize(new java.awt.Dimension(200, 30));
        usernamePanel.setMinimumSize(new java.awt.Dimension(30, 40));
        usernamePanel.setPreferredSize(new java.awt.Dimension(100, 30));
        usernamePanel.setAlignmentX(JPanel.CENTER_ALIGNMENT);

        userIconLabel.setBackground(new java.awt.Color(252, 254, 252));
        userIconLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        userIconLabel.setIcon(new ImageIcon(resource+"Collaborator Male-24.png")); // NOI18N
        userIconLabel.setFocusable(false);
        userIconLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        usernameTextField.setBackground(new java.awt.Color(252, 254, 252));
        usernameTextField.setFont(new java.awt.Font("Dialog", 0, 19)); // NOI18N
        usernameTextField.setForeground(new java.awt.Color(201, 205, 209));
        usernameTextField.setText("USERNAME");
        usernameTextField.setBorder(null);
        usernameTextField.setOpaque(false);
        usernameTextField.setPreferredSize(new java.awt.Dimension(100, 24));

        javax.swing.GroupLayout usernamePanelLayout = new javax.swing.GroupLayout(usernamePanel);
        usernamePanel.setLayout(usernamePanelLayout);
        usernamePanelLayout.setHorizontalGroup(
            usernamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(usernamePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userIconLabel)
                .addGap(18, 18, 18)
                .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        usernamePanelLayout.setVerticalGroup(
            usernamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(usernamePanelLayout.createSequentialGroup()
                .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, usernamePanelLayout.createSequentialGroup()
                .addComponent(userIconLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        mainPanel.add(Box.createVerticalGlue());

        passwordPanel.setBackground(new java.awt.Color(252, 254, 252));
        passwordPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        passwordPanel.setMaximumSize(new java.awt.Dimension(200, 30));
        passwordPanel.setPreferredSize(new java.awt.Dimension(100, 30));

        passwordField.setBackground(new java.awt.Color(252, 254, 252));
        passwordField.setFont(new java.awt.Font("Dialog", 0, 19)); // NOI18N
        passwordField.setForeground(new java.awt.Color(201, 205, 209));
        passwordField.setText("PASSWORD");
        passwordField.setEchoChar((char)0);
        passwordField.setBorder(null);
        passwordField.setOpaque(false);
        passwordField.setPreferredSize(new java.awt.Dimension(100, 26));
        passwordField.addFocusListener(new FocusListener(){
            @Override
            public void focusLost(FocusEvent arg0) {
                char c = 0;
                if(passwordField.getPassword().equals("")){
                    passwordField.setEchoChar(c);
                    passwordField.setText("PASSWORD");
                }
            }
            @Override
            public void focusGained(FocusEvent arg0) {
                char c = '*';
                passwordField.setEchoChar(c);
                passwordField.setText("");
            }
        });

        lockIconLabel.setBackground(new java.awt.Color(252, 254, 252));
        lockIconLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lockIconLabel.setIcon(new ImageIcon(resource+"Lock-24.png")); // NOI18N
        lockIconLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout passwordPanelLayout = new javax.swing.GroupLayout(passwordPanel);
        passwordPanel.setLayout(passwordPanelLayout);
        passwordPanelLayout.setHorizontalGroup(
            passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, passwordPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lockIconLabel)
                .addGap(18, 18, 18)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        passwordPanelLayout.setVerticalGroup(
            passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(passwordPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lockIconLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        loginButton.setBackground(new java.awt.Color(252, 67, 68));
        loginButton.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        loginButton.setForeground(new java.awt.Color(48, 49, 50));
        loginButton.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        loginButton.setText("LOGIN");
        loginButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        loginButton.setPreferredSize(new java.awt.Dimension(200, 26));
        loginButton.setOpaque(true);
        loginButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                try {
                    loginButtonActionPerformed();
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
                } catch (FontFormatException ex) {
                    Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        feedbackLabel.setBackground(new java.awt.Color(48, 49, 50));
        feedbackLabel.setForeground(new java.awt.Color(252, 254, 252));
        feedbackLabel.setBorder(null);
        feedbackLabel.setPreferredSize(new java.awt.Dimension(186, 26));
        feedbackLabel.setOpaque(false);

        minimizeLabel.setVerticalAlignment(JLabel.CENTER);
        minimizeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minimizeLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/minusW.png"))); // NOI18N

        closeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        closeLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/closeW.png"))); // NOI18N

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
            .addGap(84, 84, 84)
            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addComponent(minimizeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(closeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)    
                            .addComponent(passwordPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                            .addComponent(usernamePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                            .addComponent(loginButton, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                            .addComponent(feedbackLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                            .addComponent(systemLogoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(closeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(minimizeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(logoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                .addGap(3, 3, 3)
                .addComponent(systemLogoLabel)
                .addGap(20, 20, 20)
                .addComponent(usernamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passwordPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(feedbackLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }
    
    private void loginButtonActionPerformed() throws NoSuchAlgorithmException, SQLException, IOException, FontFormatException, Exception{
        if(!(usernameTextField.getText().isEmpty())){
            if(!(String.valueOf(passwordField.getPassword()).isEmpty())){
                if(APSys.getTerminal().login(usernameTextField.getText(), String.valueOf(passwordField.getPassword()))){
                    this.dispose();
                    APSys.initSystem();
                }
                else{
                    usernameTextField.setText(null);
                    //checkLabel.setVisible(false);
                    passwordField.setText(null);
                    //goOnLabel.setVisible(false);
                    JOptionPane.showMessageDialog(null,"Username or Password Incorrect.","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        else{
            if((String.valueOf(passwordField.getPassword()).isEmpty()))
                passwordField.setText("PASSWORD");
            JOptionPane.showMessageDialog(usernamePanel,"Error! Username field is Empty.","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
}
