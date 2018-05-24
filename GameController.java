// TODO create a player class
// TODO work on an inventory system, possibly interacts with a player class?

import Entities.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

// TODO adjust all x, y, width, and height values accoring to DISPLAY_WIDTH and DISPLAY_HEIGHT
public class GameController extends JFrame {
    private final int DISPLAY_WIDTH;
    private final int DISPLAY_HEIGHT;

    private final TitleScreenHandler tsHandler = new TitleScreenHandler();
    private final CentralHubHandler chHandler = new CentralHubHandler();
    private final ActionButtonHandler abHandler = new ActionButtonHandler();
    private final PartyHandler pHandler = new PartyHandler();

    private TitleScreen tS = new TitleScreen(tsHandler);
    private CentralHub cH = new CentralHub(chHandler);
    private Dungeon dungeon = new Dungeon(abHandler);
    private Party p = new Party(pHandler);

    public GameController(int width, int height) {
        DISPLAY_WIDTH = width;
        DISPLAY_HEIGHT = height;
        init();
    }

    private void init() {
        setSize(DISPLAY_WIDTH, DISPLAY_HEIGHT);
        System.out.println(getSize());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.black);
        setLayout(null);
        setResizable(false);
        getContentPane().setPreferredSize(new Dimension(DISPLAY_WIDTH, DISPLAY_HEIGHT));
        pack();
        setVisible(true);

