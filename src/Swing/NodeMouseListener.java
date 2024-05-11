package Swing;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class NodeMouseListener extends MouseAdapter {
    boolean write = false;
    Node node = null;
    static boolean PRESSED = false;

    public void initialize(Node node){
        this.node = node;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        PRESSED = true;
        if (write){
            node.changeState(StateManager.getState());
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        PRESSED = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        write = true;
        if (PRESSED){
            node.changeState(StateManager.getState());
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        write = false;
    }
}
