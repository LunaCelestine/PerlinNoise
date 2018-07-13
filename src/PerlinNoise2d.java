import java.awt.image.BufferedImage;

public class PerlinNoise2d {

    private static double time = 0;
    private static BufferedImage image = new BufferedImage(MainWindow.WIDTH, MainWindow.HEIGHT, BufferedImage.TYPE_INT_RGB);
    public static BufferedImage getNoiseImage(){
        time += 0.01;
        for(int y = 0; y < MainWindow.HEIGHT; y++){
            for(int x = 0; x < MainWindow.WIDTH; x++){
                double dx = (double) x / MainWindow.HEIGHT;
                double dy = (double) y / MainWindow.WIDTH;

                //double noise = noise(dx, dy, 4);

                int frequency = 12;
                // Increasing frequency increase granularity of noise
                //double noise = noise(dx * frequency, dy * frequency);

                // Adding time to input values creates various motion effects
                double noise = noise((dx * frequency) + time, (dy * frequency) + time);
                //double noise = noise(dx * time, dy *time, time);
                //double noise = noise(dx * frequency + time, dy * frequency + time);

                noise = (noise - 1) / 2;
                int b = (int)(noise *0xFF) ;
                int g = b * 0x100;
                int r = b * 0x10000;
                int finalValue = r;
                image.setRGB(x, y , finalValue);
            }
        }
        return image;
    }

    private static double noise(double x, double y){
        // Find the square in the grid of squares containing the point
        // Bind the input values to the range 0 to 255 using bitwise AND operation
        // Example (int) Math.floor(346) & 255 == 90
        int xi = (int) Math.floor(x) & 255;
        int yi = (int) Math.floor(y) & 255;

        // Use the bounding 4 gradient vector origin points as indexes to the permutation array
        // This ensures that the same gradient value is retrieved for all points within a given square
        int gradientVec1 = p[p[xi] + yi]; // Bottom left gradient
        int gradientVec2 = p[p[xi + 1] + yi]; // Bottom right gradient
        int gradientVec3 = p[p[xi] + yi + 1]; // Top left gradient
        int gradientVec4 = p[p[xi + 1] + yi +1]; // Top right gradient

        // Find the value of x and y relative to grid square
        double xf = x - Math.floor(x);
        double yf = y - Math.floor(y);

        // Calculate dot products of Gradient Vector X Distance Vector
        double dProduct1 = dotProduct(gradientVec1, xf, yf);
        double dProduct2 = dotProduct(gradientVec2, xf - 1, yf);
        double dProduct3 = dotProduct(gradientVec3, xf, yf - 1);
        double dProduct4 = dotProduct(gradientVec4, xf -1, yf -1);

        // Apply fade function to the distance vector values
        double u = fade(xf);
        double v = fade(yf);

        // Apply bilinear interpolation to the
        double x1Interpolated = linearInterpolation(u, dProduct1, dProduct2);
        double x2Interpolated = linearInterpolation(u, dProduct3, dProduct4);
        double yInterpolated = linearInterpolation(v, x1Interpolated, x2Interpolated);

        return yInterpolated;
    }

    private static double linearInterpolation( double amount, double left, double right){

        return((1 - amount) * left + amount * right);
    }

    private static double fade(double t){

        // Fade function is used to make the noise look more natural when using linear interpolation
        // It has the form 6t^5 - 15t^4 + 10t^3
        return t * t * t * (t * (t * 6 - 15) + 10);
    }
    private static double dotProduct(int hash, double x, double y){
        switch(hash & 3){
            case 0: return x + y;
            case 1: return -x + y;
            case 2: return x - y;
            case 3: return -x - y;
            default: return 0;
        }
    }

    // Permutation Table
    // This table is the reason why Perlin Noise does not need a random function
    // It consists of an int[512] filled with randomly selected numbers between 0 and 255
    // This is what makes the algorithm pseudorandom

    static final int p[] = new int[512], permutation[] = { 151,160,137,91,90,15,
            131,13,201,95,96,53,194,233,7,225,140,36,103,30,69,142,8,99,37,240,21,10,23,
            190, 6,148,247,120,234,75,0,26,197,62,94,252,219,203,117,35,11,32,57,177,33,
            88,237,149,56,87,174,20,125,136,171,168, 68,175,74,165,71,134,139,48,27,166,
            77,146,158,231,83,111,229,122,60,211,133,230,220,105,92,41,55,46,245,40,244,
            102,143,54, 65,25,63,161, 1,216,80,73,209,76,132,187,208, 89,18,169,200,196,
            135,130,116,188,159,86,164,100,109,198,173,186, 3,64,52,217,226,250,124,123,
            5,202,38,147,118,126,255,82,85,212,207,206,59,227,47,16,58,17,182,189,28,42,
            223,183,170,213,119,248,152, 2,44,154,163, 70,221,153,101,155,167, 43,172,9,
            129,22,39,253, 19,98,108,110,79,113,224,232,178,185, 112,104,218,246,97,228,
            251,34,242,193,238,210,144,12,191,179,162,241, 81,51,145,235,249,14,239,107,
            49,192,214, 31,181,199,106,157,184, 84,204,176,115,121,50,45,127, 4,150,254,
            138,236,205,93,222,114,67,29,24,72,243,141,128,195,78,66,215,61,156,180
    };
    static { for (int i=0; i < 256 ; i++) p[256+i] = p[i] = permutation[i]; }

}

