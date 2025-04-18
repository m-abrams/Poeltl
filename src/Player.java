public class Player {
    private String team;
    private int age;
    private double height;
    private char position;

    public Player(String theTeam, int theAge, double theHeight, char thePosition) {
        team = theTeam;
        age = theAge;
        height = theHeight;
        position = thePosition;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public char getPosition() {
        return position;
    }

    public void setPosition(char position) {
        this.position = position;
    }
}
