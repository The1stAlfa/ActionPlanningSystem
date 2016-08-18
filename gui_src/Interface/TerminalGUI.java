/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JMenu;

/**
 * @palette
 * PALETTE
 * +----------------------------------+------------------------------ -+----------------------------------+------------------------------------+----------------------------------------+
 * |         COLORS         | HEX.CODE|          ANALOG COLORS         |         COMPLEMENTARY COLORS     |         MONOCROMATIC COLORS        |             COMPOUND COLORS            |
 * +----------------------------------+--------------------------------+----------------------------------+------------------------------------+----------------------------------------+
 * |------------------------|---------|--------------------------------|----------------------------------|------------------------------------|----------------------------------------|
 * | ABSOLUTE WHITE         | #FFFFFF |                                |                                  |                                    |                                        |
 * | ABSOLUTE BLACK         | #000000 |                                |                                  |                                    |                                        |
 * | HOLCIM WHITE           | #FCFEFC |R#FF0000 ORA#E8AE0C             |GR#00FF00-19FF19 MAG#FF007F-B20059|GRA#CACCCA W#FDFFFD GR#587F58-B0FFB0|GR#5A995A GRE#B9B5CC W#FEFFFC PUI#DABCFF|
 * | HOLCIM RED             | #FC4344 |R#FF0D0D-#E80C0C                |GR#00FF47-00B232 R#FF0001         |BR#7F4848 PI#FF9091 R#FF4445-CC3637 |BR#995A5A W#FFFCFF YEL#EBFFBC OC#CCCCB5 | 
 * | HOLCIM BLACK           | #232323 |R#FF0000                        |                                  |W#CCCCCC-FFFFFF BR#7F5959 PI#FFB2B2 |                                        |
 * | HOLCIM GRAY            | #9B9B9B |R#FF0D0D                        |                                  |                                    |                                        |
 * | HOLCIM SECOND RED      | #E83434 |                                |                                  |                                    |                                        |
 * | HOLCIM BROWN           | #692628 |R#FF0F0D-#E80C0F                |                                  |                                    |                                        |
 * | HOLCIM GRAY REFLECTIVE | #D1D3D1 |YEL#E8AE0C BLU#160CE8 GR#0DFF96 |GR#00FF00 MAG#FF007F-B20059       |PI#FFA9AB R#FF5C61-CC4A4E BR#7F5456 |GR#5A995A PU#DABCFF-B9B5CC              |
 * | HOLCIM DARK GRAY       | #4C4B4C |ORA#FF530D ORA#E82C0C MAG#E80C7A|MAG#FF00FF GR#3EB200-59FF00       |PU#7F587F-FFAFFF W#FFFCFF-CCC9CC    |PU#995A99 0C#CCC7B5                     |
 * | HOLCIM SECOND BROWN    | #453D3F |R#FF1E0D                        |R#FF0040-FF1953 GR#00FF24-00B219  |                                    |R#995A6A OC#FEFFBC-CCCB5 W#FFFCFF       |
 * +----------------------------------+--------------------------------+----------------------------------+------------------------------------+----------------------------------------+
 */

/**
 *
 * @author LoboAlfa2.0
 */

public class TerminalGUI extends JFrame{
    private Dimension nativeScreenSize;
    private int xPosition=0, yPosition=0;
    private JMenuBar mainMenu;
    private JMenuItem dashboardMenu, meetingMenu, actionPlanMenu, teamMenu,
            profileMenu,settingMenu,exitItem;
    private JPanel mainPanel, menuPanel, titleBarPanel, optionsContentPanel,
            frameButtonsPanel;
    private JPanel dashboardPanel, actionPlanPanel, meetingPanel;
    private JLabel apsLogoLabel, resizeLabel, minimizeLabel, closeLabel;
    public JLabel hallLabel, movieLabel, aboutLabel, settingsLabel, userLabel;
    private JLabel initImageLabel;
   // private JMenuItem item;
    private String resource;
    private boolean resizeFlag = false;

       
    public TerminalGUI(){
        initComponents();            
    }
            
