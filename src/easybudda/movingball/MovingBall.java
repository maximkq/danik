package easybudda.movingball;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MovingBall {
    private static final int WIDTH = 480;
    private static final int HEIGHT = 360;
    private static final int DIAMETER = 20;
    private static final int FREQ = 10;
    private static final Color BACKGROUND_COLOR = Color.white;


    private int x4Pos = 140;
    private final int y4Pos = 140;

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

                    bentley=ImageIO.read(new File("grass.jpg"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                bambi=bentley.getScaledInstance(50,50,Image.SCALE_SMOOTH);

                ((Graphics2D)g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                g.drawImage(bambi,x4Pos,y4Pos,this);
            }
        };
        ballPanel.setOpaque(true);
        ballPanel.setBackground(BACKGROUND_COLOR);

        Timer timer = new Timer(FREQ, ae -> {


ballPanel.repaint();
        });
        JFrame mainFrame = new JFrame("Moving Ball");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.add(ballPanel);
        mainFrame.setSize(816, 639);
        mainFrame.setVisible(true);
timer.start();

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MovingBall::new);
    }
}