import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

class Mypanel extends JPanel{
     Mypanel() {
addMouseMotionListener(new Mymouse());
     }
  private class Mymouse extends MouseAdapter {
         Mymouse() {

             addMouseMotionListener(new MouseMotionListener() {
                 @Override
                 public void mouseMoved(MouseEvent e) {
                     final int x = e.getX();
                     final int y = e.getY();
                     // only display a hand if the cursor is over the items
                     final Rectangle cellBounds = getBounds();
                     if (cellBounds != null && cellBounds.contains(x, y)) {
                         setCursor(new Cursor(Cursor.HAND_CURSOR));
                     } else {
                         setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                     }
                 }

                 @Override
                 public void mouseDragged(MouseEvent e) {
                 }
             });
         }
    }
}

public class mice {
    public static void main(String[] args){
        JFrame frm=new JFrame();
        frm.setSize(816,639);
        frm.add(new Mypanel());
        frm.setVisible(true);
    }
}
