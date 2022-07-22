package easybudda.movingball;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MovingBall {
    private static final int WIDTH = 480;
    private static final int HEIGHT = 360;
    private static final int DIAMETER = 20;
    private static final int FREQ = 10;
    private static final Color BACKGROUND_COLOR = Color.BLACK;

    private int xPos = 0;
    private int yPos = 0;
    private int dX = -1;
    private int dY = -1;
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
                BufferedImage img;
                Image scaled;

                try {
                    img = ImageIO.read(new File("80861-dvd-logo-transparent-background-dvd-logo-11563629290nwhsn0hmkt.png"));
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

        Timer timer = new Timer(FREQ, new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if ( xPos < 1 || xPos + DIAMETER > WIDTH - 1 )
                    dX *= -1;
                if ( yPos < 1 || yPos > HEIGHT - DIAMETER - 1 )
                    dY *= -1;
                xPos += dX;
                yPos += dY;
                ballPanel.repaint();
            }
        });
        JFrame mainFrame = new JFrame("Moving Ball");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.add(ballPanel);
        mainFrame.setSize(WIDTH, HEIGHT + DIAMETER);
        mainFrame.setVisible(true);
timer.start();

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MovingBall::new);
    }
}