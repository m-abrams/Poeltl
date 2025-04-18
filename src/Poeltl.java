public class Poeltl {
    private int state;
    private PoeltlView window;
    public Poeltl() {
        state = 0;
        this.window = new PoeltlView(this);
    }

    public int getState() {
        return state;
    }

    public static void main(String[] args) {
        Poeltl g = new Poeltl();
    }
}