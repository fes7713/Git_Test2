package Panel_Sample;


import java.awt.*;
import javax.swing.*;

public class CircleX extends JFrame {

    public CircleX(){
        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MyPanel panel = new MyPanel();
        this.add(panel, BorderLayout.CENTER);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new CircleX();
    }
}

class MyPanel extends JPanel {

    public void paintComponent(Graphics g){
        for(int i = 0;i < 255;i += 20){
            g.setColor(new Color(0,0,255,i));
            g.fillOval(i, i, 100, 100);
            g.setColor(new Color(255,0,0,i));
            g.fillOval(255 - i, i, 100, 100);
        }
    }
}