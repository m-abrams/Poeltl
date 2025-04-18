import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.IOException;


public class PoeltlView extends JFrame {
    public static final int WINDOW_WIDTH = 1600;
    public static final int WINDOW_HEIGHT = 900;
    public Poeltl poeltl;
    private Image backgroundImage;
    public Font headerFont;
    public Font mainFont;



    public PoeltlView(Poeltl p) {
        this.poeltl = p;
        backgroundImage = new ImageIcon("Resources/backgroundImage.jpeg").getImage();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Poeltl");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    public void beginGame(Graphics g) {
        try{
            headerFont = Font.createFont(Font.TRUETYPE_FONT, new File("Resources/ByteBounce.ttf")).deriveFont(100f);
            mainFont = Font.createFont(Font.TRUETYPE_FONT, new File("Resources/ByteBounce.ttf")).deriveFont(44f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Resources/ByteBounce.ttf")));

        }
        catch(IOException  | FontFormatException e){
        }
        g.drawImage(backgroundImage, 0, 0, this);
        g.setColor(Color.black);
        g.setFont(headerFont);
        g.drawString("POELTL", 600, 150);
        g.drawRoundRect(250, 200, 1000, 100, 10, 10);
        g.setFont(mainFont);
        g.drawString("Enter a name...", 275, 260);
    }

    public void paint(Graphics g) {
        if (poeltl.getState() == 0) {
            beginGame(g);
        }
    }

}
