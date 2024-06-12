package Swing.Components;

import Swing.Managers.StaticManager;

import javax.swing.*;

public class Node extends JLabel {
    int x, y;
    int state = StaticManager.getState();

    public Node(String name, int alignment){
        super(name, alignment);
    }

    public void initialize(int x, int y){
        this.x = x;
        this.y = y;
        //setText("[" + x + ", " + y + "]");

        setOpaque(true);
        setBackground(StaticManager.DEFAULT_COLOR);
        setBorder(BorderFactory.createLineBorder(StaticManager.NODE_BORDER_COLOR));
    }

    public int changeState(){
        this.state = StaticManager.getState();
        if (state == 0){
            setBackground(StaticManager.START_COLOR);
            StaticManager.setStart(x, y);
        }else if (state == 1){
            setBackground(StaticManager.END_COLOR);
            StaticManager.setEnd(x, y);
        }else if (state == 2){
            setBackground(StaticManager.WALL_COLOR);
        }else if (state == 3){
            setBackground(StaticManager.ERASE_COLOR);
        }else {
            setBackground(StaticManager.DEFAULT_COLOR);
        }
        return this.state;
    }

    public void reset(){
        setBackground(StaticManager.DEFAULT_COLOR);
    }

    public int getState(){
        return state;
    }
}
