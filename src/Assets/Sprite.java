package Assets;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.io.*;


public class Sprite extends JPanel {

    protected static final float ALPHA = 0.5f;

    private BufferedImage image;
    private int x;
    private int y;
    private float alpha;

    public Sprite(String file) {

        setImage(file);

        x = 0;
        y = 0;
        alpha = 1.0f;

        setOpaque(false);
        setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));

    }

    public void setImage(String file) {
        try {
            image = ImageIO.read(new File(file));
        }
        catch (IOException e) {
            System.out.println("Error in initializing Sprite BufferedImage");
        }
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public void setPosition(int[] position) {
        x = position[0];
        y = position[1];
    }

    public int[] getPosition() {
        return new int[] {x, y};
    }

    public void setAlpha(float alpha) {
        this.alpha = alpha;
        // repaint();
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2D = (Graphics2D) g;

        float[] scales = {alpha, alpha, alpha, alpha};
        float[] offsets = new float[4];

        RescaleOp rop = new RescaleOp(scales, offsets, null);

        g2D.drawImage(image, rop, x, y);
    }
}
