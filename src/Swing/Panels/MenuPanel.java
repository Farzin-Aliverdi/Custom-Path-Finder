package Swing.Panels;

import Swing.Components.CustomButton;
import Swing.Listeners.MenuButtonListener;
import Swing.Managers.Runnable;
import Swing.Managers.StaticManager;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel implements Runnable {
    final double MAX_HEIGHT_SCALE = 0.05;
    final double NUM_OF_BUTTON = 6;

    private CustomButton startButton, endButton, wallButton, eraseButton, eraseAllButton;

    public void initialize(){
        setBackground(StaticManager.BACKGROUND_COLOR);
        setPreferredSize(new Dimension(StaticManager.MAX_LENGTH, (int)(StaticManager.MAX_HEIGHT * MAX_HEIGHT_SCALE)));

        addButtons();

        repaint();
    }

    @Override
    public void run(){
        int currentState = StaticManager.getState();
        if (currentState == 0){
            startButton.run();
        }else if (currentState == 1){
            endButton.run();
        }else if (currentState == 2){
            wallButton.run();
        }else if (currentState == 3){
            eraseButton.run();
        }else if (currentState == 4){
            eraseAllButton.run();
        }
    }

    public void resetAll(){
        startButton.reset();
        endButton.reset();
        wallButton.reset();
        eraseButton.reset();
        eraseAllButton.reset();
    }

    private void addButtons(){
        Dimension dimension = new Dimension((int)(StaticManager.MAX_LENGTH * (1.0 / NUM_OF_BUTTON)), (int)(StaticManager.MAX_HEIGHT * MAX_HEIGHT_SCALE));

        startButton = new CustomButton("Start", JLabel.CENTER, dimension);
        endButton = new CustomButton("End", JLabel.CENTER, dimension);
        wallButton = new CustomButton("Wall", JLabel.CENTER, dimension);
        eraseButton = new CustomButton("Erase", JLabel.CENTER, dimension);
        eraseAllButton = new CustomButton("Erase All", JLabel.CENTER, dimension);

        startButton.initialize(new MenuButtonListener(startButton, StaticManager.START));
        endButton.initialize(new MenuButtonListener(endButton, StaticManager.END));
        wallButton.initialize(new MenuButtonListener(wallButton, StaticManager.WALL));
        eraseButton.initialize(new MenuButtonListener(eraseButton, StaticManager.ERASE));
        eraseAllButton.initialize(new MenuButtonListener(eraseAllButton, StaticManager.ERASE_ALL));

        add(startButton);
        add(endButton);
        add(wallButton);
        add(eraseButton);
        add(eraseAllButton);
    }
}
