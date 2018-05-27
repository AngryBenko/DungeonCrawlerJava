//import javax.swing.*;
import javax.swing.*;

import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;

public class TitleScreen {
    private JPanel titleNamePanel, menuButtonPanel, backgroundPanel;
    private JLabel titleNameLabel, titleShadowLabel, backgroundLabel, backgroundLabel2;

    //private final String menuNames[] = {"START", "EXIT"};
    private final String menuNames[] = {"START", "EXIT"};
    private final JButton menuButtons[] = new JButton[menuNames.length];

    private final Font titleFont = new Font("Copperplate Gothic Bold", Font.PLAIN, 50);
    private final Font menuFontHover = new Font("Copperplate Gothic Bold", Font.PLAIN, 24);
    private final Font menuFont = new Font("Copperplate Gothic Bold", Font.PLAIN, 14);

    public TitleScreen(GameController.TitleScreenHandler tsHandler) {
        init(tsHandler);
    }

    private void init(GameController.TitleScreenHandler tsHandler) {
        initJPanels();
        initJLabels();
        initJButtons(tsHandler);
    }

    private void initJPanels() {
        titleNamePanel = new JPanel(null);
        titleNamePanel.setBounds(0, 100, 800, 100); // setBounds(x,y,width,height);
        titleNamePanel.setBackground(Color.blue);
        titleNamePanel.setOpaque(false);

        // Any menu buttons that exist will be under one panel for organization and rendering purposes
        // also reduces the ned for additional panels per button
        menuButtonPanel = new JPanel();
        menuButtonPanel.setBounds(300, 300, 200, 150);
        menuButtonPanel.setBackground(Color.green);
        menuButtonPanel.setOpaque(false);
        menuButtonPanel.setLayout(new GridLayout(2, 1, 0, 20)); // GridLayout(row, col, colgap, rowgap);

        backgroundPanel = new JPanel(null);
        backgroundPanel.setBounds(0, 0, 800, 600);
        backgroundPanel.setBackground(Color.orange);
        backgroundPanel.setOpaque(false);
    }

    private void initJLabels() {
        titleNameLabel = new JLabel("Dungeon Crawler");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);
        titleNameLabel.setBounds(135, 0, 800, 100);
        titleNamePanel.add(titleNameLabel);

        titleShadowLabel = new JLabel("Dungeon Crawler");
        titleShadowLabel.setForeground(Color.black);
        titleShadowLabel.setFont(titleFont);
        titleShadowLabel.setBounds(143, 5, 800, 100);
        titleNamePanel.add(titleShadowLabel);

        backgroundLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("res/background/bg_title.gif")));
        backgroundLabel.setBounds(0, 0, 800, 350);
        backgroundPanel.add(backgroundLabel);

        backgroundLabel2 = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("res/background/bg_title_bottom.png")));
        backgroundLabel2.setBounds(0, 350, 800, 250);
        backgroundPanel.add(backgroundLabel2);
    }

    private void initJButtons(GameController.TitleScreenHandler tsHandler) {
        // Creating menu buttons which will be added to a panel later
        // Many buttons contained by one panel share common properties
        // Also reduces the amount of code needed to make multiple buttons
        for (int i = 0; i < menuButtons.length; i++) {
            JButton btn = new JButton(menuNames[i]);
            btn.setActionCommand(menuNames[i]);
            btn.addActionListener(tsHandler);
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
                                 });
            //btn.setBorder(null);
            btn.setBackground(Color.darkGray);
            btn.setForeground(Color.white);
            btn.setFont(menuFont);
            btn.setFocusPainted(false);
            btn.setOpaque(false);
            btn.setBorderPainted(false);
            menuButtons[i] = btn;
            menuButtonPanel.add(menuButtons[i]);
        }
    }
    public JPanel getBackgroundPanel() { return backgroundPanel; }
    public JPanel getTitleNamePanel() { return titleNamePanel; }
    public JPanel getMenuButtonPanel() { return menuButtonPanel; }

    public void setVisible(boolean value) {
        backgroundPanel.setVisible(value);
        titleNamePanel.setVisible(value);
        menuButtonPanel.setVisible(value);
    }
}