        initMenu();
        displayTS(true);
        updateDungeon(false);
    }

    private void initMenu() {
        add(tS.getTitleNamePanel());
        add(tS.getMenuButtonPanel());
        add(tS.getBackgroundPanel());
    }

    private void initHub() {
        add(cH.getHubNamePanel());
        add(cH.getHubButtonPanel());
        add(cH.getHubBackgroundPanel());
    }

    public void initDungeon() {
        dungeon.initDungeon();
        add(dungeon.getExitPanel());
        add(dungeon.getNextPanel());
        add(dungeon.getLogPanel());
        add(dungeon.getMapPanel());
        add(dungeon.getMapBGPanel());
        add(dungeon.getChoiceButtonPanel());
        add(dungeon.getChoicePanel());
        add(dungeon.getCharPanel());
        add(dungeon.getEnemyPanel());
        add(dungeon.getDungeonPanel());
    }

    private void initParty() {
        add(p.getPartyNamePanel());
        add(p.getPartyChosenPanel());
        add(p.getPartyIconPanel());
    }
    private void displayTS(boolean value) {
        tS.setVisible(value);
        render();
    }

    private void displayCH(boolean value) {
        if(value)
            initHub();
        cH.setVisible(value);
        render();
    }

    private void displayP(boolean value) {
        if(value)
            initParty();
        p.setVisible(value);
        render();
    }

    // updateDungeon() with 1 parameter is for creating the dungeon itself
    // TODO could combine the two overloaded functions into one(priority: low)
    private void updateDungeon(boolean value) {
        if(value)
            initDungeon();
        dungeon.setVisible(value);
        render();
    }

    // updateDungeon() with 2 parameters is to handle cases within the dungeon itself
    private void updateDungeon(boolean value, int num) {
        dungeon.setVisible(value);
        switch(num) {
            case 0: // "default" case, reset any progressed content ie. minimap, room, enemies, characters
                dungeon.reset();
                break;
            case 1: // cleared room
                dungeon.updateMiniMap();
                dungeon.setWait(true);
                break;
            case 2: // next pressed
                dungeon.resetCombatLog();
                dungeon.nextRoom();
                dungeon.setWait(false);
                break;
            case 3: // dungeon complete
                dungeon.updateMiniMap();
                dungeon.setWait(true);
                dungeon.displayExit();
            case 4:
                break;
            default: break;
        }
        render();
    }

    private void render() {
        revalidate();
        repaint();
    }
    
    public class TitleScreenHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            String yourChoice = event.getActionCommand();
            switch(yourChoice) {
                case "START":
                    /*
                    dungeon.setDungeonSize(0);
                    displayTS(false);
                    updateDungeon(true);*/
                    /* Working
                    System.out.println("Enter Hub");
                    displayTS(false);
                    displayCH(true);*/
                    System.out.println("Enter Hub");
                    displayTS(false);
                    displayCH(true);
                    break;
                case "Dungeon 3":
                    dungeon.setDungeonSize(3);
                    displayTS(false);
                    updateDungeon(true);
                    break;
                case "Dungeon 5":
                    dungeon.setDungeonSize(5);
                    displayTS(false);
                    updateDungeon(true);
                    break;
                case "EXIT" :
                    System.out.println("Closing game...");
                    System.exit(0);
                    break;
            }
        }
    }

    public class CentralHubHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            String yourChoice = event.getActionCommand();
            switch(yourChoice) {
                case "hub0":
                    System.out.println("Enter Party Select");
                    displayCH(false);
                    displayP(true);
                    break;
                case "hub1" :
                    System.out.println("Enter Store");
                    displayCH(false);
                    //displayStore(true);
                    System.exit(0);
                    break;
                case "hub2" :
                    System.out.println("Enter Menu");
                    displayCH(false);
                    displayTS(true);
                    break;
            }
        }
    }

    public class PartyHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            String yourChoice = event.getActionCommand();
            switch(yourChoice) {
                case "pos0":
                    System.out.println("First Position Selected");
                    p.setPartySlot(0, pHandler);
                    break;
                case "pos1" :
                    System.out.println("Second Position Selected");
                    p.setPartySlot(1, pHandler);
                    break;
                case "pos2" :
                    System.out.println("Third Position Selected");
                    p.setPartySlot(2, pHandler);
                    break;
                case "pos3" :
                    System.out.println("Forth Position Selected");
                    p.setPartySlot(3, pHandler);
                    break;
                case "num0" :
                    System.out.println("1st char selected");
                    p.setParty(0,pHandler);
                    break;
                case "num1" :
                    System.out.println("2nd char selected");
                    p.setParty(1,pHandler);
                    break;
                case "num2" :
                    System.out.println("3rd char selected");
                    p.setParty(2,pHandler);
                    break;
                case "num3" :
                    System.out.println("4th char selected");
                    p.setParty(3,pHandler);
                    break;
                case "num5" :
                    System.out.println("5th char selected");
                    p.setParty(5,pHandler);
                    break;
                case "num6" :
                    System.out.println("6th char selected");
                    p.setParty(6,pHandler);
                    break;
                case "Exit" :
                    System.out.println("Enter Hub");
                    p.clearParty(pHandler);
                    displayP(false);
                    displayCH(true);
                    break;
                case "Enter\nDungeon" :
                    System.out.println("Enter Dungeon");
                    dungeon.setParty(p.passParty());
                    dungeon.setDungeonSize(0);
                    String[] party = p.getParty();
                    for(int i = 0; i < party.length; i++)
                        System.out.println(party[i]);
                    displayP(false);
                    updateDungeon(true);
                    break;
            }
        }
    }

    public class ActionButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            String yourChoice = event.getActionCommand();
            switch(yourChoice) {
                case "Attack": // attack
                    if(!dungeon.getWait()) {
                        dungeon.setCombatText();
                    }
                    break;
                case "Heal": // item
                    if(!dungeon.getWait()) {
                        dungeon.setHealText();
                    }
                    break;
                case "Run": // Run
                    dungeon.setCleared(false);
                    updateDungeon(false, 0);
                    displayTS(true);
                    break;
                case "Punch": // punch
                    if(dungeon.isComplete()) {
                        System.out.println("DUNGEON COMPLETE!");
                    } else  {
                        System.out.println("DUNGEON IN PROGRESS!");
                    }
                    break;
                case "Kick": // kick
                    dungeon.getCleared();
                    break;
                case "Kamehameha": // Kamehameha
                    if(!dungeon.getWait()) {
                        dungeon.setCleared(true);
                        if(dungeon.isComplete()) {
                            updateDungeon(true, 3);
                        } else {
                            updateDungeon(true, 1);
                        }
                    }
                    break;
                case "nextRoom": // When "next room" is pressed, generate a new room, update minimap (All done in updateDungeon())
                    dungeon.setCleared(false);
                    updateDungeon(true, 2);
                    break;
                case "exitDungeon":
                    dungeon.setCleared(false);
                    updateDungeon(false, 0);
                    displayTS(true);
                    break;
                default: break;
            }
        }
    }
}
