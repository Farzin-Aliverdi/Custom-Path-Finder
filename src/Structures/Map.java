/*
Author: Farzin Aliverdi
Last Edited: 5/9/2024
GitHub: Farzin-Aliverdi
Description:

 */

package Structures;

import javax.swing.*;

abstract class Map extends JPanel {
    private int size;

    abstract void takeStep();
    abstract void generate();
}
