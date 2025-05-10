// POELTL Game by Max Abrams
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class PoeltlView extends JFrame {

    // All magic numbers
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
    public static final int INSTRUCTIONS_X = 890;


    // Instance variables
    public Poeltl poeltl;
    public PlayerDatabase playerDatabase;
    private Image backgroundImage;
    private Image upArrow;
    private Image downArrow;
    public Font headerFont;
    public Font mainFont;
    public Font smallFont;

    // Poeltl view constructor
    public PoeltlView(Poeltl p, PlayerDatabase d) {
        // Connecting front end to back end
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
            // Draws all graphics that appear at the beginning of the game

        gameSetupGraphics(g);
        if (poeltl.isInstructionsOn()) {
            drawInstructions(g);
        }
        g.setFont(mainFont);
        g.drawString(poeltl.getTypingText(), TYPING_X, TYPING_Y);
    }


    public void startGuessing(Graphics g) {
        // Draws instructions if they are not hidden

        // From chatGPT to change opacity of rectangle behind guess (green, yellow, or grey)
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
        boolean hasLost = false;
        // If the current typing text is empty, set all graphics to the basic graphics
        if (poeltl.getTypingText().length() == 0) {
            gameSetupGraphics(g);
        }
        if (poeltl.isInstructionsOn()) {
            drawInstructions(g);
        }
        // Repaints the guess box each time so the letter added to guess is shown (without overlapping)
        g.setFont(mainFont);
        g.drawImage(backgroundImage, GUESSBOX_X + 2, GUESSBOX_Y + 2, GUESSBOX_LENGTH - 5, GUESSBOX_HEIGHT - 5, this);
        g.drawString(poeltl.getTypingText(), TYPING_X, TYPING_Y);

        for (int i = 0; i < poeltl.getGuessList().size(); i++) {
            // Setting the guess and correct player
            Player guess = poeltl.getGuessList().get(i);
            Player correct = poeltl.getCorrectPlayer();

            // Different Y values for the attribute text and rectangles
            int y1 = 325 + (75 * (i + 1));
            int y2 = 375 + (75 * (i + 1));
            int y3 = 350 + (75 * (i + 1));
            // Checking name
            if (correct == guess) {
                // Makes guess box green and prints you win if the correct player is guessed
                g2d.setColor(Color.GREEN);
                g2d.fillRect(100, y1, MAIN_LINE_LENGTH - 100, 75);
                g.drawString("Correct! You Win!", 700, y2);
            }
            g.drawString(guess.getName().toUpperCase(), 125, y2);

            // If the guess was not correct...
            if (correct != guess && poeltl.getNumGuesses() != 7) {
                // Prints the height of the guessed player + uses the helper methods to find the rectangle color and arrow
                g2d.setColor(getRectColor(correct.getHeight(), guess.getHeight()));
                g2d.fillRect(HEIGHT_BASE_X, y1, GUESS_BOX_WIDTH, GUESS_BOX_HEIGHT);
                g.drawImage(drawArrow(correct.getHeight(), guess.getHeight()), HEIGHT_BASE_X + 85, y3, ARROW_SIZE, ARROW_SIZE, this);
                g.setColor(Color.BLACK);
                g.drawString(guess.getHeightFormatted(guess.getHeight()), HEIGHT_BASE_X + 20, y2);
                // Prints the age of the guessed player + uses the helper methods to find the rectangle color and arrow
                g2d.setColor(getRectColor(correct.getAge(), guess.getAge()));
                g2d.fillRect (AGE_BASE_X, y1, GUESS_BOX_WIDTH, GUESS_BOX_HEIGHT);
                g.drawImage(drawArrow(correct.getAge(), guess.getAge()), AGE_BASE_X + 70, y3, ARROW_SIZE, ARROW_SIZE,  this);
                g.setColor(Color.BLACK);
                g.drawString(Integer.toString(guess.getAge()), AGE_BASE_X + 30, y2);
                // Prints the team of the guessed player + uses the helper methods to find if the division is correct
                g2d.setColor(getTeamColor(correct.getConference(), guess.getConference(), correct.getTeam(), guess.getTeam()));
                g2d.fillRect(TEAM_BASE_X, y1, GUESS_BOX_WIDTH + 50, GUESS_BOX_HEIGHT);
                g.setColor(Color.BLACK);
                g.drawString(guess.getTeam(), TEAM_BASE_X + 20, y2);
                // Prints the position of the guessed player + uses the helper methods to find the rectangle color and arrow
                g2d.setColor(getPositionColor(correct.getPosition(), guess.getPosition()));
                g2d.fillRect(POSITION_BASE_X, y1, GUESS_BOX_WIDTH, GUESS_BOX_HEIGHT);
                g.drawImage(drawPositionArrow(correct.getPosition(), guess.getPosition()), POSITION_BASE_X + 70, y3, ARROW_SIZE, ARROW_SIZE, this);
                g.setColor(Color.BLACK);
                g.drawString(Character.toString(guess.getPosition()), POSITION_BASE_X + 40, y2);
            }
            // If user has not guessed correctly after 7 guesses, sets has lost to true
            else if (correct != guess && poeltl.getNumGuesses() == 7) {
                hasLost = true;
            }
            g.drawString(guess.getName().toUpperCase(), 125, y2);

            strokeStyle(g);
            g.drawRect(100, y1, MAIN_LINE_LENGTH - 100, 75);
        }
        // Makes the final guess box red and prints you lost once hasLost is set to true
        if (hasLost) {
            g2d.setColor(Color.RED);
            g2d.fillRect(100, 850, MAIN_LINE_LENGTH - 100, 75);
            g.drawString("You Lost!", 700, 900);
        }

    }

    // Helper function to figure out what color goes behind the guessed players position attribute
    public Color getPositionColor(char correctPos, char guessPos) {
        // If positions of the guessed player and correct player are the same, make the rectangle green
        if (correctPos == guessPos) {
            return Color.GREEN;
        }
        // If they are not, make them grey
        else {
            return Color.GRAY;
        }
    }

    // Draws the up or down arrow based on if your guessed players position is below or above the correct players
    public Image drawPositionArrow(char correctPos, char guessPos) {
        // If guessed player is a forward and correct player is a guard, return the down arrow
        if (correctPos == 'G' && guessPos == 'F') {
            return downArrow;
        }
        // If guessed player is a gaurd and correct player is a forward, return the up arrow
        else if (correctPos == 'F' && guessPos == 'G') {
            return upArrow;
        }
        // If guessed player is a guard and correct player is a center, return the up arrow
        else if (correctPos == 'C' && guessPos == 'G') {
            return upArrow;
        }
        // If guessed player is a center and correct player is a guard, return the down arrow
        else if (correctPos == 'G' && guessPos == 'C') {
            return downArrow;
        }
        // If guessed player is a center and correct player is a forward, return the down arrow
        else if (correctPos == 'F' && guessPos == 'C') {
            return downArrow;
        }
        // If guessed player is a forward and correct player is a center, return the up arrow
        else if (correctPos == 'C' && guessPos == 'F') {
            return upArrow;
        }
        else {
            return null;
        }
    }

    public void drawInstructions(Graphics g) {
        g.setFont(smallFont);
        g.drawString(" The objective of the game is to guess a randomly selected western", INSTRUCTIONS_X, 20);
        g.drawString(" conference NBA starter. Enter the full name of a player. If the age or", INSTRUCTIONS_X, 40);
        g.drawString(" height are grey, that means the guessed player is 3 or more years/inches", INSTRUCTIONS_X, 60);
        g.drawString(" away. If it is yellow you are 1-2 years/inches off. If it is green the", INSTRUCTIONS_X, 80);
        g.drawString(" height/age is correct. If the team is grey, the player is in a different", INSTRUCTIONS_X, 100);
        g.drawString(" division. If it is yellow they are in same division, if it is green they", INSTRUCTIONS_X, 120);
        g.drawString(" are on the same team. If the position is grey, it is a different position.", INSTRUCTIONS_X, 140);
        g.drawString(" If it is green, the position is correct. The arrows will give you a hint", INSTRUCTIONS_X, 160);
        g.drawString(" of which direction to guess towards. You will get 7 guesses. Good luck!", INSTRUCTIONS_X, 180);
    }
    // Helper function to figure out what color goes behind the guessed players team attribute
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

    // Helper function to figure out what color goes behind the guessed players height or age
    public Color getRectColor(double correctVal, double guessVal) {
        // If correct player and guess have the same height or age, make rectangle color green
        if (correctVal == guessVal) {
            return Color.GREEN;
        }
        // If the guessed player's height or age is within 1 or 2 inches of the correct player, make rectangle yellow
        else if (guessVal + 1.0 == correctVal || guessVal + 2.0 == correctVal) {
            return Color.YELLOW;
        }
        else if (guessVal - 1.0 == correctVal || guessVal - 2.0 == correctVal) {
            return Color.YELLOW;
        }
        // If the guessed player's height or age is more or less than 2 inches from the correct players, make rectangle color grey
        else {
            return Color.GRAY;
        }
    }

    // Drawing the arrow for age and height
    public Image drawArrow(double correctVal, double guessVal) {
        // If your guesses age or height is less than the correct players, returns the up arrow
        if (correctVal > guessVal) {
            return upArrow;
        }
        // If your guesses age or height is more than the correct players, returns the down arrow
        else if (correctVal < guessVal) {
            return downArrow;
        }
        // If your guesses height or age is the same as the correct players, no arrow is needed
        else {
            return null;
        }
    }

    // Draws main line that shows the attributes being checked
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
        g.setColor(Color.black);
        g.setFont(smallFont);
        // Draws the solid background color
        g.drawImage(backgroundImage, 0, 0, this);
        g.drawString("Press 6 to show or ", MAIN_LINE_LENGTH - 100, GUESSBOX_Y + 50);
        g.drawString("hide instructions", MAIN_LINE_LENGTH - 100, GUESSBOX_Y + 70);

        g.setFont(headerFont);
        strokeStyle(g);
        g.drawString("POELTL", 600, 150);
        // Drawing guess box
        g.drawRoundRect(GUESSBOX_X, GUESSBOX_Y, GUESSBOX_LENGTH, GUESSBOX_HEIGHT, 10, 10);
        g.setFont(mainFont);
        // Draws line and text for main line that displays attributes being guessed
        g.drawLine(MAIN_LINE_X, MAIN_LINE_Y, MAIN_LINE_LENGTH, MAIN_LINE_Y);
        drawMainLine(g);
        g.setColor(Color.RED);
        g.setFont(smallFont);
        // Draws the restart box and text
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
