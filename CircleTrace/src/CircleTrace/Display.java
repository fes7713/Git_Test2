package CircleTrace;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Display extends JPanel {
    Ball b1;
//    Graphics g;
    public Display()
    {
        b1 = new Ball(this, 80, 80, 0, 0, 20);
//        setTitle(title);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setBounds(20, 20, 300, 200);

//        JPanel p = new JPanel();
//        p.setLayout(new FlowLayout());
//        g = getGraphics();

//        add(p);
        KeyListener kl = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                b1.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                b1.keyReleased(e);
            }
        };
        addKeyListener(kl);
        setFocusable(true);
    }

    public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        b1.paint(g2d);
        g2d.drawString("X :" + String.valueOf(b1.getX()), getWidth() - 40, 20);
        g2d.drawString("Y :" + String.valueOf(b1.getY()), getWidth() - 40, 40);
    }

    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Simple game");
        Display game = new Display();
        frame.add(game);
        frame.setSize(500, 700);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while(true)
        {
            game.b1.move();
            game.repaint();
            Thread.sleep(10);
        }
    }
}
