import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;


public class PoeltlView extends JFrame {
    public static final int WINDOW_WIDTH = 1600;
    public static final int WINDOW_HEIGHT = 900;
    public Poeltl poeltl;
    private Image backgroundImage;
    private Image horizDashedLine;
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
        // Watched YouTube video for try/catch block to import text
        try{
            headerFont = Font.createFont(Font.TRUETYPE_FONT, new File("Resources/ByteBounce.ttf")).deriveFont(100f);
            mainFont = Font.createFont(Font.TRUETYPE_FONT, new File("Resources/ByteBounce.ttf")).deriveFont(50f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Resources/ByteBounce.ttf")));

        }
        catch(IOException  | FontFormatException e){
        }
            g.drawImage(backgroundImage, 0, 0, this);
            g.setColor(Color.black);
            g.setFont(headerFont);
            strokeStyle(g);
            g.drawString("POELTL", 600, 150);
            g.drawRoundRect(250, 200, 1000, 100, 10, 10);
            g.setFont(mainFont);
            g.drawLine(100, 400, 1400, 400);
            drawMainLine(g);
            g.setFont(mainFont);
            g.drawString(poeltl.getTypingText(), 275, 265);
    }

    public void startGuessing(Graphics g) {
        if (poeltl.getTypingText().length() == 0) {
            g.drawImage(backgroundImage, 0, 0, this);
            g.setColor(Color.black);
            g.setFont(headerFont);
            strokeStyle(g);
            g.drawString("POELTL", 600, 150);
            g.drawRoundRect(250, 200, 1000, 100, 10, 10);
            g.drawLine(100, 400, 1400, 400);
            g.setFont(mainFont);
            drawMainLine(g);
        }
        g.setFont(mainFont);
        g.drawString(poeltl.getTypingText(), 275, 265);
    }

    public void drawMainLine(Graphics g) {
        g.drawString("Name", 150, 375);
        g.drawString("Team", 450, 375);
        g.drawString("Conference", 680, 375);
        g.drawString("Height", 1050, 375);
    }

    public void strokeStyle(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        float[] dashPattern = {10, 10, 10, 10};
        BasicStroke dashedStroke = new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dashPattern, 0.0f);
        g2d.setStroke(dashedStroke);
    }


    public void paint(Graphics g) {
        if (poeltl.getState() == 0) {
            beginGame(g);

        }
        else if (poeltl.getState() == 1) {
            startGuessing(g);
        }
    }

}
