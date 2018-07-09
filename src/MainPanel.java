import javax.swing.*;
import java.awt.*;


public class MainPanel extends JPanel {

    private Timer timer = new Timer(30, e ->  repaint());
    public MainPanel(){
        timer.start();
    }
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(ImprovedPerlinNoise.getNoiseImage(), 0, 0, this);
    }


}
