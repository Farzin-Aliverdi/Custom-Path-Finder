package Swing.Listeners;

import Swing.Components.Node;
import Swing.Managers.StaticManager;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
            int state = StaticManager.getState();
            System.out.println("press->" + state);
            if (state == StaticManager.START){
                StaticManager.removeStart();
                StaticManager.flagHasStart();
            }
            if (state == StaticManager.END){
                StaticManager.removeEnd();
                StaticManager.flagHasEnd();
            }
            node.changeState();

            if (StaticManager.hasStart() && StaticManager.hasEnd()){
                StaticManager.step();
                System.out.println("success!");
            }
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
            if ((StaticManager.getState() != StaticManager.START) && (StaticManager.getState() != StaticManager.END)){
                node.changeState();
            }
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        write = false;
    }
}
