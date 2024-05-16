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

    public void initialize(){
        setLayout(new BorderLayout());
        setSize(StaticManager.MAX_LENGTH, StaticManager.MAX_HEIGHT);
        setVisible(true);

        //NORTH - MENU
        menuPanel = new MenuPanel();
        menuPanel.initialize();
        add(menuPanel, BorderLayout.NORTH);

        //CENTRE - MAP
        mapPanel = new MapPanel();
        mapPanel.initialize();
        add(mapPanel, BorderLayout.CENTER);

        StaticManager.staticManager(menuPanel, mapPanel);

        setSize(StaticManager.MAX_LENGTH + 10, StaticManager.MAX_HEIGHT + 10);
    }

    public void run(){
        while (true){
            mapPanel.run();
            mapPanel.repaint();

            menuPanel.run();
            menuPanel.repaint();

            repaint();
        }
    }
}
