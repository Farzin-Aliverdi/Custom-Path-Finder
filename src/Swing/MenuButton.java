package Swing;

import javax.swing.*;
import java.awt.*;

public class MenuButton extends JLabel implements Runnable{
    private MenuButtonListener menuButtonListener;

    public MenuButton(String name, int orientation) {
        super(name, orientation);
    }

    public void initialize(Dimension dimension, MenuButtonListener menuButtonListener) {
        setOpaque(true);
        setPreferredSize(dimension);
        addMouseListener(menuButtonListener);
    }

    public void reset(){
        menuButtonListener.reset();
    }

    @Override
    public void initialize() {

    }

    @Override
    public void run() {

    }
}