    private void initComponents(){
        resource = "resources/images/";
        setUndecorated(true);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        this.setResizable(true);
        createTitleBarPanel();
        createMainMenu();
        createOptionsContentPanel();
        nativeScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
        setMinimumSize(new Dimension(867,662));
        mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.decode("#464646")));
        mainPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
        setContentPane(mainPanel);
        getContentPane().setBackground(Color.decode("#000000"));
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(titleBarPanel, BorderLayout.NORTH);
        mainPanel.add(mainMenu, BorderLayout.WEST);
        mainPanel.add(optionsContentPanel, BorderLayout.CENTER);
        
        pack();
    }
    
    private void createTitleBarPanel(){
        titleBarPanel = new JPanel();
        titleBarPanel.setLayout(new BorderLayout());    
        titleBarPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE,30));
        titleBarPanel.setPreferredSize(new Dimension(800,30));
        titleBarPanel.setBackground(Color.decode("#000000"));
        
        frameButtonsPanel = new JPanel();
        apsLogoLabel = new JLabel(new ImageIcon(resource+"mtmLogo1.png"), JLabel.CENTER);
        resizeLabel = new JLabel(new ImageIcon(resource+"resize24.png"), JLabel.CENTER);
        minimizeLabel = new JLabel(new ImageIcon(resource+"minimize.png"), JLabel.CENTER);
        closeLabel = new JLabel(new ImageIcon(resource+"close1-24.png"), JLabel.CENTER);
        
        apsLogoLabel.setForeground(Color.decode("#FCFEFC"));
        apsLogoLabel.setHorizontalAlignment(JLabel.CENTER);
        apsLogoLabel.setFont(new Font("logo",Font.BOLD,15));
        
        resizeLabel.setOpaque(true);
        resizeLabel.setBackground(Color.decode("#000000"));
        resizeLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        resizeLabel.setMaximumSize(new Dimension(40,60));
        resizeLabel.setPreferredSize(new Dimension(40,60));
        resizeLabel.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                resizeLabel.setBackground(Color.decode("#202020"));
                resizeLabel.repaint();
            }
            @Override
            public void mouseExited(MouseEvent e){
                resizeLabel.setBackground(Color.decode("#000000"));
                resizeLabel.repaint();
            }
            @Override
            public void mouseClicked(MouseEvent e){
                resizeWindow();
            }  
        });
        
        minimizeLabel.setOpaque(true);
        minimizeLabel.setBackground(Color.decode("#000000"));
        minimizeLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        minimizeLabel.setMaximumSize(new Dimension(40,60));
        minimizeLabel.setPreferredSize(new Dimension(40,60));
        minimizeLabel.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                minimizeLabel.setBackground(Color.decode("#202020"));
                minimizeLabel.repaint();
            }
            @Override
            public void mouseExited(MouseEvent e){
                minimizeLabel.setBackground(Color.decode("#000000"));
                minimizeLabel.repaint();
            }
            @Override
            public void mouseClicked(MouseEvent e){
                minimizeWindow();
            }  
        });
        
        closeLabel.setOpaque(true);
        closeLabel.setBackground(Color.decode("#000000"));
        closeLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        closeLabel.setMaximumSize(new Dimension(40,Integer.MAX_VALUE));
        closeLabel.setPreferredSize(new Dimension(40,60));
        closeLabel.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                closeLabel.setBackground(Color.decode("#FC4344"));
                closeLabel.repaint();
            }
            @Override
            public void mouseExited(MouseEvent e){
                closeLabel.setBackground(Color.decode("#000000"));
                closeLabel.repaint();
            }
            @Override
            public void mouseClicked(MouseEvent e){
                System.exit(0);
            }  
        });
        
        frameButtonsPanel.setLayout(new BoxLayout(frameButtonsPanel, BoxLayout.X_AXIS));
        frameButtonsPanel.setMaximumSize(new Dimension(100, titleBarPanel.getHeight()));
        frameButtonsPanel.setPreferredSize(new Dimension(100, titleBarPanel.getHeight()));
        frameButtonsPanel.setBackground(Color.decode("#000000"));
        frameButtonsPanel.add(minimizeLabel);
        frameButtonsPanel.add(resizeLabel);
        frameButtonsPanel.add(closeLabel);
        
        
        titleBarPanel.add(apsLogoLabel, BorderLayout.CENTER);
        titleBarPanel.add(frameButtonsPanel, BorderLayout.EAST);
        //titlePanel.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.WHITE));
        
        //this.closeLabel.setBounds(frameButtonsPanel.getWidth()-40,7,32,32);
        //this.minimizeLabel.setBounds(frameButtonsPanel.getWidth()-62,9,32,32);
    }
    
    private JMenuItem createMenuItem(JMenuItem item, String iconName){
        item.setBackground(Color.decode("#000000"));
        //item.setBorder(BorderFactory.createMatteBorder(0,0,0,1,Color.decode("#202020")));
        item.setFont(new Font("Hall",Font.PLAIN,15));
        item.setForeground(Color.WHITE);
        item.setIconTextGap(7);
        item.setMaximumSize(new Dimension(Integer.MAX_VALUE,78));
        item.setPreferredSize(new Dimension(165,78));
        item.setIcon(new ImageIcon(resource+iconName));
        item.setMargin(new Insets(0,10,0,0));
        
        return item;
    }
    
    private void menuEvents(JMenuItem item, String iconName, String iconName2){
        item.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                item.setBackground(Color.decode("#202020"));
                item.setIcon(new ImageIcon(resource+iconName));
                item.setForeground(Color.decode("#FC4344"));
                item.repaint();
            }
            @Override
            public void mouseExited(MouseEvent e){
                item.setBackground(Color.decode("#000000"));
                item.setIcon(new ImageIcon(resource+iconName2));
                item.setForeground(Color.WHITE);
                item.repaint();
            }
            @Override
            public void mouseClicked(MouseEvent e){
                if(item.equals(dashboardMenu)){
                    optionsContentPanel.removeAll();
                    optionsContentPanel.add(dashboardPanel, BorderLayout.CENTER);
                    pack();
                    optionsContentPanel.repaint();
                }
                else if(item.equals(meetingMenu)){
                    
                }
                else if(item.equals(actionPlanMenu)){
                    optionsContentPanel.removeAll();
                    optionsContentPanel.add(actionPlanPanel, BorderLayout.CENTER);
                    pack();
                    optionsContentPanel.repaint();
                }
                else if(item.equals(teamMenu)){
                    
                }
            }
        }); 
    }
   
    private void createMainMenu(){ 
        mainMenu = new JMenuBar();
        dashboardMenu = new JMenuItem("DASHBOARD");
        meetingMenu = new JMenuItem("    MEETING");
        actionPlanMenu = new JMenuItem( "ACTION PLAN");
        teamMenu = new JMenuItem(   "       TEAM");
        profileMenu = new JMenuItem("    PROFILE");
        settingMenu = new JMenuItem("   SETTINGS");
        exitItem = new JMenuItem("        EXIT");
        
        mainMenu.setLayout(new BoxLayout(mainMenu, BoxLayout.PAGE_AXIS));
        mainMenu.setMaximumSize(new Dimension(165,Integer.MAX_VALUE));
        mainMenu.setPreferredSize(new Dimension(165,600));
        mainMenu.setMinimumSize(new Dimension(50,50));
        mainMenu.setBackground(Color.decode("#000000"));
        mainMenu.setBorder(BorderFactory.createMatteBorder(0,0,0,1,Color.decode("#202020")));
        
        mainMenu.add(createMenuItem(dashboardMenu, "dash.png"));
        mainMenu.add(createMenuItem(meetingMenu, "meeting.png"));
        mainMenu.add(createMenuItem(actionPlanMenu, "action.png"));
        mainMenu.add(createMenuItem(teamMenu, "team.png"));
        mainMenu.add(createMenuItem(profileMenu, "profile.png"));
        mainMenu.add(Box.createVerticalGlue());
        mainMenu.add(createMenuItem(settingMenu, "setting.png"));
        settingMenu.setMargin(new Insets(0,10,5,0));
        
        menuEvents(dashboardMenu, "dash2.png", "dash.png");
        menuEvents(meetingMenu, "meeting2.png", "meeting.png");
        menuEvents(actionPlanMenu, "action2.png", "action.png");
        menuEvents(teamMenu, "team2.png", "team.png");
        menuEvents(profileMenu, "profile2.png", "profile.png");
        menuEvents(settingMenu, "setting2.png", "setting.png");        
        
    }
    
    private void createOptionsContentPanel(){
        optionsContentPanel = new JPanel();
        optionsContentPanel.setBackground(Color.decode("#FCFEFC"));
        optionsContentPanel.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
        optionsContentPanel.setPreferredSize(new Dimension(700,600));
        optionsContentPanel.setSize(optionsContentPanel.getPreferredSize());
        optionsContentPanel.setLayout(new BorderLayout());
        
        createDashboardPanel();
        createActionPlanPanel();
        
        //initImageLabel = new JLabel(new ImageIcon(resource+"holcim-logo.png"));
        //initImageLabel.setPreferredSize(new Dimension(500,328));
        //initImageLabel.setSize(initImageLabel.getPreferredSize());
        //optionsContentPanel.add(initImageLabel,BorderLayout.CENTER);
        //optionsContentPanel.add(titleBarPanel, BorderLayout.NORTH);
        //pack();
                
    }
    
    private void createDashboardPanel(){
        dashboardPanel = new JPanel();
        dashboardPanel.setLayout(new BorderLayout());
        dashboardPanel.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
        dashboardPanel.setBackground(Color.decode("#FCFEFC"));
        
        initImageLabel = new JLabel(new ImageIcon(resource+"holcim-logo.png"), JLabel.CENTER);
        initImageLabel.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
        initImageLabel.setPreferredSize(new Dimension(500,328));
        initImageLabel.setBackground(Color.decode("#FCFEFC"));
        
        dashboardPanel.add(initImageLabel,BorderLayout.CENTER);
        
    }
    
    private void createActionPlanPanel(){
        actionPlanPanel = new JPanel();
        actionPlanPanel.setLayout(new BorderLayout());
        actionPlanPanel.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
        actionPlanPanel.setBackground(Color.decode("#FCFEFC"));
        
        JLabel p = new JLabel(new ImageIcon(resource+"movie-reels-and-popcorn.png"), JLabel.CENTER);
        p.setMaximumSize(new Dimension(Short.MAX_VALUE,Short.MAX_VALUE));
        p.setPreferredSize(new Dimension(500,328));
        p.setBackground(Color.decode("#FCFEFC"));
        
        actionPlanPanel.add(p, BorderLayout.CENTER);
        
    }
    
    private void minimizeWindow(){
        this.setState(ICONIFIED);
    }
    
    private void resizeWindow(){
        if(!resizeFlag){
            Dimension d = this.getMinimumSize();
            this.setPreferredSize(this.getMinimumSize());
            xPosition = (nativeScreenSize.width/2)-(d.width/2);
            yPosition = (nativeScreenSize.height/2)-(d.height/2);
            this.setLocation(xPosition,yPosition);
            pack();
            resizeFlag = true;
        }
        else{ // Restoring statements
            this.setLocation(0,0);
            this.setPreferredSize(nativeScreenSize);
            this.setExtendedState(JFrame.MAXIMIZED_BOTH);
            revalidate();
            resizeFlag = false;
        }
    }
    
    private void moveWindow(){
        
    }
    
    public JFrame getJFrame(){
        return this;
    }

}
