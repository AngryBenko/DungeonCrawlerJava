// TODO work on an inventory system, possibly interacts with a player class?

import Entities.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class GameController extends JFrame {
    private final int DISPLAY_WIDTH;
    private final int DISPLAY_HEIGHT;

    private final TitleScreenHandler tsHandler = new TitleScreenHandler();
    private final CentralHubHandler chHandler = new CentralHubHandler();
    private final ActionButtonHandler abHandler = new ActionButtonHandler();
    private final PartyHandler pHandler = new PartyHandler();
    private final DungeonSelectHandler dsHandler = new DungeonSelectHandler();
    private final PopupActionListener popHandler = new PopupActionListener();

    private TitleScreen tS = new TitleScreen(tsHandler);
    private CentralHub cH = new CentralHub(chHandler);
    private Dungeon dungeon = new Dungeon(abHandler);
    private Party p = new Party(pHandler);
    private DungeonSelect ds = new DungeonSelect(dsHandler);

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
        dungeon.generateCharAtk(popHandler);
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
    private void initDungeonSelect() {
        add(ds.getDSNamePanel());
        add(ds.getDSButtonPanel());
        add(ds.getDSEnterPanel());
        add(ds.getDSExitPanel());
        add(ds.getDSBackgroundPanel());
    }
    private void initParty() {
        add(p.getPartyNamePanel());
        add(p.getPartyChosenPanel());
        add(p.getPartyIconPanel());
        add(p.getPartyEnterPanel());
        add(p.getPartyExitPanel());
        add(p.getPartyBackgroundPanel());
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
    private void displayDS(boolean value) {
        if(value)
            initDungeonSelect();
        ds.setVisible(value);
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
                dungeon.displayNext();
                break;
            case 2: // next pressed
                dungeon.resetCombatLog();
                dungeon.nextRoom();
                dungeon.generateCharAtk(popHandler);
                dungeon.setWait(false);
                break;
            case 3: // dungeon complete
                dungeon.updateMiniMap();
                dungeon.setWait(true);
                dungeon.displayExit();
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
                    System.out.println("Enter Hub");
                    displayTS(false);
                    displayCH(true);
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
                case "PARTY":
                    System.out.println("Enter Party Select");
                    displayCH(false);
                    displayP(true);
                    break;
                case "BACK" :
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
                case "num4":
                    System.out.println("5th char selected");
                    p.setParty(4, pHandler);
                    break;
                case "num5" :
                    System.out.println("6th char selected");
                    p.setParty(5,pHandler);
                    break;
                case "num6" :
                    System.out.println("7th char selected");
                    p.setParty(6,pHandler);
                    break;
                case "num7":
                    System.out.println("8th char selected");
                    p.setParty(7,pHandler);
                    break;
                case "back" :
                    System.out.println("Enter Hub");
                    p.clearParty(pHandler);
                    displayP(false);
                    displayCH(true);
                    break;
                case "enter" :
                    if(!p.getWait()) {
                        System.out.println("Enter Dungeon");
                        dungeon.setParty(p.passParty());
                        displayP(false);
                        displayDS(true);
                    }
                    break;
                default:
                    break;
            }
            render();
        }
    }

    public class DungeonSelectHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            String yourChoice = event.getActionCommand();
            switch(yourChoice) {
                case "Small":
                    System.out.println("Dungeon Size 3 Selected");
                    dungeon.setDungeonSize(3);
                    ds.setWait(false);
                    break;
                case "Medium" :
                    System.out.println("Dungeon Size 5 Selected");
                    dungeon.setDungeonSize(5);
                    ds.setWait(false);
                    break;
                case "Large" :
                    System.out.println("Dungeon Size 8 Selected");
                    dungeon.setDungeonSize(8);
                    ds.setWait(false);
                    break;
                case "embark" :
                    if(!ds.getWait()) {
                        System.out.println("Entering Dungeon");
                        displayDS(false);
                        updateDungeon(true);
                    }
                    break;
                case "back"  :
                    System.out.println("Backing to Party Select");
                    ds.setWait(true);
                    displayDS(false);
                    displayP(true);
                    break;
            }
        }
    }

    public class ActionButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            String yourChoice = event.getActionCommand();
            switch(yourChoice) {
                case "nextRoom": // When "next room" is pressed, generate a new room, update minimap (All done in updateDungeon()
                    updateDungeon(true, 2);
                    break;
                case "exitDungeon":
                    updateDungeon(false, 0);
                    displayTS(true);
                    break;
                default: break;
            }
        }
    }

    public class PopupActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            String yourChoice = event.getActionCommand();
            switch(yourChoice) {
                // Light Atk and Heavy Atk are only active during boss room
                case "Light Atk":
                    if(!dungeon.getWait()) {
                        dungeon.combat(0, "light", popHandler);
                    }
                    break;
                case "Heavy Atk":
                    if(!dungeon.getWait()) {
                        dungeon.combat(0, "heavy", popHandler);
                    }
                    break;
                case "Heal":
                    if(!dungeon.getWait()) {
                        dungeon.heal();
                    }
                    break;
                case "light0":
                    dungeon.combat(0, "light", popHandler);
                    break;
                case "light1":
                    dungeon.combat(1, "light", popHandler);
                    break;
                case "light2":
                    dungeon.combat(2, "light", popHandler);
                    break;
                case "light3":
                    dungeon.combat(3, "light", popHandler);
                    break;
                case "heavy0":
                    dungeon.combat(0, "heavy", popHandler);
                    break;
                case "heavy1":
                    dungeon.combat(1, "heavy", popHandler);
                    break;
                case "heavy2":
                    dungeon.combat(2, "heavy", popHandler);
                    break;
                case "heavy3":
                    dungeon.combat(3, "heavy", popHandler);
                    break;
                default:
                    break;
            }
            if(dungeon.isCleared()) {
                if(dungeon.isComplete()) {
                    updateDungeon(true, 3);
                } else {
                    updateDungeon(true, 1);
                }
            }
        }
    }
}
