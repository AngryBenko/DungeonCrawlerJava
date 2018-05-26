import Entities.*;

import javax.swing.*;
import java.awt.*;
import javax.imageio.*;
import javax.swing.border.LineBorder;


public class Party {
    private boolean wait = true;
    private JPanel partyNamePanel, partyIconPanel, partyChosenPanel, partyEnterPanel, partyExitPanel, backgroundPanel;
    private JLabel partyNameLabel, partyBackground;
    private JButton pEnter, pExit;
    private final int partySize = 1;

    public String selectedParty[] = new String[partySize];
    private int counter = 0;

    public String charIcons[] = {"barbarian1.png", "barbarian2.png", "beard.png", "knight_gold.png", "knight1.png", "mage_fire.png", "maniac1.png", "oldman.png"};


    private final String partyChosenNames[] = {"pos1", "pos2", "pos3", "pos4"};
    private final JButton partyChosenButtons[] = new JButton[partySize];

    private final String partyIconNames[] = {"num1", "num2", "num3", "num4", "num5", "num6", "num7", "num8"};
    private final JButton partyIconButtons[] = new JButton[partyIconNames.length];

    private final Font titleFont = new Font("Copperplate Gothic Bold", Font.PLAIN, 50);
    private final Font menuFont = new Font("Copperplate Gothic Bold", Font.PLAIN, 14);
    private final Font menuFontHover = new Font("Copperplate Gothic Bold", Font.PLAIN, 24);

    private Entity charParty[] = new Entity[partySize];

    public Party(GameController.PartyHandler pHandler) {
        init(pHandler);
    }

    private void init(GameController.PartyHandler pHandler) {
        initJPanels();
        initJLabels();
        initJButtons(pHandler);
    }
    private void initJPanels() {
        //creating the name that is shown on the top of the screen
        partyNamePanel = new JPanel();
        partyNamePanel.setBounds(0, 0, 800, 100); // setBounds(x,y,width,height);
        partyNamePanel.setBackground(Color.black);
        partyNamePanel.setOpaque(false);

        //enter dungeon panel
        partyEnterPanel = new JPanel();
        partyEnterPanel.setBounds(650, 525, 120, 50);
        partyEnterPanel.setBackground(Color.BLACK);
        partyEnterPanel.setOpaque(false);

        //exit to hub
        partyExitPanel = new JPanel();
        partyExitPanel.setBounds(50, 525, 80, 35);
        partyExitPanel.setBackground(Color.BLACK);
        partyExitPanel.setOpaque(false);

        //chosen character
        partyChosenPanel = new JPanel();
        partyChosenPanel.setBounds(200, 100, 400, 80);
        partyChosenPanel.setBackground(Color.black);
        partyChosenPanel.setLayout(new GridLayout(1, 4, 26, 0));
        partyChosenPanel.setOpaque(false);

        //all possible characters
        partyIconPanel = new JPanel();
        partyIconPanel.setBounds(100, 200, 600, 300);
        partyIconPanel.setBackground(Color.black);
        partyIconPanel.setLayout(new GridLayout(2, 4, 0, 0));
        partyIconPanel.setOpaque(false);

        //background
        backgroundPanel = new JPanel(null);
        backgroundPanel.setBounds(0, 0, 800, 600);
        backgroundPanel.setBackground(Color.black);
        backgroundPanel.setOpaque(false);
    }

