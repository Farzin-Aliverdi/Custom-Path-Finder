package Swing;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuButtonListener extends MouseAdapter {
    JLabel button;
    private final int state;

    public MenuButtonListener(JLabel button, int state) {
        this.button = button;
        this.state = state;
        if (state == 0){
            button.setBackground(StateManager.START_COLOR);
        }else if (state == 1){
            button.setBackground(StateManager.END_COLOR);
        }else if (state == 2){
            button.setBackground(StateManager.WALL_COLOR);
        }else if (state == 3){
            button.setBackground(StateManager.ERASE_COLOR);
        }else if (state == 4){
            button.setBackground(StateManager.ERASE_ALL_COLOR);
        }
    }

    public void reset(){
        if (state == 0){
            button.setBackground(StateManager.START_COLOR);
        }else if (state == 1){
            button.setBackground(StateManager.END_COLOR);
        }else if (state == 2){
            button.setBackground(StateManager.WALL_COLOR);
        }else if (state == 3){
            button.setBackground(StateManager.ERASE_COLOR);
        }else if (state == 4){
            button.setBackground(StateManager.ERASE_ALL_COLOR);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int state = StateManager.changeState(this.state);
        if (state == 0){
            button.setBackground(StateManager.START_COLOR);
        }else if (state == 1){
            button.setBackground(StateManager.END_COLOR);
        }else if (state == 2){
            button.setBackground(StateManager.WALL_COLOR);
        }else if (state == 3){
            button.setBackground(StateManager.ERASE_COLOR);
        }else if (state == 4){
            button.setBackground(StateManager.ERASE_ALL_COLOR);
            StateManager.eraseAll();
        }
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
