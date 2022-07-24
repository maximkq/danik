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

    private int x1Pos = 0;
    private final int y1Pos = 550;
    private int x2Pos = 0;
    private final int y2Pos = 400;
    private int x3Pos = 0;
    private final int y3Pos = 280;
    private int x4Pos = 0;
    private final int y4Pos = 140;
    private int x5Pos = 0;
    private final int y5Pos = 40;
    String winner;
    JTextArea ji=new JTextArea();
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
                BufferedImage aston_martin;
                BufferedImage mercedes;
                BufferedImage lamborgini;
                BufferedImage bambalbi;
                Image bent;
                Image aston;
                Image mers;
                Image lambo;
                Image bambi;
                try {
                    bentley = ImageIO.read(new File("car-vehicle-Bentley-coupe-Convertible-Bentley-Continental-GT-2012-netcarshow-netcar-car-images-car-photo-Continental-GTC-Speed-wheel-land-vehicle-automotive-design-automotive-exterior-automobile-make-model.jpg"));
                    aston_martin=ImageIO.read(new File("aston_martin_v8_vantage_2008_belyy_vid_sboku_stil_aston_martin_37478_1920x1080.jpg"));
                    lamborgini=ImageIO.read(new File("1614517858_182-p-mashina-na-belom-fone-228.jpg"));
                    bambalbi=ImageIO.read(new File("26406.jpg"));
                    mercedes=ImageIO.read(new File("2016-yeni-kasa-mercedes-c63-amg-coupe-2.jpg"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                bent=bentley.getScaledInstance(120,120,Image.SCALE_SMOOTH);
                aston = aston_martin.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
                mers =mercedes.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
                bambi=bambalbi.getScaledInstance(120,120,Image.SCALE_SMOOTH);
                lambo = lamborgini.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
                ((Graphics2D)g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g.drawImage(bent,x1Pos,y1Pos,this);
                g.drawImage(aston,x2Pos,y2Pos,this);
                g.drawImage(mers,x3Pos,y3Pos,this);
                g.drawImage(bambi,x4Pos,y4Pos,this);
                g.drawImage(lambo,x5Pos,y5Pos,this);
            }
        };
        ballPanel.setOpaque(true);
        ballPanel.setBackground(BACKGROUND_COLOR);

        Timer timer = new Timer(FREQ, ae -> {
while (x1Pos!=1300||x2Pos!=1300||x3Pos!=1300||x4Pos!=1300||x5Pos!=1300){
if(x1Pos==1300||x2Pos==1300||x3Pos==1300||x4Pos==1300||x5Pos==1300){
    if (x1Pos >= 1290) {
        winner="Bentley";
        ji.setText("Winner "+winner);
        ballPanel.add(ji);
        break;
    }
    if (x2Pos >= 1290) {
        winner="Aston_martin";
        ji.setText("Winner "+winner);
        ballPanel.add(ji);
        break;
    }
    if (x3Pos >= 1290) {
        winner="Lamborgini";
        ji.setText("Winner "+winner);
        ballPanel.add(ji);
        break;
    }
    if (x4Pos >= 1290) {
        winner="Bambalbi";
        ji.setText("Winner "+winner);
        ballPanel.add(ji);
        break;
    }
    if (x5Pos >= 1290) {
        winner="Mercedes";
        ji.setText("Winner "+winner);
        ballPanel.add(ji);
        break;
    }
}
x1Pos+=1+Math.random()*4;
x2Pos+=1+Math.random()*4;
x3Pos+=1+Math.random()*4;
x4Pos+=1+Math.random()*4;
x5Pos+=1+Math.random()*4;
ballPanel.repaint();
}
        });
        JFrame mainFrame = new JFrame("Moving Ball");
        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
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