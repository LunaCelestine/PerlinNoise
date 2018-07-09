import javax.swing.*;

public class Main {

    public static void main(String[] args){


        SwingUtilities.invokeLater(new Runnable(){

            @Override
            public void run() {
                new MainWindow();
            }
        });
        /*PerlinNoise.noise(0.1, 0.1, 0.1);
        System.out.println(PerlinNoise.noise(0.1, 0.1, 0.1));*/


    }





}
