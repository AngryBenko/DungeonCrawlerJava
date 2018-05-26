// TODO implement the dungeon layout as a linked list instead of arraylist(priority: low)
// TODO work on combat system class, displaying enemy health that interacts with the combat system.
/*
Combat class
- combat(function) that takes in player object and enemy object
-
 */

import Entities.*;

import javax.swing.*;
import javax.swing.border.BevelBorder;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.ArrayList;

/*
Dungeon handles all the graphics involved in a dungeon eg. characters, enemies, background, minimap, buttons
It may also handle all combat and player/enemy generation
 */
// TODO clean up any obsolete code
public class Dungeon {
    private Random rand = new Random();
    private int dungeonSize; // dungeonSize must be greater than 0
    private final int bgModels = 6;
    private boolean wait = false;
    private int currentMonsters = 0;
    private int currentRoom = 0;
    private int previousRoom = -1; // this value helps ensure that each room generated is not previously the same
    private int roomDisplay = 0;
    private final int partySize = 1, monsters = 10, bosses = 3;

    private final String actionNames[] = {"Light Atk", "Heavy Atk", "Heal"};
    //private final String actionNames2[] = {"Skip", "Swap"};

    private JTextArea combatLog, playerStats;
    private JPopupMenu menuLight, menuHeavy;
    private JScrollPane combatScroll;
    private JButton nextButton, exitButton;
    private JPanel choiceButtonPanel, dungeonPanel, charPanel, mapPanel, mapBGPanel, choicePanel, enemyPanel,
            nextPanel, exitPanel, logPanel;
    private JLabel bossRoomLabel, mapBGLabel, choiceLabel, roomLabel;

    private final JButton actionButtons[] = new JButton[actionNames.length];
    private final JLabel roomBG[] = new JLabel[bgModels];

    private final Font buttonFont = new Font("Copperplate Gothic Bold", Font.PLAIN, 12);
    private final Font logFont = new Font("Copperplate Gothic Bold", Font.PLAIN, 11);

    private ArrayList<JLabel> miniMap = new ArrayList<JLabel>();
    private ArrayList<DungeonRoom> roomList = new ArrayList<DungeonRoom>();
    private ArrayList<JTextArea> monsterHPList = new ArrayList<JTextArea>();
    private ArrayList<JTextArea> playerHPList = new ArrayList<JTextArea>();

    private Entity partyArray[] = new Entity[partySize];
    private ArrayList<Entity> monsterList = new ArrayList<Entity>();
    private Entity boss;

    public Dungeon(GameController.ActionButtonHandler abHandler) {
        init(abHandler);
    }
    // Mostly to initialize any J*
    private void init(GameController.ActionButtonHandler abHandler) {
        initJPanels();
        initJLabels();
        initJButtons(abHandler);
        initPlayerStats();
        initCombatLog();
    }

