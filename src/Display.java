import javax.swing.*;
import java.awt.*;

public class Display extends JFrame implements Runnable{
    private float x;
    private float y;
    Thread thread;
    public Display(String title, int width, int height) {
        super(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(width,height);
        setLocationRelativeTo(null);
        setResizable(true);
        x = 0;
        y = 0;
        thread = new Thread(this);
        thread.start();

    }

    public void paint(Graphics g)
    {
//        g.drawRect(0, 0, 100, 100);
        g.fillRect((int)x, (int)y, 100, 100);
    }

    public void move()
    {
        x+= 1;
        y+= 1;
    }
    public static void main(String[] args) {
        Display gw = new Display("テストウィンドウ",400,300);
        JPanel panel = new DrawCanvas();
        gw.add(panel);
        gw.setVisible(true);

        gw.setBackground(Color.blue);

        //フレームの大きさと背景色を指定、キャンバスをフレームに載せる
        Frame mainF = new Frame("moving ball");
        mainF.setBackground(Color.green);
        mainF.setSize(400,300);
        mainF.setLayout(new FlowLayout());
        mainF.add(gw);
        mainF.setVisible(true);



    }

    @Override
    public void run() {
        while(true)
        {
            move();
            repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class DrawCanvas extends JPanel{
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString("あいうえお", 150, 150);
    }
}
