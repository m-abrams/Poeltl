public class Player {
    private String name;
    private String team;
    private int age;
    private double height;
    private char position;
    private String conference;


    public Player(String theName, String theTeam, int theAge, double theHeight, char thePosition, String theConference) {
        name = theName;
        team = theTeam;
        age = theAge;
        height = theHeight;
        position = thePosition;
        conference = theConference;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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


    public void setHeight(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public String getHeightFormatted(double height) {
        int feet = (int) (height / 12);
        int inches = (int) (height % 12);
        return feet + "'" + inches + "\"";
    }

    public char getPosition() {
        return position;
    }

    public void setPosition(char position) {
        this.position = position;
    }

    public String getConference() {
        return conference;
    }

    public void setConference(String conference) {
        this.conference = conference;
    }
}
