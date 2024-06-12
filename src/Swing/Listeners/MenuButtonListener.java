package Swing.Listeners;

import Swing.Managers.StaticManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuButtonListener extends MouseAdapter {
    JLabel button;
    private final int state;

    public MenuButtonListener(JLabel button, int state) {
        this.button = button;
        button.setForeground(Color.BLACK);
        this.state = state;
        if (state == StaticManager.START){
            button.setBackground(StaticManager.START_COLOR);
        }else if (state == StaticManager.END){
            button.setBackground(StaticManager.END_COLOR);
        }else if (state == StaticManager.WALL){
            button.setBackground(StaticManager.WALL_COLOR);
        }else if (state == StaticManager.ERASE){
            button.setBackground(StaticManager.ERASE_COLOR);
        }else if (state == StaticManager.ERASE_ALL){
            button.setBackground(StaticManager.ERASE_ALL_COLOR);
        }
    }

    public void reset(){
        if (state == StaticManager.START){
            button.setBackground(StaticManager.START_COLOR);
        }else if (state == StaticManager.END){
            button.setBackground(StaticManager.END_COLOR);
        }else if (state == StaticManager.WALL){
            button.setBackground(StaticManager.WALL_COLOR);
        }else if (state == StaticManager.ERASE){
            button.setBackground(StaticManager.ERASE_COLOR);
        }else if (state == StaticManager.ERASE_ALL){
            button.setBackground(StaticManager.DEFAULT_COLOR);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        StaticManager.resetAllMenuButtons();
        StaticManager.changeState(this.state);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
