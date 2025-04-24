import java.util.ArrayList;

public class PlayerDatabase {
    private ArrayList<Player> players;

    public PlayerDatabase() {
        players = new ArrayList();
        loadPlayers();
    }

    private void loadPlayers() {

//WESTERN CONFERENCE

    // PACIFIC DIVISION

        // Warriors
        players.add(new Player("Stephen Curry", "Warriors", 37, 75, 'G'));
        players.add(new Player("Klay Thompson", "Warriors", 34, 78, 'G'));
        players.add(new Player("Andrew Wiggins", "Warriors", 29, 79, 'F'));
        players.add(new Player("Draymond Green", "Warriors", 35, 78, 'F'));
        players.add(new Player("Kevon Looney", "Warriors", 29, 81, 'C'));

        // Lakers
        players.add(new Player("D'Angelo Russell", "Lakers", 28, 76, 'G'));
        players.add(new Player("Austin Reaves", "Lakers", 26, 77, 'G'));
        players.add(new Player("LeBron James", "Lakers", 40, 81, 'F'));
        players.add(new Player("Rui Hachimura", "Lakers", 27, 80, 'F'));
        players.add(new Player("Anthony Davis", "Lakers", 32, 82, 'C'));

        // Clippers
        players.add(new Player("James Harden", "Clippers", 35, 77, 'G'));
        players.add(new Player("Paul George", "Clippers", 34, 80, 'G'));
        players.add(new Player("Kawhi Leonard", "Clippers", 33, 79, 'F'));
        players.add(new Player("Amir Coffey", "Clippers", 27, 79, 'F'));
        players.add(new Player("Ivica Zubac", "Clippers", 28, 84, 'C'));

        // Suns
        players.add(new Player("Devin Booker", "Suns", 28, 77, 'G'));
        players.add(new Player("Bradley Beal", "Suns", 31, 76, 'G'));
        players.add(new Player("Kevin Durant", "Suns", 36, 82, 'F'));
        players.add(new Player("Grayson Allen", "Suns", 29, 76, 'F'));
        players.add(new Player("Jusuf Nurkić", "Suns", 30, 84, 'C'));

        // Kings
        players.add(new Player("De'Aaron Fox", "Kings", 27, 75, 'G'));
        players.add(new Player("Kevin Huerter", "Kings", 26, 77, 'G'));
        players.add(new Player("Harrison Barnes", "Kings", 32, 80, 'F'));
        players.add(new Player("Keegan Murray", "Kings", 24, 80, 'F'));
        players.add(new Player("Domantas Sabonis", "Kings", 29, 83, 'C'));

    //NORTHWEST DIVISION

        // Nuggets
        players.add(new Player("Jamal Murray", "Nuggets", 28, 76, 'G'));
        players.add(new Player("Kentavious Caldwell-Pope", "Nuggets", 32, 77, 'G'));
        players.add(new Player("Michael Porter Jr.", "Nuggets", 26, 82, 'F'));
        players.add(new Player("Aaron Gordon", "Nuggets", 29, 80, 'F'));
        players.add(new Player("Nikola Jokic", "Nuggets", 30, 84, 'C'));

        // Timberwolves
        players.add(new Player("Mike Conley", "Timberwolves", 37, 73, 'G'));
        players.add(new Player("Anthony Edwards", "Timberwolves", 23, 76, 'G'));
        players.add(new Player("Jaden McDaniels", "Timberwolves", 24, 81, 'F'));
        players.add(new Player("Karl-Anthony Towns", "Timberwolves", 29, 83, 'F'));
        players.add(new Player("Rudy Gobert", "Timberwolves", 33, 85, 'C'));

        // Thunder
        players.add(new Player("Shai Gilgeous-Alexander", "Thunder", 26, 78, 'G'));
        players.add(new Player("Josh Giddey", "Thunder", 22, 80, 'G'));
        players.add(new Player("Luguentz Dort", "Thunder", 26, 76, 'F'));
        players.add(new Player("Jalen Williams", "Thunder", 23, 78, 'F'));
        players.add(new Player("Chet Holmgren", "Thunder", 23, 85, 'C'));

        // Jazz
        players.add(new Player("Keyonte George", "Jazz", 21, 76, 'G'));
        players.add(new Player("Jordan Clarkson", "Jazz", 33, 76, 'G'));
        players.add(new Player("Lauri Markkanen", "Jazz", 27, 84, 'F'));
        players.add(new Player("John Collins", "Jazz", 27, 81, 'F'));
        players.add(new Player("Walker Kessler", "Jazz", 23, 85, 'C'));

        // Trail Blazers
        players.add(new Player("Scoot Henderson", "Trail Blazers", 21, 74, 'G'));
        players.add(new Player("Anfernee Simons", "Trail Blazers", 25, 75, 'G'));
        players.add(new Player("Shaedon Sharpe", "Trail Blazers", 22, 78, 'F'));
        players.add(new Player("Jerami Grant", "Trail Blazers", 31, 80, 'F'));
        players.add(new Player("Deandre Ayton", "Trail Blazers", 27, 84, 'C'));

    // SOUTHWEST DIVISION

        // Mavericks
        players.add(new Player("Luka Doncic", "Mavericks", 26, 79, 'G'));
        players.add(new Player("Kyrie Irving", "Mavericks", 33, 74, 'G'));
        players.add(new Player("Josh Green", "Mavericks", 24, 77, 'F'));
        players.add(new Player("P.J. Washington", "Mavericks", 26, 79, 'F'));
        players.add(new Player("Dereck Lively II", "Mavericks", 21, 85, 'C'));

        // Grizzlies
        players.add(new Player("Ja Morant", "Grizzlies", 25, 75, 'G'));
        players.add(new Player("Desmond Bane", "Grizzlies", 26, 77, 'G'));
        players.add(new Player("Ziaire Williams", "Grizzlies", 23, 80, 'F'));
        players.add(new Player("Jaren Jackson Jr.", "Grizzlies", 25, 83, 'F'));
        players.add(new Player("Brandon Clarke", "Grizzlies", 28, 80, 'C'));

        // Pelicans
        players.add(new Player("CJ McCollum", "Pelicans", 33, 75, 'G'));
        players.add(new Player("Herbert Jones", "Pelicans", 26, 79, 'G'));
        players.add(new Player("Brandon Ingram", "Pelicans", 27, 81, 'F'));
        players.add(new Player("Zion Williamson", "Pelicans", 25, 78, 'F'));
        players.add(new Player("Jonas Valanciunas", "Pelicans", 33, 84, 'C'));

        // Rockets
        players.add(new Player("Fred VanVleet", "Rockets", 31, 72, 'G'));
        players.add(new Player("Jalen Green", "Rockets", 23, 76, 'G'));
        players.add(new Player("Dillon Brooks", "Rockets", 29, 79, 'F'));
        players.add(new Player("Jabari Smith Jr.", "Rockets", 22, 82, 'F'));
        players.add(new Player("Alperen Sengun", "Rockets", 23, 83, 'C'));

        // Spurs
        players.add(new Player("Tre Jones", "Spurs", 25, 74, 'G'));
        players.add(new Player("Devin Vassell", "Spurs", 24, 77, 'G'));
        players.add(new Player("Keldon Johnson", "Spurs", 25, 78, 'F'));
        players.add(new Player("Jeremy Sochan", "Spurs", 22, 80, 'F'));
        players.add(new Player("Victor Wembanyama", "Spurs", 21, 88, 'C'));
    }

    private ArrayList<Player> getPlayers() {
        return players;
    }

    public Player getRandomPlayer() {
        int index = (int) (Math.random() * players.size());
        return players.get(index);
    }
}
