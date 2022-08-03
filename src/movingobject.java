import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;

class Panel extends JPanel {
    private final ArrayList<Ellipse2D> ee;
    private Ellipse2D eli;
    Panel(){
        ee=new ArrayList<>();
        eli=null;
        addMouseListener(new Mymouse());
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2=(Graphics2D) g;
        for (Ellipse2D o : ee) {
            g2.fill(o);
        }
    }
    public void add(Point2D p){
        eli=new Ellipse2D.Double(p.getX()-10,p.getY()-10,20,20);
        ee.add(eli);
        repaint();
    }
    private class Mymouse extends MouseAdapter {
        public void mousePressed(MouseEvent event){
            if(event.getButton()==MouseEvent.BUTTON1)
                add(event.getPoint());
            }
            public void mouseDragged(MouseEvent event){
                while (event.isConsumed()&&event.getButton()==MouseEvent.BUTTON3){
                    for(int i=0;i<ee.size();i++) {
                        eli=ee.get(i);
                        if (eli.getY() >= event.getPoint().getY()-10 && eli.getX() >= event.getPoint().getX()-10) {
                            repaint();
                        }
                    }
                }
            }
            }

    }
public class movingobject {
    public static void main(String[] args) {
        JFrame frm = new JFrame();
        frm.setSize(816, 639);
        frm.add(new Panel());
        frm.setVisible(true);
    }
}
