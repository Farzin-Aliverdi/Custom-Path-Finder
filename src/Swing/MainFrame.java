/*
Author: Farzin Aliverdi
Last Edited: 5/9/2024
GitHub: Farzin-Aliverdi
Description:

 */

// Packages
package Swing;

//Imports
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    //Variables
    MapPanel mapPanel = null;
    MenuPanel menuPanel = null;
    static StateManager stateManager = null;

    public void initialize(){
        setLayout(new BorderLayout());
        setSize(StateManager.MAX_LENGTH, StateManager.MAX_HEIGHT);
        setVisible(true);

        //NORTH - MENU
        menuPanel = new MenuPanel();
        menuPanel.initialize();
        add(menuPanel, BorderLayout.NORTH);

        //CENTRE - MAP
        mapPanel = new MapPanel();
        mapPanel.initialize();
        add(mapPanel, BorderLayout.CENTER);

        //DRAW STATE MANAGER
        stateManager = new StateManager(menuPanel, mapPanel);

        setSize(StateManager.MAX_LENGTH + 10, StateManager.MAX_HEIGHT + 10);
    }

    public void run(){
        while (true){
            mapPanel.repaint();
            menuPanel.repaint();
            repaint();
        }
    }
}
