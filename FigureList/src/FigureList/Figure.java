package FigureList;

import java.awt.*;
import java.awt.event.KeyEvent;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Figure {
    int x;
    int y;
    Display display;

    public Figure()
    {
        display = null;
        x = 0;
        y = 0;
    }

    public Figure(Display display, int x, int y, int xSpeed, int ySpeed) {
        this.display = display;
        this.x = x;
        this.y = y;
    }

    public Figure(Display display, int x, int y) {
        this.display = display;
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setCoordinates(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public void paint(Graphics g)
    {

    }
}
