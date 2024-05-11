package Swing;

import javax.swing.*;
import java.awt.*;

public class Node extends JLabel {
    int x, y;
    int state = StateManager.getState();

    public Node(String name, int alignment){
        super(name, alignment);
    }

    public void initialize(int x, int y){
        this.x = x;
        this.y = y;
        //setText("[" + x + ", " + y + "]");

        setOpaque(true);
        setBackground(StateManager.DEFAULT_COLOR);
    }

    public void changeState(int state){
        this.state = state;
        if (state == 0){
            setBackground(StateManager.START_COLOR);
        }else if (state == 1){
            setBackground(StateManager.END_COLOR);
        }else if (state == 2){
            setBackground(StateManager.WALL_COLOR);
        }else if (state == 3){
            setBackground(StateManager.ERASE_COLOR);
        }else {
            setBackground(StateManager.DEFAULT_COLOR);
        }
    }

    public void reset(){
        setBackground(StateManager.DEFAULT_COLOR);
    }
}
