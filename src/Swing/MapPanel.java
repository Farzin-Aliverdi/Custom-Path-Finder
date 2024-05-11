package Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class MapPanel extends JPanel {
    int mapSize = StateManager.MAP_SIZE;
    Node[][] map;

    public void initialize(){
        map = new Node[mapSize][mapSize];

        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                Node node = new Node(null, JLabel.CENTER);
                node.initialize(i + 1, j + 1);
                NodeMouseListener nodeMouseListener = new NodeMouseListener();
                nodeMouseListener.initialize(node);
                node.addMouseListener(nodeMouseListener);

                map[i][j] = node;
                add(node);
            }
        }

        setLayout(new GridLayout(mapSize, mapSize));
    }

    @Override
    public void repaint() {
        super.repaint();

        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                map[i][j].repaint();
            }
        }
    }

    void eraseAll(){
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                map[i][j].reset();
            }
        }
    }
}
