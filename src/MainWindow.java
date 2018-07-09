import javax.swing.*;

public class MainWindow extends JFrame {

    public static final int WIDTH = 640;
    public static final int HEIGHT = 480;
    private MainPanel panel = new MainPanel();

    public MainWindow(){
        add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setVisible(true);


    }






}
