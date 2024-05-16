/*
Author: Farzin Aliverdi
Last Edited: 5/9/2024
GitHub: Farzin-Aliverdi
Description:

 */

package Structures;

import Swing.MapPanel;
import Swing.Node;
import Swing.NodeMouseListener;
import Swing.StaticManager;

import javax.swing.*;

public class Map implements DataStructure{
    private Node[][] map;
    private boolean[][] visitedMap;
    private MapPanel mapPanel;

    private boolean hasStart = false;
    private boolean hasEnd = false;

    public Map (MapPanel mapPanel){
        map = new Node[StaticManager.MAP_SIZE][StaticManager.MAP_SIZE];
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

                map[i][j] = node;
                mapPanel.add(node);
            }
        }
        return map;
    }

    public void eraseAll(){
        for (int i = 0; i < StaticManager.MAP_SIZE; i++) {
            for (int j = 0; j < StaticManager.MAP_SIZE; j++) {
                map[i][j].reset();
            }
        }
    }

    public boolean tickHasStart(){
        hasStart = !hasStart;
        return hasStart;
    }
    public boolean tickHasEnd() {
        hasEnd = !hasEnd;
        return hasEnd;
    }

    public boolean getHasStart(){
        return hasStart;
    }
    public boolean getHasEnd(){
        return hasEnd;
    }
}
