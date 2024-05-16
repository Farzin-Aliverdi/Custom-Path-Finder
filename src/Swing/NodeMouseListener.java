package Swing;

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
            int state = node.changeState();
            System.out.println("press->" + state);
            if (state == StaticManager.START){
                StaticManager.onHasStart();
                System.out.println("    NODE_MOUSE_LISTENER--->onHasStart()");
                System.out.println("        STATIC_MANAGER--->onHasStart=" + StaticManager.MAP_PANEL_DIR_ACCESS_HAS_START());
            }
            if (state == StaticManager.END){
                StaticManager.onHasEnd();
                System.out.println("    NODE_MOUSE_LISTENER--->onHasEnd()");
                System.out.println("        STATIC_MANAGER--->onHasEnd=" + StaticManager.MAP_PANEL_DIR_ACCESS_HAS_END());
            }


            if (StaticManager.MAP_PANEL_DIR_ACCESS_HAS_START() && StaticManager.MAP_PANEL_DIR_ACCESS_HAS_END()){
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
            node.changeState();
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        write = false;
    }
}
