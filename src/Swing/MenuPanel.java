package Swing;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel implements Runnable {
    final double MAX_HEIGHT_SCALE = 0.05;
    final double NUM_OF_BUTTON = 6;

    private MenuButton startButton, endButton, wallButton, eraseButton, eraseAllButton;

    Color backgroundCol = Color.DARK_GRAY;

    public void initialize(){
        setBackground(backgroundCol);
        setPreferredSize(new Dimension(StateManager.MAX_LENGTH, (int)(StateManager.MAX_HEIGHT * MAX_HEIGHT_SCALE)));

        addButtons();

        repaint();
    }

    @Override
    public void run(){
        int currentState = StateManager.getState();
        if (currentState == 0){
            startButton.run();
            endButton.reset();
            wallButton.reset();
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

    private void addButtons(){
        Dimension dimension = new Dimension((int)(StateManager.MAX_LENGTH * (1.0 / NUM_OF_BUTTON)), (int)(StateManager.MAX_HEIGHT * MAX_HEIGHT_SCALE));

        startButton = new MenuButton("Start", JLabel.CENTER);
        endButton = new MenuButton("End", JLabel.CENTER);
        wallButton = new MenuButton("Wall", JLabel.CENTER);
        eraseButton = new MenuButton("Erase", JLabel.CENTER);
        eraseAllButton = new MenuButton("Erase All", JLabel.CENTER);

        startButton.initialize(dimension, new MenuButtonListener(startButton, StateManager.START));
        endButton.initialize(dimension, new MenuButtonListener(endButton, StateManager.END));
        wallButton.initialize(dimension, new MenuButtonListener(wallButton, StateManager.WALL));
        eraseButton.initialize(dimension, new MenuButtonListener(eraseButton, StateManager.ERASE));
        eraseAllButton.initialize(dimension, new MenuButtonListener(eraseAllButton, StateManager.ERASE_ALL));

        add(startButton);
        add(endButton);
        add(wallButton);
        add(eraseButton);
        add(eraseAllButton);
    }
}
