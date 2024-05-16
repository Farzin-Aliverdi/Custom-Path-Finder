package Swing;

import Structures.Map;

import javax.swing.*;
import java.awt.*;

public class MapPanel extends JPanel implements Runnable{
    Map map;

    public void initialize(){
        map = new Map(this);
        map.generate();
        setLayout(new GridLayout(StaticManager.MAP_SIZE, StaticManager.MAP_SIZE));
    }

    @Override
    public void run() {
        //map.takeStep();
    }

    public void takeStep(){
        map.takeStep();
    }

    public boolean getHasStart(){
        return map.getHasStart();
    }
    public boolean getHasEnd(){
        return map.getHasEnd();
    }

    @Override
    public void repaint() {
        super.repaint();

        for (int i = 0; i < StaticManager.MAP_SIZE; i++) {
            for (int j = 0; j < StaticManager.MAP_SIZE; j++) {
                //map[i][j].repaint();
            }
        }
    }

    void eraseAll(){
        map.eraseAll();
    }

    void onHasStart(){
        if (!map.getHasStart()){
            map.tickHasStart();
        }
    }

    void onHasEnd(){
        if (!map.getHasEnd()){
            map.tickHasEnd();
        }
    }
}
