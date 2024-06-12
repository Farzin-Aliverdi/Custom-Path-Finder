package Swing.Panels;

import Structures.Grid;
import Swing.Managers.Runnable;
import Swing.Managers.StaticManager;

import javax.swing.*;
import java.awt.*;

public class MapPanel extends JPanel implements Runnable {
    Grid grid;

    public void initialize(){
        grid = new Grid(this);
        grid.generate();
        setLayout(new GridLayout(StaticManager.MAP_SIZE, StaticManager.MAP_SIZE));
    }

    @Override
    public void run() {
        //map.takeStep();
    }

    public void takeStep(){
        grid.takeStep();
    }

    public boolean getHasStart(){
        return grid.getHasStart();
    }
    public boolean getHasEnd(){
        return grid.getHasEnd();
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

    public void eraseAll(){
        grid.eraseAll();
    }

    public void flagHasStart(){
        if (!grid.getHasStart()){
            grid.flagHasStart();
        }
    }

    public void flagHasEnd(){
        if (!grid.getHasEnd()){
            grid.flagHasEnd();
        }
    }

    public void removeStart(){
        grid.removeStart();
    }

    public void removeEnd(){
        grid.removeEnd();
    }

    public void setStart(int x, int y){
        grid.setStart(x, y);
    }

    public void setEnd(int x, int y){
        grid.setEnd(x, y);
    }

    public int getStartX() {
        return grid.getStartX();
    }

    public int getStartY() {
        return grid.getStartY();
    }

    public int getEndX() {
        return grid.getEndX();
    }

    public int getEndY() {
        return grid.getEndY();
    }
}
