package Swing;

import java.awt.*;

public class StateManager {
    private static MenuPanel menuPanel = null;
    private static MapPanel mapPanel = null;

    final static int MAP_SIZE = 100;
    final static int MAX_HEIGHT = 800;
    final static int MAX_LENGTH = 800;

    final static int START = 0;
    final static int END = 1;
    final static int WALL = 2;
    final static int ERASE = 3;
    final static int ERASE_ALL = 4;
    /*
    state = 0; START
    state = 1; END
    state = 2; WALL
    state = 3; ERASE
     */
    private static int state = 0;

    final static Color DEFAULT_COLOR = Color.LIGHT_GRAY;
    final static Color START_COLOR = Color.GREEN;
    final static Color END_COLOR = Color.RED;
    final static Color WALL_COLOR = Color.BLACK;
    final static Color ERASE_COLOR = DEFAULT_COLOR;
    final static Color ERASE_ALL_COLOR = DEFAULT_COLOR;

    public StateManager(MenuPanel menuPanel, MapPanel mapPanel){
        StateManager.menuPanel = menuPanel;
        StateManager.mapPanel = mapPanel;
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
        StateManager.state = state;
        return state;
    }

    public static int getState(){
        return state;
    }

    public static void eraseAll(){
        mapPanel.eraseAll();
    }
}
