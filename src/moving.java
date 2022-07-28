import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class moving extends JPanel {
    private int xPos=5;
    private int yPos=5;
    public moving(){
        this.setFocusable(true);
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                switch (e.getKeyCode()){
                    case KeyEvent.VK_W:
                        if(yPos<=20){
                            yPos=5;
                            repaint();
                        }
                        else{
                            if(e.isShiftDown()){
                                yPos-=100;
                                repaint();
                            }
                            else{
                            yPos-=50;
                            repaint();
                            }
                        }
                        break;
                    case KeyEvent.VK_S:
                        if(yPos>=520){
                            yPos=5;
                            repaint();
                        }
                        else{
                            if(e.isShiftDown()){
                                yPos+=100;
                                repaint();
                            }
                            else{
                            yPos+=50;
                           repaint();
                            }
                        }
                        break;
                    case KeyEvent.VK_A:
                        if(xPos<=20){
                            xPos=5;
                           repaint();
                        }
                        else{
                            if(e.isShiftDown()){
                                xPos-=100;
                                repaint();
                            }
                            else {
                                xPos -= 50;
                                repaint();
                            }
                        }
                        break;
                    case KeyEvent.VK_D:
                        if(xPos>=720){
                            xPos=5;
                           repaint();
                        }
                        else{
                            if(e.isShiftDown()){
                                xPos+=100;
                                repaint();
                            }
                            else {
                                xPos += 50;
                                repaint();
                            }
                        }
                        break;
                }
            }
        });
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        BufferedImage bentley;

        Image bambi;
        try {

            bentley= ImageIO.read(new File("photo_2022-07-20_16-57-13.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        bambi=bentley.getScaledInstance(50,50,Image.SCALE_SMOOTH);

        ((Graphics2D)g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g.drawImage(bambi,xPos,yPos,this);
    }

}
class MovePicture{
    public static void main(String[] args){
        JFrame frm=new JFrame("MovingPicture");
        frm.setSize(816,639);
        frm.add(new moving());
        frm.setVisible(true);
    }
}
