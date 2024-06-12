package Swing.Listeners;

import Swing.Components.CustomButton;
import Swing.Managers.StaticManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ControlButtonListener extends MouseAdapter {
    CustomButton button = null;

    public ControlButtonListener(CustomButton button, Color color){
        this.button = button;
        button.setBackground(color);
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if (StaticManager.hasStart() ){

        }

//        if (button.getText().equals("Take Step")){
//            StaticManager.takeStep();
//        }else {
//
//        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
