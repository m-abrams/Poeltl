import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class PoeltlView extends JFrame {
    public static final int WINDOW_WIDTH = 1600;
    public static final int WINDOW_HEIGHT = 1000;
    public static final int ARROW_SIZE = 25;
    public static final int GUESS_BOX_HEIGHT = 75;
    public static final int GUESS_BOX_WIDTH = 140;
    public static final int RESTART_X = 50;
    public static final int RESTART_BOX_DIM = 125;
    public static final int MAIN_LINE_LENGTH = 1400;
    public static final int GUESSBOX_LENGTH = 1000;
    public static final int MAIN_LINE_TEXT = 375;
    public static final int GUESSBOX_X = 250;
    public static final int GUESSBOX_Y = 200;
    public static final int GUESSBOX_HEIGHT = 100;
    public static final int MAIN_LINE_Y = 400;
    public static final int MAIN_LINE_X = 100;
    public static final int TYPING_X = 275;
    public static final int TYPING_Y = 265;
    public static final int HEIGHT_BASE_X = 900;
    public static final int AGE_BASE_X = 700;
    public static final int POSITION_BASE_X = 1100;
    public static final int TEAM_BASE_X = 450;
    public static final int NAME_BASE_X = 150;



    public Poeltl poeltl;
    public PlayerDatabase playerDatabase;
    private Image backgroundImage;
    private Image upArrow;
    private Image downArrow;
    public Font headerFont;
    public Font mainFont;
    public Font smallFont;


    public PoeltlView(Poeltl p, PlayerDatabase d) {
        this.poeltl = p;
        this.playerDatabase = d;
        backgroundImage = new ImageIcon("Resources/backgroundImage.jpeg").getImage();
        upArrow = new ImageIcon("Resources/upArrow.png").getImage();
        downArrow = new ImageIcon("Resources/downArrow.png").getImage();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Poeltl");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    public void beginGame(Graphics g) {
        // Watched YouTube video for try/catch block to import text
        try{
            File fontFile = new File("Resources/ByteBounce.ttf");
            headerFont = Font.createFont(Font.TRUETYPE_FONT, fontFile).deriveFont(100f);
            mainFont = Font.createFont(Font.TRUETYPE_FONT, fontFile).deriveFont(44f);
            smallFont = Font.createFont(Font.TRUETYPE_FONT, fontFile).deriveFont(22f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, fontFile));

        }
        catch(IOException  | FontFormatException e){
        }
            gameSetupGraphics(g);
            g.setFont(mainFont);
            g.drawString(poeltl.getTypingText(), TYPING_X, TYPING_Y);
    }


    public void startGuessing(Graphics g) {
        if (poeltl.getTypingText().length() == 0) {
            gameSetupGraphics(g);
        }

        g.setFont(mainFont);
        g.drawImage(backgroundImage, GUESSBOX_X + 2, GUESSBOX_Y + 2, GUESSBOX_LENGTH - 5, GUESSBOX_HEIGHT - 5, this);
        g.drawString(poeltl.getTypingText(), TYPING_X, TYPING_Y);
        for (int i = 0; i < poeltl.getGuessList().size(); i++) {
            // From chatGPT to change opacity of rectangle behind guess (green, yellow, or grey)
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
            Player guess = poeltl.getGuessList().get(i);
            Player correct = poeltl.getCorrectPlayer();
            int y1 = 325 + (75 * (i + 1));
            int y2 = 375 + (75 * (i + 1));
            int y3 = 350 + (75 * (i + 1));
            // Checking name
            if (correct == guess) {
                g2d.setColor(Color.GREEN);
                g2d.fillRect(100, y1, MAIN_LINE_LENGTH - 100, 75);
                g.drawString("Correct! You Win!", 700, y2);
            }
            g.drawString(guess.getName().toUpperCase(), 125, y2);


            if (correct != guess) {
                g2d.setColor(getHeightColor(correct.getHeight(), guess.getHeight()));
                g2d.fillRect(HEIGHT_BASE_X, y1, GUESS_BOX_WIDTH, GUESS_BOX_HEIGHT);
                g.drawImage(drawArrow(correct.getHeight(), guess.getHeight()), HEIGHT_BASE_X + 85, y3, ARROW_SIZE, ARROW_SIZE, this);
                g.setColor(Color.BLACK);
                g.drawString(guess.getHeightFormatted(guess.getHeight()), HEIGHT_BASE_X + 20, y2);

                g2d.setColor(getAgeColor(correct.getAge(), guess.getAge()));
                g2d.fillRect (AGE_BASE_X, y1, GUESS_BOX_WIDTH, GUESS_BOX_HEIGHT);
                g.drawImage(drawArrow(correct.getAge(), guess.getAge()), AGE_BASE_X + 70, y3, ARROW_SIZE, ARROW_SIZE,  this);
                g.setColor(Color.BLACK);
                g.drawString(Integer.toString(guess.getAge()), AGE_BASE_X + 30, y2);

                g2d.setColor(getTeamColor(correct.getConference(), guess.getConference(), correct.getTeam(), guess.getTeam()));
                g2d.fillRect(TEAM_BASE_X, y1, GUESS_BOX_WIDTH + 50, GUESS_BOX_HEIGHT);
                g.setColor(Color.BLACK);
                g.drawString(guess.getTeam(), TEAM_BASE_X + 20, y2);

                g2d.setColor(getPositionColor(correct.getPosition(), guess.getPosition()));
                g2d.fillRect(POSITION_BASE_X, y1, GUESS_BOX_WIDTH, GUESS_BOX_HEIGHT);
                g.drawImage(drawPositionArrow(correct.getPosition(), guess.getPosition()), POSITION_BASE_X + 70, y3, ARROW_SIZE, ARROW_SIZE, this);
                g.setColor(Color.BLACK);
                g.drawString(Character.toString(guess.getPosition()), POSITION_BASE_X + 40, y2);
            }

            strokeStyle(g);
            g.drawRect(100, y1, MAIN_LINE_LENGTH - 100, 75);
        }

    }

    public Color getPositionColor(char correctPos, char guessPos) {
        if (correctPos == guessPos) {
            return Color.GREEN;
        }
        else {
            return Color.GRAY;
        }
    }

    public Image drawPositionArrow(char correctPos, char guessPos) {
        if (correctPos == 'G' && guessPos == 'F') {
            return downArrow;
        }
        else if (correctPos == 'F' && guessPos == 'G') {
            return upArrow;
        }
        else if (correctPos == 'C' && guessPos == 'G') {
            return upArrow;
        }
        else if (correctPos == 'G' && guessPos == 'C') {
            return downArrow;
        }
        else if (correctPos == 'F' && guessPos == 'C') {
            return downArrow;
        }
        else if (correctPos == 'C' && guessPos == 'F') {
            return upArrow;
        }
        else {
            return null;
        }
    }

    public Color getTeamColor(String correctConf, String guessConf, String correctTeam, String guessTeam) {
        if (correctTeam.equals(guessTeam)) {
            return Color.GREEN;
        }
        else if (correctConf.equals(guessConf)) {
            return Color.YELLOW;
        }
        else {
            return Color.GRAY;
        }
    }

    public Color getAgeColor(int correctAge, int guessAge) {
        if (correctAge == guessAge) {
            return Color.GREEN;
        }
        else if (guessAge + 1 == correctAge || guessAge + 2 == correctAge) {
            return Color.YELLOW;
        }
        else if (guessAge - 1 == correctAge || guessAge - 2 == correctAge) {
            return Color.YELLOW;
        }
        else {
            return Color.GRAY;
        }
    }

    public Color getHeightColor(double correctHeight, double guessHeight) {
        if (correctHeight == guessHeight) {
            return Color.GREEN;
        }
        else if (guessHeight + 1.0 == correctHeight || guessHeight + 2.0 == correctHeight) {
            return Color.YELLOW;
        }
        else if (guessHeight - 1.0 == correctHeight || guessHeight - 2.0 == correctHeight) {
            return Color.YELLOW;
        }
        else {
            return Color.GRAY;
        }
    }

    public Image drawArrow(double correctVal, double guessVal) {
        if (correctVal > guessVal) {
            return upArrow;
        }
        else if (correctVal < guessVal) {
            return downArrow;
        }
        else {
            return null;
        }
    }

    // Draws main line that shows the attributes of
    public void drawMainLine(Graphics g) {
        g.drawString("Name", NAME_BASE_X, MAIN_LINE_TEXT);
        g.drawString("Team", TEAM_BASE_X, MAIN_LINE_TEXT);
        g.drawString("Age", AGE_BASE_X, MAIN_LINE_TEXT);
        g.drawString("Height", HEIGHT_BASE_X, MAIN_LINE_TEXT);
        g.drawString("Position", POSITION_BASE_X, MAIN_LINE_TEXT);
    }

    // From Stack Overflow to make lines dashed
    public void strokeStyle(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        float[] dashPattern = {10, 10, 10, 10};
        BasicStroke dashedStroke = new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dashPattern, 0.0f);
        g2d.setStroke(dashedStroke);
    }

    // Basic graphic setup that shows all of the text and shapes at the beginning of the game
    public void gameSetupGraphics(Graphics g) {
        g.drawImage(backgroundImage, 0, 0, this);
        g.setColor(Color.black);
        g.setFont(headerFont);
        strokeStyle(g);
        g.drawString("POELTL", 600, 150);
        g.drawRoundRect(GUESSBOX_X, GUESSBOX_Y, GUESSBOX_LENGTH, GUESSBOX_HEIGHT, 10, 10);
        g.setFont(mainFont);
        g.drawLine(MAIN_LINE_X, MAIN_LINE_Y, MAIN_LINE_LENGTH, MAIN_LINE_Y);
        drawMainLine(g);
        g.setColor(Color.RED);
        g.setFont(smallFont);
        g.fillRect(RESTART_X / 2, RESTART_X / 2, RESTART_BOX_DIM, RESTART_BOX_DIM);
        g.setColor(Color.BLACK);
        g.drawString("Press 5 ", RESTART_X, 75);
        g.drawString("to Restart", RESTART_X, 100);
        g.drawString("Game", RESTART_X, 125);
    }

    // Paint function, changes between opening screen and when user has began typing
    public void paint(Graphics g) {
        if (poeltl.getState() == 0) {
            beginGame(g);

        }
        else if (poeltl.getState() == 1) {
            startGuessing(g);
        }
    }

}
