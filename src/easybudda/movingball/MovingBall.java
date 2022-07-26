package easybudda.movingball;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static java.awt.event.KeyEvent.*;

public class MovingBall {
    private static final int FREQ = 10;
    private static final Color BACKGROUND_COLOR = Color.white;


    private int x4Pos = 140;
    private int y4Pos = 140;

    private final JPanel ballPanel;

    MovingBall() {
        ballPanel = new JPanel() {

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(WIDTH, HEIGHT);
            }
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                BufferedImage bentley;

                Image bambi;
                try {

                    bentley=ImageIO.read(new File("photo_2022-07-20_16-57-13.jpg"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                bambi=bentley.getScaledInstance(50,50,Image.SCALE_SMOOTH);

                ((Graphics2D)g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                g.drawImage(bambi,x4Pos,y4Pos,this);
            }
        };
        ballPanel.setFocusable(true);
        ballPanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                switch (e.getKeyCode()){
                    case KeyEvent.VK_W:
                        if(y4Pos<=20){
                            ballPanel.repaint();
                        }
                        else{
                        y4Pos-=50;
                        ballPanel.repaint();
                        }
                        break;
                    case KeyEvent.VK_S:
                        if(y4Pos>=520){
                            ballPanel.repaint();
                        }
                        else{
                        y4Pos+=50;
                        ballPanel.repaint();
                        }
                        break;
                    case KeyEvent.VK_A:
                        if(x4Pos<=20){
                            ballPanel.repaint();
                        }
                        else{
                        x4Pos-=50;
                        ballPanel.repaint();
                        }
                        break;
                    case KeyEvent.VK_D:
                        if(x4Pos>=720){
                            ballPanel.repaint();
                        }
                        else{
                        x4Pos+=50;
                        ballPanel.repaint();
                        }
                        break;
            }
        }});
        JFrame mainFrame = new JFrame("Moving Ball");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.add(ballPanel);
        mainFrame.setSize(816, 639);
        mainFrame.setVisible(true);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MovingBall::new);
    }
}