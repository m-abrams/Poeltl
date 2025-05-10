// POELTL Game by Max Abrams
import java.awt.event.*;
import java.security.Key;
import java.util.ArrayList;

public class Poeltl implements KeyListener {

    // Instance variables
    private int state;
    private String guess;
    private int numGuesses;
    private String typingText;
    private boolean hasTyped;
    private PoeltlView window;
    private Player correctPlayer;
    private boolean instructionsOn;
    private PlayerDatabase list;
    private ArrayList<Player> guessList = new ArrayList<Player>();

    // Poeltl constructor
    public Poeltl() {
        instructionsOn = true;
        numGuesses = 0;
        state = 0;
        guess = "";
        typingText = "Enter a name...";
        hasTyped = false;
        this.list = new PlayerDatabase();
        this.correctPlayer = list.getRandomPlayer();
        // Connects back end to front end
        this.window = new PoeltlView(this, this.list);
        window.addKeyListener(this);
    }

    // Getter methods
    public String getGuess() {
        return guess;
    }

    public int getNumGuesses() {
        return numGuesses;
    }

    public String getTypingText() {
        return typingText;
    }

    public Player getCorrectPlayer() {
        return correctPlayer;
    }

    public ArrayList<Player> getGuessList() {
        return guessList;
    }


    public int getState() {
        return state;
    }

    public boolean isHasTyped() {
        return hasTyped;
    }

    public boolean isInstructionsOn() {
        return instructionsOn;
    }

    public PlayerDatabase getList() {
        return list;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void setGuess(String guess) {
        this.guess = guess;
    }

    public void setNumGuesses(int numGuesses) {
        this.numGuesses = numGuesses;
    }

    public void setTypingText(String typingText) {
        this.typingText = typingText;
    }

    public void setHasTyped(boolean hasTyped) {
        this.hasTyped = hasTyped;
    }

    public void setCorrectPlayer(Player correctPlayer) {
        this.correctPlayer = correctPlayer;
    }

    public void setInstructionsOn(boolean instructionsOn) {
        this.instructionsOn = instructionsOn;
    }

    public void setList(PlayerDatabase list) {
        this.list = list;
    }

    public void setGuessList(ArrayList<Player> guessList) {
        this.guessList = guessList;
    }

    // Key typed functions
    public void keyTyped(KeyEvent e) {
        // The keyCode lets you know which key was pressed
        // If a key is pressed and a key is typed, sets has typed to true, and sets the game to the guessing state
        if(!hasTyped) {
            typingText = "";
            hasTyped = true;
            state = 1;
        }
        // If the character typed is a letter or space, adds that character to the typing text
        // Repaints the window so you can see the text update as you type
        char letter = e.getKeyChar();
        if (Character.isLetter(letter) || Character.isWhitespace(letter)) {
            typingText += letter;
            window.repaint();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // If the delete key is pressed, typing text removes final letter
        if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            if (typingText.length() > 0) {
                typingText = typingText.substring(0, typingText.length() - 1);
                window.repaint();
            }
        }
        // If the enter key is pressed, submits the current typing text as a guess
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            Player p = list.getPlayerByName(typingText.trim());
            if (p != null) {
                guess = typingText;
                guessList.add(p);
                numGuesses++;
                typingText = "";
                hasTyped = false;
                window.repaint();
            }
        }
        // If the #5 key is pressed, restarts the game
        if (e.getKeyCode() == KeyEvent.VK_5) {
            resetGame();
        }
        // If the #6 key is pressed, toggles instructions on, which either shows or hides the text for it
        if (e.getKeyCode() == KeyEvent.VK_6) {
            if (instructionsOn) {
                instructionsOn = false;
                window.repaint();
            }
            else if (!instructionsOn){
                instructionsOn = true;
                window.repaint();
            }
        }
    }
    // Reset game function, which sets all variable back to original game values and clears the screen
    public void resetGame() {
        state = 0;
        numGuesses = 0;
        instructionsOn = true;
        guess = "";
        typingText = "Enter a name...";
        hasTyped = false;
        guessList.clear();
        correctPlayer = list.getRandomPlayer();
        window.repaint();
    }


    @Override
    public void keyReleased(KeyEvent e) {

    }

    // Main method, starts new game
    public static void main(String[] args) {
        Poeltl g = new Poeltl();
    }
}