    // ============================================
    // Initialization of dungeon variables, JPanels, JLabels, and JButtons
    // ============================================
    public void setParty(Entity[] party) {
        for(int i = 0; i < partySize; i++) {
            //partyArray[3 - i] = party[i]; // we flip the array order
            partyArray[i] = party[i];
            System.out.println("index: " + i);
        }
    }
    public void generateCharAtk(GameController.PopupActionListener popHandler) {
        menuLight = updateLightAtk(popHandler);
        menuHeavy = updateHeavyAtk(popHandler);

        for(int i = 0; i < partyArray[0].getNAtks(); i++) {
            JButton btn = new JButton(actionNames[i]);
            btn.setActionCommand(actionNames[i]);
            if(isFinalRoom()) {
                btn.addActionListener(popHandler);
            } else {
                switch(i) {
                    case 0:
                        btn.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                menuLight.show(btn, btn.getWidth()/2, btn.getHeight()/2);
                            }
                        });
                        break;
                    case 1:
                        btn.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                menuHeavy.show(btn, btn.getWidth()/2, btn.getHeight()/2);
                            }
                        });
                        break;
                }
            }
            btn.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    btn.setBackground(Color.orange);
                }
                @Override
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    btn.setBackground(Color.lightGray);
                }
            });
            btn.setBackground(Color.lightGray);
            btn.setForeground(Color.white);
            btn.setFont(buttonFont);
            btn.setFocusPainted(false);
            btn.setOpaque(false);
            btn.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
            actionButtons[i] = btn;
            choiceButtonPanel.add(actionButtons[i]);
        }
    }
    public void setDungeonSize(int n) {
        if(!(n == 0)) {
            dungeonSize = n;
        } else {
            dungeonSize = 3;
        }
    }
    public void initDungeon() { // Initializes all dungeon component
        if(!roomList.isEmpty()) {
            roomList.clear();
        }

        for(int i = 0; i < dungeonSize; i++) {
            if(i == 0) {
                roomList.add(new DungeonRoom(i, false, true, false));
            } else if ((i + 1) == dungeonSize) {
                roomList.add(new DungeonRoom(i, false, false, true));
            } else {
                roomList.add(new DungeonRoom(i, false, false, false));
            }
        }
        generateChar();
        generateEnemy();
        generateRoom();
        updateMiniMap();
    }
    private void initJPanels() {
        dungeonPanel = new JPanel(null);
        dungeonPanel.setBounds(0, 0, 800, 350);
        dungeonPanel.setBackground(Color.red);

        charPanel = new JPanel(null);
        charPanel.setBounds(0, 50, 400, 300);
        charPanel.setBackground(Color.blue);
        charPanel.setOpaque(false);

        enemyPanel = new JPanel(null);
        enemyPanel.setBounds(400, 50, 400, 300);
        enemyPanel.setBackground(Color.orange);
        enemyPanel.setOpaque(false);



        choiceButtonPanel = new JPanel(); // if initialized with null, we can use setBounds on buttons
        choiceButtonPanel.setBounds(150, 350, 250, 250);
        //choiceButtonPanel.setBorder(BorderFactory.createMatteBorder(5, 3, 5, 3, Color.white));
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setOpaque(false);

        choicePanel = new JPanel(null);
        choicePanel.setBounds(0, 350, 150, 250);
        choicePanel.setBackground(Color.black);

        mapPanel = new JPanel();
        mapPanel.setBounds(400, 350, 400, 100);
        mapPanel.setBackground(Color.green);
        mapPanel.setOpaque(false);

        mapBGPanel = new JPanel(null);
        mapBGPanel.setBounds(400, 350, 400, 100);
        mapBGPanel.setBackground(Color.blue);

        logPanel = new JPanel(null);
        logPanel.setBounds(400, 450, 400, 150);
        logPanel.setBackground(Color.pink);

        nextPanel = new JPanel();
        nextPanel.setBounds(710, 540, 80, 50);
        nextPanel.setBackground(Color.magenta);
        nextPanel.setOpaque(false);

        exitPanel = new JPanel();
        exitPanel.setBounds(670, 540, 110, 50);
        exitPanel.setBackground(Color.cyan);
        exitPanel.setOpaque(false);
    }
    private void initJLabels() {
        for(int i = 0; i < bgModels; i++) {
            roomBG[i] = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("res/background/bg_room" + i + ".png")));
            roomBG[i].setBounds(0, 0, 800, 350);
        }

        bossRoomLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("res/background/bg_room_boss.png")));
        bossRoomLabel.setBounds(0, 0, 800, 350);

        choiceLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("res/background/bg_choice.png")));
        choiceLabel.setBounds(0, 0, 400, 250);
        //choicePanel.add(choiceLabel);

        mapBGLabel = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("res/background/bg_map.png")));
        mapBGLabel.setBounds(0, 0, 400, 100);
        mapBGPanel.add(mapBGLabel);
    }
    private void initJButtons(GameController.ActionButtonHandler abHandler) {
        nextButton = new JButton("<html>Next<br/>Room</html>");
        nextButton.setActionCommand("nextRoom");
        nextButton.addActionListener(abHandler);
        nextButton.setBackground(Color.black);
        nextButton.setForeground(Color.white);
        nextButton.setFont(buttonFont);
        nextButton.setFocusPainted(false);
        nextPanel.add(nextButton);

        exitButton = new JButton("<html>Exit<br/>Dungeon</html>");
        exitButton.setActionCommand("exitDungeon");
        exitButton.addActionListener(abHandler);
        exitButton.setBackground(Color.black);
        exitButton.setForeground(Color.white);
        exitButton.setFont(buttonFont);
        exitButton.setFocusPainted(false);
        exitPanel.add(exitButton);
    }
    private void initPlayerStats() {
        playerStats = new JTextArea("");
        playerStats.setForeground(Color.white);
        playerStats.setBackground(Color.black);
        playerStats.setFont(logFont);
        playerStats.setEditable(false);
        playerStats.setLineWrap(true);
        playerStats.setBounds(10, 10, 130, 230);
        choicePanel.add(playerStats);

    }
    private void initCombatLog() {
        combatLog = new JTextArea("");
        combatLog.setForeground(Color.white);
        combatLog.setBackground(Color.darkGray);
        combatLog.setFont(logFont);
        combatLog.setEditable(false);
        combatLog.setLineWrap(true);
        combatLog.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createBevelBorder(BevelBorder.RAISED),
                BorderFactory.createBevelBorder(BevelBorder.LOWERED)));
        combatScroll = new JScrollPane(combatLog, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        combatScroll.setBounds(0, 0, 416, 152);
        logPanel.add(combatScroll);
    }
    private void initPlayerHP(int index, String text) {
        playerHPList.add(new JTextArea(text));
        playerHPList.get(index).setBackground(Color.black);
        playerHPList.get(index).setForeground(Color.white);
        //monsterHP.setOpaque(false);
        playerHPList.get(index).setFont(logFont);
        playerHPList.get(index).setEditable(false);
        playerHPList.get(index).setBounds((295 - (index * 80)), 230, 50, 20);
    }
    private void initMonsterHP(int index, String text) {
        monsterHPList.add(new JTextArea(text));
        monsterHPList.get(index).setBackground(Color.black);
        monsterHPList.get(index).setForeground(Color.white);
        //monsterHP.setOpaque(false);
        monsterHPList.get(index).setFont(logFont);
        monsterHPList.get(index).setEditable(false);
        monsterHPList.get(index).setBounds(40 + (index * 95), 230, 50, 20);
    }

    // ================================================
    // Initializing and generating rooms, characters, monsters
    // Updating dungeon progress
    // ================================================
    private void generateChar() {
        System.out.println("Generating character");
        for(int i = 0; i < partySize; i++) {
            if(partyArray[i] != null) {
                initPlayerHP(i, partyArray[i].healthString());
                charPanel.add(playerHPList.get(i));
                partyArray[i].setBounds((280 - (i * 80)), 140, 80, 80);
                charPanel.add(partyArray[i].getLabel());
            }
        }
        playerStats.append("Name: " + partyArray[0].getName() + "\n");
        playerStats.append("Health: " + partyArray[0].healthString() + "\n");
        playerStats.append("Light Dmg: " + partyArray[0].getLightAttack() + "\n");
        playerStats.append("Heavy Dmg: " + partyArray[0].getHeavyAttack() + "\n");
        playerStats.append("Speed: " + partyArray[0].getSpeed() + "\n");

    }
    // generateEnemy() now creates a new monster object
    // each monster object has its own Jlabel initialized based on child object
    private void generateEnemy() {
        System.out.println("Generating enemies");
        currentMonsters = roomList.get(currentRoom).getMaxEnemies();
        if(isFinalRoom()) {
            switch(getRandomNumber(bosses)) {
                case 0:
                    boss = new OrcBoss();
                    break;
                case 1:
                    boss = new EleFireBoss();
                    break;
                case 2:
                    boss = new HellishBoss();
                    break;
                default:
                    break;
            }
            initMonsterHP(0, boss.healthString());
            monsterHPList.get(0).setBounds(150, 230, 60, 20);
            enemyPanel.add(monsterHPList.get(0));
            boss.setBounds(100, 0, 200, 200);
            enemyPanel.add(boss.getLabel());
        } else {
            // TODO seperate monsterList based on Dungeon Diffuclty;
            // TODO find a more efficient way to generate monsters??
            for(int i = 0; i < roomList.get(currentRoom).getMaxEnemies(); i++) {
                switch(getRandomNumber(monsters)) {
                    case 0:
                        monsterList.add(new Bat()); break;
                    case 1:
                        monsterList.add(new Skeleton()); break;
                    case 2:
                        monsterList.add(new Zombie()); break;
                    case 3:
                        monsterList.add(new Orc()); break;
                    case 4:
                        monsterList.add(new Ent()); break;
                    case 5:
                        monsterList.add(new OrcCrazy()); break;
                    case 6:
                        monsterList.add(new EleEarth()); break;
                    case 7:
                        monsterList.add(new EleWater()); break;
                    case 8:
                        monsterList.add(new EleFire()); break;
                    case 9:
                        monsterList.add(new EleIce()); break;
                    default:
                        break;
                }
                initMonsterHP(i, monsterList.get(i).healthString());
                enemyPanel.add(monsterHPList.get(i));
                monsterList.get(i).setBounds(40 + (i * 85), 140, 80, 80);
                enemyPanel.add(monsterList.get(i).getLabel());
            }
        }
    }
    private void updateMonsterHP(int index) {
        if(isFinalRoom()) {
            monsterHPList.get(index).setText(boss.healthString());
        } else {
            monsterHPList.get(index).setText(monsterList.get(index).healthString());
        }
    }
    private void updatePlayerHP(int index) {
        playerHPList.get(index).setText(partyArray[index].healthString());
    }
    private void generateRoom() {
        System.out.println("Generating next room");
        dungeonPanel.remove(bossRoomLabel);
        dungeonPanel.remove(roomBG[roomDisplay]);
        if(isFinalRoom()) {
            dungeonPanel.add(bossRoomLabel);
        } else {
            while(roomDisplay == previousRoom) {
                roomDisplay = getRandomNumber(bgModels);
            }
            previousRoom = roomDisplay;
            dungeonPanel.add(roomBG[roomDisplay]);
        }
    }
    public void nextRoom() {
        if(!isComplete()) {
            roomList.get(currentRoom).setActiveRoom(false);
            resetEnemy();
            resetPlayerAtk();
            currentRoom++;
            roomList.get(currentRoom).setActiveRoom(true);
            generateEnemy();
            generateRoom();
            updateMiniMap();
            System.out.println("Current Room: " + (currentRoom + 1));
        }
    }
    public void updateMiniMap() {
        System.out.println("Updating minimap");
        resetMiniMap();

        for(int i = 0; i < dungeonSize; i++) {
            if(roomList.get(i).getCleared()) {
                roomLabel = new JLabel("CLEARED");
                roomLabel.setForeground(Color.red);
                if(roomList.get(i).getActiveRoom()) {
                    roomLabel.setBorder(BorderFactory.createCompoundBorder(
                            BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.blue, Color.blue),
                            BorderFactory.createBevelBorder(BevelBorder.LOWERED)));
                } else {
                    roomLabel.setBorder(BorderFactory.createCompoundBorder(
                            BorderFactory.createBevelBorder(BevelBorder.RAISED),
                            BorderFactory.createBevelBorder(BevelBorder.LOWERED)));
                }
            } else {
                if((i + 1) == dungeonSize) {
                    roomLabel = new JLabel(" Boss ");
                } else {
                    roomLabel = new JLabel(" Room " + (i + 1) + " ");
                }
                roomLabel.setForeground(Color.white);
                if(roomList.get(i).getActiveRoom()) {
                    roomLabel.setBorder(BorderFactory.createCompoundBorder(
                            BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.blue, Color.blue),
                            BorderFactory.createBevelBorder(BevelBorder.LOWERED)));
                } else {
                    roomLabel.setBorder(BorderFactory.createCompoundBorder(
                            BorderFactory.createBevelBorder(BevelBorder.RAISED),
                            BorderFactory.createBevelBorder(BevelBorder.LOWERED)));
                }
            }
            roomLabel.setBackground(Color.gray);
            roomLabel.setFont(buttonFont);
            roomLabel.setOpaque(true);
            miniMap.add(i, roomLabel);

            mapPanel.add(miniMap.get(i));
        }
    }
    private JPopupMenu updateLightAtk(GameController.PopupActionListener popHandler) {
        menuLight = new JPopupMenu();
        for(int j = 0; j < roomList.get(currentRoom).getMaxEnemies(); j++) {
            JMenuItem menuItem;
            if(!isFinalRoom()) {
                if(!monsterList.get(j).isDead()) {
                    menuItem = new JMenuItem(monsterList.get(j).getName());
                    menuItem.setActionCommand("light" + j);
                    menuItem.addActionListener(popHandler);
                    menuItem.setFont(buttonFont);
                    menuItem.setBackground(Color.black);
                    menuItem.setForeground(Color.white);
                    menuLight.add(menuItem);
                }
            }
        }
        return menuLight;
    }
    private JPopupMenu updateHeavyAtk(GameController.PopupActionListener popHandler) {
        menuHeavy = new JPopupMenu();
        for(int i = 0; i < roomList.get(currentRoom).getMaxEnemies(); i++) {
            JMenuItem menuItem;
            if(!isFinalRoom()) {
                if(!monsterList.get(i).isDead()) {
                    menuItem = new JMenuItem(monsterList.get(i).getName());
                    menuItem.setActionCommand("heavy" + i);
                    menuItem.addActionListener(popHandler);
                    menuItem.setFont(buttonFont);
                    menuItem.setBackground(Color.black);
                    menuItem.setForeground(Color.white);
                    menuHeavy.add(menuItem);
                }
            }
        }
        return menuHeavy;
    }
    // ================================================
    // Reset functions
    // ================================================
    public void reset() {
        resetPlayerAtk();
        resetPlayerStats();
        resetCombatLog();
        resetEnemy();
        resetChar();
        resetRoom();
        resetMiniMap();
    }
    private void resetPlayerAtk() {
        choiceButtonPanel.removeAll();
    }
    private void resetEnemy() {
        if(!monsterList.isEmpty()) {
            for(int i = 0; i < roomList.get(currentRoom).getMaxEnemies(); i++) {
                enemyPanel.remove(monsterList.get(i).getLabel());
            }
            monsterList.clear();
        }
        if(boss != null) {
            enemyPanel.remove(boss.getLabel());
        }
    }
    private void resetChar() { // This has no use when using the current version of generateChar()
        for(int i = 0; i < partySize; i ++) {
            if(partyArray[i] != null) {
                charPanel.remove(partyArray[i].getLabel());
            }
        }
    }
    private void resetRoom() {
        currentRoom = 0;
        for(int i = 0; i < dungeonSize; i++) {
            roomList.get(i).setCleared(false);
            if(i == 0) {
                roomList.get(i).setActiveRoom(true);
            } else {
                roomList.get(i).setActiveRoom(false);
            }
        }
        System.out.println("Resetting dungeon...");
        setWait(false);
    }
    private void resetMiniMap() {
        if(!miniMap.isEmpty()) {
            for(int i = 0; i < dungeonSize; i++) {
                mapPanel.remove(miniMap.get(i));
            }
            miniMap.clear();
        }
    }
    public void resetCombatLog() {
        for(int i = 0; i < monsterHPList.size(); i++) {
            monsterHPList.get(i).setText(null);
            enemyPanel.remove(monsterHPList.get(i));
        }
        monsterHPList.clear();
        combatLog.setText(null);
    }
    private void resetPlayerStats() {
        playerHPList.get(0).setText(null);
        charPanel.remove(playerHPList.get(0));
        playerHPList.clear();
        playerStats.setText(null);
    }

    // ==================================================
    // Combat functions (in testing)
    // ==================================================
    // To test if we can get monster object health and change it
    public void combat(int index, String atk, GameController.PopupActionListener popHandler) {
        if(isFinalRoom()) {
            switch(atk) {
                case "light":
                    boss.setHealth(boss.getHealth() - partyArray[0].getLightAttack());
                    break;
                case "heavy":
                    boss.setHealth(boss.getHealth() - partyArray[0].getHeavyAttack());
                    break;
            }
            updateMonsterHP(index);
            if(boss.isDead()) {
                currentMonsters--;
                combatLog.append(boss.getName() + " is dead!\n");
            } else {
                combatLog.append("Boss: Health: " + boss.healthString() + "\n");
            }
        } else {
            switch(atk) {
                case "light":
                    monsterList.get(index).setHealth(monsterList.get(index).getHealth() - partyArray[0].getLightAttack());
                    break;
                case "heavy":
                    monsterList.get(index).setHealth(monsterList.get(index).getHealth() - partyArray[0].getHeavyAttack());
                    break;
            }
            updateMonsterHP(index);
            if(monsterList.get(index).isDead()) {
                currentMonsters--;
                combatLog.append(monsterList.get(index).getName() + " is dead!\n");
                updateLightAtk(popHandler);
                updateHeavyAtk(popHandler);
            } else {
                combatLog.append("Entity " + index + ": Health: " + monsterList.get(index).healthString() + "\n");
            }
        }
    }

    public void heal() {
        if(partyArray[0].getHealth() < partyArray[0].getMaxHealth()) {
            partyArray[0].setHealth(partyArray[0].getHealth() + 7);
            updatePlayerHP(0);
        }
    }

    // ==============================================
    // Utilities, Getters, and Setters
    // ==============================================
    private int getRandomNumber(int bound) { return rand.nextInt(bound); }
    public JPanel getLogPanel() { return logPanel; };
    public JPanel getMapPanel() { return mapPanel; }
    public JPanel getMapBGPanel() { return mapBGPanel; }
    public JPanel getChoiceButtonPanel() { return choiceButtonPanel; }
    public JPanel getChoicePanel() { return choicePanel; }
    public JPanel getCharPanel() { return charPanel; }
    public JPanel getEnemyPanel() { return enemyPanel; }
    public JPanel getDungeonPanel() { return dungeonPanel; }
    public JPanel getNextPanel() { return nextPanel; }
    public JPanel getExitPanel() { return exitPanel; }
    public void setWait(boolean wait) { this.wait = wait; }
    public boolean getWait() { return wait; }
    public boolean isCleared() {
        if(currentMonsters == 0) {
            roomList.get(currentRoom).setCleared(true);
            setWait(true);
            return true;
        }
        return false;
    }
    public boolean isComplete() {
        if((currentRoom == dungeonSize - 1) && roomList.get(currentRoom).getCleared()) {
            return true;
        }
        return false;
    }
    private boolean isFinalRoom() {
        if(currentRoom == dungeonSize - 1) {
            return true;
        }
        return false;
    }
    public void displayExit() {
        nextPanel.setVisible(false);
        exitPanel.setVisible(true);
    }
    public void displayNext() {
        nextPanel.setVisible(true);
        exitPanel.setVisible(false);
    }
    public void setVisible(boolean value) {
        dungeonPanel.setVisible(value);
        charPanel.setVisible(value);
        choiceButtonPanel.setVisible(value);
        mapPanel.setVisible(value);
        mapBGPanel.setVisible(value);
        choicePanel.setVisible(value);
        enemyPanel.setVisible(value);
        logPanel.setVisible(value);
        exitPanel.setVisible(false);
        nextPanel.setVisible(false);
    }
}
