package Swing;

import java.awt.*;

public class StaticManager {
    private static MenuPanel menuPanel = null;
    private static MapPanel mapPanel = null;

    final public static int MAP_SIZE = 25;
    final public static int MAX_HEIGHT = 800;
    final public static int MAX_LENGTH = 800;

    public enum ButtonState{START,END, WALL, ERASE, ERASE_ALL, PLAY_PAUSE};
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

    final public static Color DEFAULT_COLOR = new Color(222, 222, 222);
    final public static Color DEFAULT_HOVER_COLOR = new Color(190, 190, 190);
    final public static Color START_COLOR = new Color(131, 196, 98);
    final public static Color START_HOVER_COLOR = new Color(131, 196, 98);
    final public static Color END_COLOR = new Color(199, 92, 80);
    final public static Color WALL_COLOR = new Color(77, 77, 77);
    final public static Color ERASE_COLOR = DEFAULT_COLOR;
    final public static Color ERASE_ALL_COLOR = DEFAULT_COLOR;
    final public static Color NODE_BORDER_COLOR = new Color(12,2, 1);

    static void staticManager(MenuPanel menuPanel, MapPanel mapPanel){
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
        return state;
    }

    public static int getState(){
        return state;
    }

    public static void eraseAll(){
        mapPanel.eraseAll();
    }

    public static void onHasStart(){
        mapPanel.onHasStart();
    }

    public static void onHasEnd(){
        mapPanel.onHasEnd();
    }

    public static void step(){
        mapPanel.takeStep();
    }

    public static boolean MAP_PANEL_DIR_ACCESS_HAS_START(){
        return mapPanel.getHasStart();
    }

    public static boolean MAP_PANEL_DIR_ACCESS_HAS_END(){
        return mapPanel.getHasEnd();
    }
}
