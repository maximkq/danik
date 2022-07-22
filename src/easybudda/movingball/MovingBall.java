package easybudda.movingball;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MovingBall {
    private static final int WIDTH = 815;
    private static final int HEIGHT = 1000;
    private static final int FREQ = 10;
    private static final Color BACKGROUND_COLOR = Color.BLACK;

    private int xPos = 0;
    private int yPos = 0;
    private final JPanel ballPanel;

    MovingBall() {
        ballPanel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                BufferedImage img;
                Image scaled;

                try {
                    img = ImageIO.read(new File("photo_2022-07-20_16-57-13.jpg"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                scaled = img.getScaledInstance(100,
                        100, Image.SCALE_SMOOTH);
                ((Graphics2D)g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                 g.drawImage(scaled,xPos,yPos,this);



            }
        };
        ballPanel.setOpaque(true);
        ballPanel.setBackground(BACKGROUND_COLOR);

        Timer timer = new Timer(FREQ, ae -> {
           if(xPos!=800&&yPos!=800){
               xPos+=10;
               yPos+=10;
           }
           if(xPos==800&&yPos==800){
               xPos=0;yPos=0;
           }
            ballPanel.repaint();
        });

        JFrame mainFrame = new JFrame("Moving Ball");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.add(ballPanel);
        mainFrame.setSize(WIDTH, HEIGHT );
        mainFrame.setVisible(true);
        timer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MovingBall::new);
    }
}