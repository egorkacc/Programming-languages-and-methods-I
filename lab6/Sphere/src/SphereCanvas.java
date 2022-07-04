import javax.swing.*;
import java.awt.*;

public class SphereCanvas extends JPanel {
    private JSpinner spinner2;
    private int diameter = 200;
    private int height = 100;

    public void setDiameter(int d) {
        diameter = d;
        repaint();
    }

    public void setHeight(int k) {
        height = k;
        repaint();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int diff = 0;
        for(int i = 0; i < 200; i++) {
            g.setColor(Color.DARK_GRAY);
            g.drawOval(0, 2*i, diameter, diameter - 4*i);
            g.setColor(Color.BLUE);
            g.fillOval(0, 2*i, diameter, diameter - 4*i);
            if(height >= 50 && height < 100) {
                diff = 99 - height;
                g.setColor(Color.WHITE);
                g.drawArc(0, 2*i, diameter, diameter - 4*i,0, 180);
            }
            if(height < 50) {
                diff = 49 - height;
                g.setColor(Color.WHITE);
                g.drawArc(0, 2*i, diameter, diameter - 4*i,180, 360);
            }

        }
    }
}