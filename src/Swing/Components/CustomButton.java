package Swing.Components;

import Swing.Listeners.ControlButtonListener;
import Swing.Listeners.MenuButtonListener;
import Swing.Managers.Runnable;
import Swing.Managers.StaticManager;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ColorModel;

public class CustomButton extends JLabel implements Runnable {
    private MenuButtonListener menuButtonListener = null;
    private ControlButtonListener controlButtonListener = null;
    private Dimension dimension;

    private int blinkCounter = 0;
    private int blinkDirection = 1;
    private int changeCounterMax = 10000;
    private int changeCounter = 0;

    public CustomButton(String name, int orientation, Dimension dimension) {
        super(name, orientation);
        this.dimension = dimension;
    }

    public void initialize(MenuButtonListener menuButtonListener) {
        setOpaque(true);
        setPreferredSize(dimension);
        this.menuButtonListener = menuButtonListener;
        addMouseListener(menuButtonListener);
    }

    public void initialize(ControlButtonListener controlButtonListener) {
        setOpaque(true);
        setPreferredSize(dimension);
        this.controlButtonListener = controlButtonListener;
        addMouseListener(controlButtonListener);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void run() {
        if (changeCounter != changeCounterMax){
            changeCounter++;
            return;
        }
        changeCounter = 0;
        if (blinkCounter >= StaticManager.BUTTON_BLINK_RANGE){
            blinkDirection = -1;
        }

        if (blinkCounter <= -StaticManager.BUTTON_BLINK_RANGE){
            blinkDirection = 1;
        }
        Color original = getBackground();
        int r = original.getRed() + blinkDirection;
        int g = original.getGreen() + blinkDirection;
        int b = original.getBlue() + blinkDirection;

        if (r > 255){
            r = 255;
        }
        if (r < 0){
            r = 0;
        }
        if (g > 255){
            g = 255;
        }
        if (g < 0){
            g = 0;
        }
        if (b > 255){
            b = 255;
        }
        if (b < 0){
            b = 0;
        }
        setBackground(new Color(r, g, b));
        blinkCounter += blinkDirection;
    }

    public void reset(){
        menuButtonListener.reset();
    }
}
