import javax.swing.*;


import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.border.LineBorder;

public class DungeonSelect {
    private JPanel dSelectNamePanel, dSelectButtonPanel, backgroundPanel, dSelectExitPanel, dSelectEnterPanel;
    private JLabel dSelectNameLabel, dSelectBackground;
    private JButton dsEnter, dsExit, selectedButton;


    private final String dSizeNames[] = {"3", "5", "8"};
    private final JButton dSizeButtons[] = new JButton[dSizeNames.length];

    private final Font titleFont = new Font("Copperplate Gothic Bold", Font.PLAIN, 50);
    private final Font menuFont = new Font("Copperplate Gothic Bold", Font.PLAIN, 15);
    private final Font menuFontHover = new Font("Copperplate Gothic Bold", Font.PLAIN, 24);

    public DungeonSelect(GameController.DungeonSelectHandler dsHandler) {
        init(dsHandler);
    }

    private void init(GameController.DungeonSelectHandler dsHandler) {
        //creating background
        backgroundPanel = new JPanel();
        backgroundPanel.setBounds(0, 0, 800, 600);
        backgroundPanel.setBackground(Color.black);
        dSelectBackground = new JLabel();
        dSelectBackground.setBounds(0, 0, 800, 600);
        ImageIcon backgroundImg = new ImageIcon(getClass().getClassLoader().getResource("res/background/dsBackground.png"));
        dSelectBackground.setIcon(backgroundImg);
        backgroundPanel.add(dSelectBackground);

        //creating the name that is shown on the top of the screen
        dSelectNamePanel = new JPanel();
        dSelectNamePanel.setBounds(0, 100, 800, 100); // setBounds(x,y,width,height);
        dSelectNamePanel.setBackground(Color.black);
        dSelectNamePanel.setOpaque(false);
        dSelectNameLabel = new JLabel("Select the Dungeon Size");
        dSelectNameLabel.setForeground(Color.white);
        dSelectNameLabel.setFont(titleFont);
        dSelectNamePanel.add(dSelectNameLabel);

        //buttons to choose size plus to enter the dungeon/go back (sizes 3, 5, 8)
        dSelectButtonPanel = new JPanel();
        dSelectButtonPanel.setBounds(300, 300, 200, 150);
        dSelectButtonPanel.setBackground(Color.black);
        dSelectButtonPanel.setLayout(new GridLayout(3, 1, 0, 0)); // GridLayout(row, col, colgap, rowgap);
        dSelectButtonPanel.setOpaque(false);
        selectedButton = new JButton();

        //creating the buttons for the dungeon sizes
        //gets added to the dSelectButtonPanel
        for (int i = 0; i < dSizeButtons.length; i++) {
            JButton btn = new JButton(dSizeNames[i]);
            btn.setActionCommand("size" + i);
            btn.addActionListener(dsHandler);

            btn.setBorderPainted(false);
            // implementing mouselistener to have hover effects
            btn.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    btn.setFont(menuFontHover);
                }
                @Override
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    btn.setFont(menuFont);
                }
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    selectedButton.setBorderPainted(false);
                    selectedButton = btn;
                    selectedButton.setBorderPainted(true);
                }
            });
            btn.setBorder(new LineBorder(Color.RED));
            btn.setBackground(Color.darkGray);
            btn.setForeground(Color.white);
            btn.setFont(menuFont);
            btn.setFocusPainted(false);
            btn.setOpaque(false);
            dSizeButtons[i] = btn;
            dSelectButtonPanel.add(dSizeButtons[i]);
        }

        //button to enter the dungeon
        dSelectEnterPanel = new JPanel();
        dSelectEnterPanel.setBounds(700,525,80,45);
        dSelectEnterPanel.setBackground(Color.BLACK);
        dSelectEnterPanel.setOpaque(false);
        dsEnter = new JButton("<html>Enter<br/>Dungeon</html>");
        dsEnter.setActionCommand("enter");
        dsEnter.addActionListener(dsHandler);
        dsEnter.setBorderPainted(false);
        dsEnter.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dsEnter.setBorder(new LineBorder(Color.YELLOW));
                dsEnter.setBorderPainted(true);
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dsEnter.setBorder(new LineBorder(Color.WHITE));
                dsEnter.setBorderPainted(false);
            }
        });
        dsEnter.setBackground(Color.darkGray);
        dsEnter.setForeground(Color.white);
        dsEnter.setFont(menuFont);
        dsEnter.setFocusPainted(false);
        dsEnter.setOpaque(false);
        dSelectEnterPanel.add(dsEnter);

        //button to exit dungeon select (goes back to party select)
        dSelectExitPanel = new JPanel();
        dSelectExitPanel.setBounds(50,525,80,35);
        dSelectExitPanel.setBackground(Color.BLACK);
        dSelectExitPanel.setOpaque(false);
        dsExit = new JButton("Back");
        dsExit.setActionCommand("back");
        dsExit.addActionListener(dsHandler);
        dsExit.setBorderPainted(false);
        dsExit.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dsExit.setBorder(new LineBorder(Color.YELLOW));
                dsExit.setBorderPainted(true);
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dsExit.setBorder(new LineBorder(Color.WHITE));
                dsExit.setBorderPainted(false);
            }
        });
        dsExit.setBackground(Color.darkGray);
        dsExit.setForeground(Color.white);
        dsExit.setFont(menuFont);
        dsExit.setFocusPainted(false);
        dsExit.setOpaque(false);
        dSelectExitPanel.add(dsExit);
    }

    //functions to return panels
    public JPanel getDSBackgroundPanel() { return backgroundPanel; }
    public JPanel getDSNamePanel() { return dSelectNamePanel; }
    public JPanel getDSButtonPanel() { return dSelectButtonPanel; }
    public JPanel getDSEnterPanel() { return dSelectEnterPanel; }
    public JPanel getDSExitPanel() { return dSelectExitPanel; }

    //to show panels or not
    public void setVisible(boolean value) {
        dSelectNamePanel.setVisible(value);
        dSelectButtonPanel.setVisible(value);
        backgroundPanel.setVisible(value);
        dSelectEnterPanel.setVisible(value);
        dSelectExitPanel.setVisible(value);
    }
}
