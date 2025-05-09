import java.awt.event.*;
import java.util.ArrayList;

public class Poeltl implements KeyListener {
    private int state;
    private String guess;
    private int numGuesses;
    private String typingText;
    private boolean hasTyped;
    private PoeltlView window;
    private Player correctPlayer;
    private PlayerDatabase list;
    private ArrayList<Player> guessList = new ArrayList<Player>();

    public Player getCorrectPlayer() {
        return correctPlayer;
    }

    public Poeltl() {
        numGuesses = 0;
        state = 0;
        guess = "";
        typingText = "Enter a name...";
        hasTyped = false;
        this.list = new PlayerDatabase();
        this.correctPlayer = list.getRandomPlayer();
        this.window = new PoeltlView(this, this.list);
        window.addKeyListener(this);
    }

    public String getGuess() {
        return guess;
    }

    public int getNumGuesses() {
        return numGuesses;
    }

    public String getTypingText() {
        return typingText;
    }


    public void keyTyped(KeyEvent e) {
        // The keyCode lets you know which key was pressed
        switch(e.getKeyChar()) {
            case KeyEvent.VK_DELETE:
                typingText = typingText.substring(0, typingText.length() - 1);
        }

        if(!hasTyped) {
            typingText = "";
            hasTyped = true;
            state = 1;
        }
        char letter = e.getKeyChar();
        if (Character.isLetter(letter) || Character.isWhitespace(letter)) {
            typingText += letter;
            window.repaint();
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            if (typingText.length() > 0) {
                typingText = typingText.substring(0, typingText.length() - 1);
                window.repaint();
            }
        }
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
        if (e.getKeyCode() == KeyEvent.VK_5) {
            resetGame();
        }
    }

    public void resetGame() {
        numGuesses = 0;
        guess = "";
        typingText = "Enter a name...";
        hasTyped = false;
        guessList.clear();
        correctPlayer = list.getRandomPlayer();
        state = 0;
        window.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public ArrayList<Player> getGuessList() {
        return guessList;
    }


    public int getState() {
        return state;
    }

    public static void main(String[] args) {
        Poeltl g = new Poeltl();
    }
}