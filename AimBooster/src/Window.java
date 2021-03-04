import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Window extends JPanel implements MouseListener {
    private static int DIMX;
    private static int DIMY;
    private int difficulty;
    private Cerchio cir;

    public Window(int dimx, int dimy, int difficulty) {
        DIMX = dimx;
        DIMY = dimy;
        this.difficulty = 10;
        cir = new Cerchio(difficulty);
        finestra();
    }

    private void finestra()
    {
        JFrame frame = new JFrame("Aim Booster by CelaMimmo");
        frame.add(this);
        addMouseListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        frame.setSize(DIMX, DIMY);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(0,0);
        frame.setResizable(true);

        while (true) {
            this.repaint();
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(e.getLocationOnScreen().x);
        System.out.println(e.getLocationOnScreen().y);
        if(e.getLocationOnScreen().x >= 0 && e.getLocationOnScreen().y >=0 && e.getLocationOnScreen().x < DIMX && e.getLocationOnScreen().y <DIMY)
        {
            System.out.println("si");
            if((e.getLocationOnScreen().x <= cir.getX()+cir.getRadius()+difficulty || e.getLocationOnScreen().x <= cir.getX()+cir.getRadius()-difficulty) &&
                (e.getLocationOnScreen().y <= cir.getY()+cir.getRadius()+difficulty || e.getLocationOnScreen().y <= cir.getY()+cir.getRadius()-difficulty))
            {
                System.out.println("di nuovo");
                moveCircle();
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("mousePressed");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("mouseReleased");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("mouseEntered");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("mouseExited");
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.fillOval(cir.getX(),cir.getY(),cir.getRadius(),cir.getRadius());

    }

    public static int getDIMX() {
        return DIMX;
    }

    public static int getDIMY() {
        return DIMY;
    }

    private void moveCircle()
    {
        cir = new Cerchio(difficulty);
    }
}

