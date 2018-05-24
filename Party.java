import Entities.*;

import javax.swing.*;
import java.awt.*;
import javax.imageio.*;
import javax.swing.border.LineBorder;


public class Party {
    private JPanel partyNamePanel, partyIconPanel, partyChosenPanel;
    private JLabel partyNameLabel;

    public String selectedParty[] = new String[4];
    private int counter = 0;

    public String charIcons[] = {"barbarian1.png", "barbarian2.png", "beard.png", "knight_gold.png", "knight1.png", "mage_fire.png", "maniac1.png", "oldman.png"};


    private final String partyChosenNames[] = {"pos1", "pos2", "pos3", "pos4"};
    private final JButton partyChosenButtons[] = new JButton[partyChosenNames.length];

    private final String partyIconNames[] = {"num1", "num2", "num3", "num4", "num5", "num6", "num7", "num8"};
    private final JButton partyIconButtons[] = new JButton[partyIconNames.length];

    private final Font titleFont = new Font("Copperplate Gothic Bold", Font.PLAIN, 50);
    private final Font menuFont = new Font("Copperplate Gothic Bold", Font.PLAIN, 24);


    // Testing player class
    private Entity charParty[] = new Entity[4];

    public Party(GameController.PartyHandler pHandler) {
        init(pHandler);
    }

    private void init(GameController.PartyHandler pHandler) {
        //Party Title Icon
        partyNamePanel = new JPanel();
        partyNamePanel.setBounds(0, 0, 800, 100); // setBounds(x,y,width,height);
        partyNamePanel.setBackground(Color.black);
        partyNameLabel = new JLabel("Make Your Party");
        partyNameLabel.setForeground(Color.white);
        partyNameLabel.setFont(titleFont);

        //Chosen Character Icons
        partyChosenPanel = new JPanel();
        partyChosenPanel.setBounds(200, 100, 400, 80);
        partyChosenPanel.setBackground(Color.black);
        partyChosenPanel.setLayout(new GridLayout(1, 4, 26, 0)); // GridLayout(row, col, colgap, rowgap);
        //ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource(""));
        // Creating menu buttons which will be added to a panel later
        // Many buttons contained by one panel share common properties
        // Also reduces the amount of code needed to make multiple buttons
        for (int i = 0; i < partyChosenButtons.length; i++) {
            JButton btn = new JButton("?");
            //btn.setIcon(icon);
            if(counter == i)
                btn.setBorder(new LineBorder(Color.RED));
            btn.setActionCommand("pos" + i);
            btn.addActionListener(pHandler);
            btn.setBackground(Color.black);
            btn.setForeground(Color.white);
            btn.setFont(menuFont);
            btn.setFocusPainted(false);
            partyChosenButtons[i] = btn;
            partyChosenPanel.add(partyChosenButtons[i]);
        }

        //Possible Character Icons


        partyIconPanel = new JPanel();
        partyIconPanel.setBounds(100, 200, 600, 300);
        partyIconPanel.setBackground(Color.black);
        partyIconPanel.setLayout(new GridLayout(2, 4, 0, 0)); // GridLayout(row, col, colgap, rowgap);
        // Creating menu buttons which will be added to a panel later
        // Many buttons contained by one panel share common properties
        // Also reduces the amount of code needed to make multiple buttons
        for (int i = 0; i < partyIconButtons.length; i++) {
            JButton btn = new JButton(partyIconNames[i]);
            ImageIcon icon2 = new ImageIcon(getClass().getClassLoader().getResource("res/entity/characters/" + charIcons[i]));
            if(i != 7 && i != 4)
                btn.setIcon(icon2);

            btn.setActionCommand("num" + i);
            if(i == 7)
                btn.setActionCommand("Enter\nDungeon");
            else if(i == 4)
                btn.setActionCommand("Exit");
            btn.addActionListener(pHandler);
            btn.setBackground(Color.black);
            btn.setForeground(Color.white);
            btn.setFont(menuFont);
            btn.setFocusPainted(false);
            partyIconButtons[i] = btn;
            partyIconPanel.add(partyIconButtons[i]);
        }



        // Add labels/buttons to the panels
        partyNamePanel.add(partyNameLabel);

        // display the panels to the container
        //add(titleNamePanel);
        //add(menuButtonPanel);

        // Always revalidate and repaint JFrame when adding new components/panels
        // Similar to a update and render
    }
    public JPanel getPartyNamePanel() { return partyNamePanel; }
    public JPanel getPartyChosenPanel() { return partyChosenPanel; }
    public JPanel getPartyIconPanel() { return partyIconPanel; }

    public void setVisible(boolean value) {
        partyNamePanel.setVisible(value);
        partyChosenPanel.setVisible(value);
        partyIconPanel.setVisible(value);
    }

    public boolean checkParty(int i) {
        if(selectedParty[i] == "")
            return false;
        return true;
    }

    public String[] getParty() {
        return selectedParty;
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
        if(counter == 4) {
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
                btn = new JButton(selectedParty[i]);
                icon = new ImageIcon(getClass().getClassLoader().getResource(selectedParty[i]));
                btn.setIcon(icon);
            }
            else {
                btn = new JButton("?");
            }
            if(i == counter) {
                btn.setBorder(new LineBorder(Color.RED));
            }
            btn.setActionCommand("pos" + i);
            btn.addActionListener(pHandler);
            btn.setBackground(Color.black);
            btn.setForeground(Color.white);
            btn.setFont(menuFont);
            btn.setFocusPainted(false);
            partyChosenButtons[i] = btn;
            partyChosenPanel.add(partyChosenButtons[i]);
        }
        partyChosenPanel.revalidate();
        partyChosenPanel.repaint();
    }
}
