import javax.swing.*;
import java.awt.*;

public class CentralHub {
    private JPanel hubNamePanel, hubButtonPanel, background;
    private JLabel hubNameLabel, hubBackground;

    private final String menuNames[] = {"DUNGEONS", "STORE", "EXIT"};
    private final JButton menuButtons[] = new JButton[menuNames.length];

    private final Font titleFont = new Font("Copperplate Gothic Bold", Font.PLAIN, 50);
    private final Font menuFont = new Font("Copperplate Gothic Bold", Font.PLAIN, 24);

    public CentralHub(GameController.CentralHubHandler chHandler) {
        init(chHandler);
    }

    private void init(GameController.CentralHubHandler chHandler) {
        background = new JPanel();
        background.setBounds(0, 0, 800, 600);
        background.setBackground(Color.black);
        hubBackground = new JLabel();
        hubBackground.setBounds(0, 0, 800, 600);
        ImageIcon backgroundImg = new ImageIcon(getClass().getClassLoader().getResource("res/background/hubBackground.png"));
        hubBackground.setIcon(backgroundImg);

        hubNamePanel = new JPanel();
        hubNamePanel.setBounds(0, 100, 800, 100); // setBounds(x,y,width,height);
        hubNamePanel.setBackground(Color.black);
        hubNamePanel.setOpaque(false);
        hubNameLabel = new JLabel("Central Hub");
        hubNameLabel.setForeground(Color.white);
        hubNameLabel.setFont(titleFont);

        // Any menu buttons that exist will be under one panel for organization and rendering purposes
        // also reduces the ned for additional panels per button
        hubButtonPanel = new JPanel();
        hubButtonPanel.setBounds(300, 300, 200, 150);
        hubButtonPanel.setBackground(Color.black);
        hubButtonPanel.setLayout(new GridLayout(3, 1, 0, 0)); // GridLayout(row, col, colgap, rowgap);

        // Creating menu buttons which will be added to a panel later
        // Many buttons contained by one panel share common properties
        // Also reduces the amount of code needed to make multiple buttons
        for (int i = 0; i < menuButtons.length; i++) {
            JButton btn = new JButton(menuNames[i]);
            btn.setActionCommand("hub" + i);
            btn.addActionListener(chHandler);
            //btn.setBorder(null);
            btn.setBackground(Color.black);
            btn.setForeground(Color.white);
            btn.setFont(menuFont);
            btn.setFocusPainted(false);
            menuButtons[i] = btn;
            hubButtonPanel.add(menuButtons[i]);
        }

        // Add labels/buttons to the panels
        hubNamePanel.add(hubNameLabel);
        background.add(hubBackground);

        // display the panels to the container
        //add(titleNamePanel);
        //add(menuButtonPanel);

        // Always revalidate and repaint JFrame when adding new components/panels
        // Similar to a update and render
    }
    public JPanel getHubNamePanel() { return hubNamePanel; }
    public JPanel getHubButtonPanel() { return hubButtonPanel; }
    public JPanel getHubBackgroundPanel() { return background; }

    public void setVisible(boolean value) {
        hubNamePanel.setVisible(value);
        hubButtonPanel.setVisible(value);
        background.setVisible(value);
    }
}
