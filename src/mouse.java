import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;

class mypanel extends JPanel{
    private final ArrayList<Ellipse2D> ee;
    private Ellipse2D eli;
    mypanel(){
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
    private class Mymouse extends MouseAdapter{
        public void mousePressed(MouseEvent event){
            add(event.getPoint());
        }
    }
}
public class mouse {
    public static void main(String[] args){
        JFrame frm=new JFrame();
        frm.setSize(816,639);
frm.add(new mypanel());
        frm.setVisible(true);
    }
}
