package Swing.Panels;

import Swing.Components.CustomButton;
import Swing.Listeners.ControlButtonListener;
import Swing.Listeners.MenuButtonListener;
import Swing.Managers.Runnable;
import Swing.Managers.StaticManager;

import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel implements Runnable {
    final double MAX_HEIGHT_SCALE = 0.05;
    final double NUM_OF_BUTTON = 6;

    private CustomButton runAlgorithmButton, takeStepButton;

    @Override
    public void initialize() {
        setBackground(StaticManager.BACKGROUND_COLOR);
        setPreferredSize(new Dimension(StaticManager.MAX_LENGTH, (int)(StaticManager.MAX_HEIGHT * MAX_HEIGHT_SCALE)));

        addButtons();
    }

    @Override
    public void run() {

    }

    private void addButtons(){
        Dimension dimension = new Dimension((int)(StaticManager.MAX_LENGTH * (1.0 / NUM_OF_BUTTON)), (int)(StaticManager.MAX_HEIGHT * MAX_HEIGHT_SCALE));

        runAlgorithmButton = new CustomButton("Run Algorithm", JLabel.CENTER, dimension);
        takeStepButton = new CustomButton("Take Step", JLabel.CENTER, dimension);

        runAlgorithmButton.initialize(new ControlButtonListener(runAlgorithmButton, StaticManager.DEFAULT_BUTTON_COLOR));
        takeStepButton.initialize(new ControlButtonListener(takeStepButton, StaticManager.DEFAULT_BUTTON_COLOR));

        add(runAlgorithmButton);
        add(takeStepButton);
    }
}
