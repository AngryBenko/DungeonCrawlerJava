import javax.swing.*;


import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.border.LineBorder;

public class DungeonSelect {
    private boolean wait = true;
    private JPanel dSelectNamePanel, dSelectButtonPanel, backgroundPanel, dSelectExitPanel, dSelectEnterPanel;
    private JLabel dSelectNameLabel, dSelectShadowLabel, dSelectBackground;
    private JButton dsEnter, dsExit, selectedButton;

    private final String dSizeNames[] = {"Small", "Medium", "Large"};
    private final JButton dSizeButtons[] = new JButton[dSizeNames.length];

    private final Font titleFont = new Font("Copperplate Gothic Bold", Font.PLAIN, 50);
    private final Font menuFont = new Font("Copperplate Gothic Bold", Font.PLAIN, 15);
    private final Font menuFontHover = new Font("Copperplate Gothic Bold", Font.PLAIN, 24);

    public DungeonSelect(GameController.DungeonSelectHandler dsHandler) {
        init(dsHandler);
    }

    private void init(GameController.DungeonSelectHandler dsHandler) {
        initJPanels();
        initJLabels();
        initJButtons(dsHandler);
    }

    private void initJPanels() {
        //name panel
        dSelectNamePanel = new JPanel(null);
        dSelectNamePanel.setBounds(0, 100, 800, 100); // setBounds(x,y,width,height);
        dSelectNamePanel.setBackground(Color.blue);
        dSelectNamePanel.setOpaque(false);

        //change size panels
        dSelectButtonPanel = new JPanel();
        dSelectButtonPanel.setBounds(300, 300, 200, 150);
        dSelectButtonPanel.setBackground(Color.green);
        dSelectButtonPanel.setLayout(new GridLayout(3, 1, 0, 20)); // GridLayout(row, col, colgap, rowgap);
        dSelectButtonPanel.setOpaque(false);

        //enter panel
        dSelectEnterPanel = new JPanel();
        dSelectEnterPanel.setBounds(655,525,100,45);
        dSelectEnterPanel.setBackground(Color.magenta);
        dSelectEnterPanel.setOpaque(false);

        //exit panel
        dSelectExitPanel = new JPanel();
        dSelectExitPanel.setBounds(50,525,80,35);
        dSelectExitPanel.setBackground(Color.orange);
        dSelectExitPanel.setOpaque(false);

        //background
        backgroundPanel = new JPanel(null);
        backgroundPanel.setBounds(0, 0, 800, 600);
        backgroundPanel.setBackground(Color.black);
        backgroundPanel.setOpaque(false);
    }

    private void initJLabels() {
        //background label
        dSelectBackground = new JLabel();
        dSelectBackground.setBounds(0, 0, 800, 600);
        //ImageIcon backgroundImg = new ImageIcon(getClass().getClassLoader().getResource("res/background/industrialBackground.png"));
        dSelectBackground.setIcon(new ImageIcon(getClass().getClassLoader().getResource("res/background/industrialBackground.png")));
        backgroundPanel.add(dSelectBackground);

        //title label
        dSelectNameLabel = new JLabel("Select the Dungeon Size");
        dSelectNameLabel.setForeground(Color.white);
        dSelectNameLabel.setFont(titleFont);
        dSelectNameLabel.setBounds(50, 0, 800, 100);
        dSelectNamePanel.add(dSelectNameLabel);

        //title shadow label
        dSelectShadowLabel = new JLabel("Select the Dungeon Size");
        dSelectShadowLabel.setForeground(Color.black);
        dSelectShadowLabel.setFont(titleFont);
        dSelectShadowLabel.setBounds(58, 5, 800, 100);
        dSelectNamePanel.add(dSelectShadowLabel);
    }

    private void initJButtons(GameController.DungeonSelectHandler dsHandler) {
        selectedButton = new JButton();

        //size buttons
        for (int i = 0; i < dSizeButtons.length; i++) {
            JButton btn = new JButton(dSizeNames[i]);
            btn.setActionCommand(dSizeNames[i]);
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
            btn.setBorder(new LineBorder(Color.GREEN));
            btn.setBackground(Color.darkGray);
            btn.setForeground(Color.white);
            btn.setFont(menuFont);
            btn.setFocusPainted(false);
            btn.setOpaque(false);
            dSizeButtons[i] = btn;
            dSelectButtonPanel.add(dSizeButtons[i]);
        }

        //enter button
        dsEnter = new JButton("Embark");
        dsEnter.setActionCommand("embark");
        dsEnter.addActionListener(dsHandler);
        dsEnter.setBorderPainted(false);
        dsEnter.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dsEnter.setFont(menuFontHover);
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dsEnter.setFont(menuFont);
            }
        });
        dsEnter.setBackground(Color.darkGray);
        dsEnter.setForeground(Color.white);
        dsEnter.setFont(menuFont);
        dsEnter.setFocusPainted(false);
        dsEnter.setOpaque(false);
        dSelectEnterPanel.add(dsEnter);

        //exit button
        dsExit = new JButton("Back");
        dsExit.setActionCommand("back");
        dsExit.addActionListener(dsHandler);
        dsExit.setBorderPainted(false);
        dsExit.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dsExit.setFont(menuFontHover);
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dsExit.setFont(menuFont);
            }
        });
        dsExit.setBackground(Color.darkGray);
        dsExit.setForeground(Color.white);
        dsExit.setFont(menuFont);
        dsExit.setFocusPainted(false);
        dsExit.setOpaque(false);
        dSelectExitPanel.add(dsExit);
    }
    public void setWait(boolean input) { wait = input; }
    public boolean getWait() { return wait; }
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
