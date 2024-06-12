/*
Author: Farzin Aliverdi
Last Edited: 5/9/2024
GitHub: Farzin-Aliverdi
Description:

 */

package Structures;

import Swing.Panels.MapPanel;
import Swing.Components.Node;
import Swing.Listeners.NodeMouseListener;
import Swing.Managers.StaticManager;

import javax.swing.*;

public class Grid implements DataStructure{
    private Node[][] grid;
    private boolean[][] visitedMap;
    private MapPanel mapPanel;

    private boolean hasStart = false;
    private boolean hasEnd = false;
    private int startX, startY, endX, endY;

    public Grid(MapPanel mapPanel){
        grid = new Node[StaticManager.MAP_SIZE][StaticManager.MAP_SIZE];
        this.mapPanel = mapPanel;
    }

    @Override
    public void takeStep() {
        if (hasStart && hasEnd){
            System.out.println("HOORAYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY");
            hasStart = false;
            hasEnd = false;
        }
    }

    @Override
    public Node[][] generate() {
        for (int i = 0; i < StaticManager.MAP_SIZE; i++) {
            for (int j = 0; j < StaticManager.MAP_SIZE; j++) {
                Node node = new Node(null, JLabel.CENTER);
                node.initialize(i + 1, j + 1);
                NodeMouseListener nodeMouseListener = new NodeMouseListener();
                nodeMouseListener.initialize(node);
                node.addMouseListener(nodeMouseListener);

                grid[i][j] = node;
                mapPanel.add(node);
            }
        }
        return grid;
    }

    public void eraseAll(){
        for (int i = 0; i < StaticManager.MAP_SIZE; i++) {
            for (int j = 0; j < StaticManager.MAP_SIZE; j++) {
                grid[i][j].reset();
            }
        }
        hasStart = false;
        startX = -1;
        startY = -1;
        hasEnd = false;
        endX = -1;
        endY = -1;
    }

    public int removeEnd(){
        int removed = 0;

        for (int i = 0; i < StaticManager.MAP_SIZE; i++) {
            for (int j = 0; j < StaticManager.MAP_SIZE; j++) {
                if (grid[i][j].getState() == StaticManager.END){
                    grid[i][j].reset();
                    removed++;
                }
            }
        }
        hasEnd = false;
        endX = -1;
        endY = -1;
        return removed;
    }

    public int removeStart(){
        int removed = 0;

        for (int i = 0; i < StaticManager.MAP_SIZE; i++) {
            for (int j = 0; j < StaticManager.MAP_SIZE; j++) {
                if (grid[i][j].getState() == StaticManager.START){
                    grid[i][j].reset();
                    removed++;
                }
            }
        }
        hasStart = false;
        startX = -1;
        startY = -1;
        return removed;
    }

    public boolean flagHasStart(){
        hasStart = true;
        return hasStart;
    }

    public boolean flagHasEnd() {
        hasEnd = true;
        return hasEnd;
    }

    public boolean getHasStart(){
        return hasStart;
    }

    public boolean getHasEnd(){
        return hasEnd;
    }

    public void setStart(int x, int y){
        this.startX = x;
        this.startY = y;
    }

    public void setEnd(int x, int y){
        this.endX = x;
        this.endY = y;
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public int getEndX() {
        return endX;
    }

    public int getEndY() {
        return endY;
    }

}
