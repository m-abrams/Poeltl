import java.awt.event.*;
import java.util.Scanner;

public class Poeltl implements KeyListener {
    private int state;
    private String guess;
    private String typingText = "Enter a name...";
    private boolean hasTyped;
    private PoeltlView window;
    public Poeltl() {
        state = 0;
        this.window = new PoeltlView(this);
        window.addKeyListener(this);
    }

    public String getGuess () {
        return guess;
    }

//    public void isGuessNull() {
//        if (guess.isEmpty()) {
//            state = 0;
//        }
//        else if (!guess.isEmpty()) {
//            state = 1;
//        }
//    }

    public String getTypingText() {
        return typingText;
    }

    public void addToGuess(String addLetter) {
        guess += addLetter;
    }

    public void keyTyped(KeyEvent e) {
        // The keyCode lets you know which key was pressed
        switch(e.getKeyChar()) {
            case KeyEvent.VK_DELETE:
                typingText = typingText.substring(0, typingText.length() - 1);
        }

        if(!hasTyped) {
            typingText = "";
            guess = "";
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
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


    public int getState() {
        return state;
    }

    public static void main(String[] args) {
        Poeltl g = new Poeltl();
    }
}