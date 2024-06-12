package Swing.Managers;

import Swing.Panels.MapPanel;
import Swing.Panels.MenuPanel;

import java.awt.*;

public class StaticManager {
    private static MenuPanel menuPanel = null;
    private static MapPanel mapPanel = null;

    final public static int MAP_SIZE = 25;
    final public static int MAX_HEIGHT = 800;
    final public static int MAX_LENGTH = 800;

    final public static int ALG_SPEED = 1;

    public enum ButtonState{START, END, WALL, ERASE, ERASE_ALL, PLAY_PAUSE};
    //BUTTON CONSTANTS
    final public static int START = 0;
    final public static int END = 1;
    final public static int WALL = 2;
    final public static int ERASE = 3;
    final public static int ERASE_ALL = 4;
    /*
    state = 0; START
    state = 1; END
    state = 2; WALL
    state = 3; ERASE
     */
    private static int state = 0;

    final public static int BUTTON_BLINK_RANGE = 100;

    final public static Color DEFAULT_COLOR = new Color(222, 222, 222);
    final public static Color DEFAULT_HOVER_COLOR = new Color(145, 145, 145);
    final public static Color DEFAULT_SELECT_COLOR = new Color(255, 255, 255);

    final public static Color START_COLOR = new Color(131, 196, 98);
    final public static Color START_HOVER_COLOR = new Color(102, 145, 72);
    final public static Color START_SELECT_COLOR = new Color(131, 196, 98);

    final public static Color END_COLOR = new Color(199, 92, 80);
    final public static Color END_HOVER_COLOR = new Color(199, 92, 80);
    final public static Color END_SELECT_COLOR = new Color(199, 92, 80);

    final public static Color WALL_COLOR = new Color(77, 77, 77);
    final public static Color WALL_HOVER_COLOR = new Color(77, 77, 77);
    final public static Color WALL_SELECT_COLOR = new Color(77, 77, 77);

    final public static Color ERASE_COLOR = DEFAULT_COLOR;
    final public static Color ERASE_HOVER_COLOR = DEFAULT_HOVER_COLOR;
    final public static Color ERASE_SELECT_COLOR = DEFAULT_SELECT_COLOR;

    final public static Color ERASE_ALL_COLOR = DEFAULT_COLOR;
    final public static Color ERASE_ALL_HOVER_COLOR = DEFAULT_HOVER_COLOR;
    final public static Color ERASE_ALL_SELECT_COLOR = DEFAULT_SELECT_COLOR;

    final public static Color NODE_BORDER_COLOR = new Color(12,2, 1);
    final public static Color BACKGROUND_COLOR = new Color(136, 136, 136);
    final public static Color DEFAULT_BUTTON_COLOR = new Color(222, 222, 222);

    final public static Color WALKED = new Color(80, 171, 199);

    public static void staticManager(MenuPanel menuPanel, MapPanel mapPanel){
        StaticManager.menuPanel = menuPanel;
        StaticManager.mapPanel = mapPanel;
    }

    public static int changeState(){
        if (state == 0){
            state = 1;
        }else if (state == 1){
            state = 2;
        }else if (state == 2){
            state = 3;
        }else if (state == 3){
            state = 4;
        }else if (state == 4){
            state = 0;
        }
        return state;
    }

    public static int changeState(int state){
        StaticManager.state = state;
        if (state == ERASE_ALL){
            eraseAll();
        }
        return state;
    }

    public static int getState(){
        return state;
    }

    public static void eraseAll(){
        mapPanel.eraseAll();
    }

    public static void flagHasStart(){
        mapPanel.flagHasStart();
    }

    public static void flagHasEnd(){
        mapPanel.flagHasEnd();
    }

    public static void step(){
        mapPanel.takeStep();
    }

    public static boolean hasStart(){
        return mapPanel.getHasStart();
    }

    public static boolean hasEnd(){
        return mapPanel.getHasEnd();
    }

    public static void removeStart(){
        mapPanel.removeStart();
    }

    public static void removeEnd(){
        mapPanel.removeEnd();
    }

    public static void setStart(int x, int y){
        mapPanel.setStart(x, y);
    }

    public static void setEnd(int x, int y){
        mapPanel.setEnd(x, y);
    }

    public int getStartX() {
        return mapPanel.getStartX();
    }

    public int getStartY() {
        return mapPanel.getStartY();
    }

    public int getEndX() {
        return mapPanel.getEndX();
    }

    public int getEndY() {
        return mapPanel.getEndY();
    }

    public static void resetAllMenuButtons(){
        menuPanel.resetAll();
    }
}