    private void initJLabels() {
        //title
        partyNameLabel = new JLabel("Choose your Fighter");
        partyNameLabel.setForeground(Color.white);
        partyNameLabel.setFont(titleFont);
        partyNameLabel.setBounds(135, 0, 800, 100);
        partyNamePanel.add(partyNameLabel);

        //background
        partyBackground = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("res/background/pBackground.gif")));
        partyBackground.setBounds(0, 0, 800, 600);
        backgroundPanel.add(partyBackground);
    }

    private void initJButtons(GameController.PartyHandler pHandler) {
        //enter dungeon
        pEnter = new JButton("<html>Select<br/>Dungeon</html>");
        pEnter.setActionCommand("enter");
        pEnter.addActionListener(pHandler);
        pEnter.setBackground(Color.black);
        pEnter.setForeground(Color.white);
        pEnter.setOpaque(false);
        pEnter.setFont(menuFont);
        pEnter.setFocusPainted(false);
        partyEnterPanel.add(pEnter);

        //exit to hub
        pExit = new JButton("Back");
        pExit.setActionCommand("back");
        pExit.addActionListener(pHandler);
        pExit.setBackground(Color.black);
        pExit.setForeground(Color.white);
        pExit.setOpaque(false);
        pExit.setFont(menuFont);
        pExit.setFocusPainted(false);
        partyExitPanel.add(pExit);

        //party chosen buttons
        for (int i = 0; i < partyChosenButtons.length; i++) {
            JButton btn = new JButton("?");
            //if(counter == i)
            //    btn.setBorder(new LineBorder(Color.RED));
            btn.setBorderPainted(false);
            btn.setActionCommand("pos" + i);
            btn.addActionListener(pHandler);
            btn.setBackground(Color.black);
            btn.setForeground(Color.white);
            btn.setOpaque(false);
            btn.setFont(menuFont);
            btn.setFocusPainted(false);
            partyChosenButtons[i] = btn;
            partyChosenPanel.add(partyChosenButtons[i]);
        }

        //char list
        for (int i = 0; i < partyIconButtons.length; i++) {
            JButton btn = new JButton();
            ImageIcon icon2 = new ImageIcon(getClass().getClassLoader().getResource("res/entity/characters/" + charIcons[i]));
            btn.setIcon(icon2);
            btn.setActionCommand("num" + i);
            btn.addActionListener(pHandler);

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
            btn.setBorderPainted(false);
            btn.setOpaque(false);
            btn.setBackground(Color.black);
            btn.setForeground(Color.white);
            btn.setFont(menuFont);
            btn.setFocusPainted(false);
            partyIconButtons[i] = btn;
            partyIconPanel.add(partyIconButtons[i]);
        }
    }

    public JPanel getPartyNamePanel() { return partyNamePanel; }
    public JPanel getPartyChosenPanel() { return partyChosenPanel; }
    public JPanel getPartyIconPanel() { return partyIconPanel; }
    public JPanel getPartyEnterPanel() { return partyEnterPanel; }
    public JPanel getPartyExitPanel() { return partyExitPanel; }
    public JPanel getPartyBackgroundPanel() { return backgroundPanel; }
    private void setWait(boolean wait) { this.wait = wait; }
    public boolean getWait() { return this.wait; }

    public void setVisible(boolean value) {
        partyNamePanel.setVisible(value);
        partyChosenPanel.setVisible(value);
        partyIconPanel.setVisible(value);
        partyEnterPanel.setVisible(value);
        partyExitPanel.setVisible(value);
        backgroundPanel.setVisible(value);
    }

    public boolean checkParty(int i) {
        if(selectedParty[i] == "")
            return false;
        return true;
    }


    // passparty to dungeon
    public Entity[] passParty() {
        return charParty;
    }

    public void clearParty(GameController.PartyHandler pHandler) {
        selectedParty = new String[selectedParty.length];
        counter = 0;
        updateIcons(pHandler);
    }

    public void setParty(int i,GameController.PartyHandler pHandler) {
        setWait(false);
        selectedParty[counter] = "res/entity/characters/" + charIcons[i];
        switch (i) {
            case 0:
                charParty[counter] = new Barb();
                break;
            case 1:
                charParty[counter] = new Barb2();
                break;
            case 2:
                charParty[counter] = new Beard();
                break;
            case 3:
                charParty[counter] = new GoldKnight();
                break;
            case 4:
                charParty[counter] = new Knight1();
                break;
            case 5:
                charParty[counter] = new FireMage();
                break;
            case 6:
                charParty[counter] = new Maniac1();
                break;
            case 7:
                charParty[counter] = new OldMan();
                break;
            default:
                break;
        }
        counter++;
        if(counter == partySize) { // counter determines which slot if being selected
            counter = 0;
        }
        updateIcons(pHandler);
    }

    public void setPartySlot(int i, GameController.PartyHandler pHandler) {
        counter = i;
        updateIcons(pHandler);
    }

    public void updateIcons(GameController.PartyHandler pHandler) {
        ImageIcon icon;
        partyChosenPanel.removeAll();
        for(int i = 0; i < selectedParty.length; i++) {
            JButton btn;
            // selectedParty[i] is the chosen character
            if(selectedParty[i] != null) {
                btn = new JButton();
                icon = new ImageIcon(getClass().getClassLoader().getResource(selectedParty[i]));
                btn.setIcon(icon);
            }
            else {
                btn = new JButton("?");
            }
            if(i == counter) {
                //btn.setBorder(new LineBorder(Color.RED));
            }
            btn.setBorderPainted(false);
            btn.setActionCommand("pos" + i);
            btn.addActionListener(pHandler);
            btn.setBackground(Color.black);
            btn.setForeground(Color.white);
            btn.setFont(menuFont);
            btn.setOpaque(false);
            btn.setFocusPainted(false);
            partyChosenButtons[i] = btn;
            partyChosenPanel.add(partyChosenButtons[i]);
        }
    }
}
