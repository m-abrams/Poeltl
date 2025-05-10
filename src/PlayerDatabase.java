// POELTL Game by Max Abrams
import java.util.ArrayList;

public class PlayerDatabase {
    // Instance variables
    private ArrayList<Player> players;

    // Player database constructor
    public PlayerDatabase() {
        players = new ArrayList();
        loadPlayers();
    }

    // Loads all the players into the game, called at the beginning of each new Poeltl instance
    public void loadPlayers() {
//WESTERN CONFERENCE

    // PACIFIC DIVISION

        // Warriors
        players.add(new Player("Stephen Curry", "GSW", 37, 75, 'G', "Pac"));
        players.add(new Player("Brandon Podziemski", "GSW", 22, 76, 'G', "Pac"));
        players.add(new Player("Jimmy Butler", "GSW", 35, 79, 'F', "Pac"));
        players.add(new Player("Draymond Green", "GSW", 35, 78, 'F', "Pac"));
        players.add(new Player("Quinten Post", "GSW", 25, 84, 'C', "Pac"));

        // Lakers
        players.add(new Player("Luka Doncic", "Lakers", 26, 78, 'G', "Pac"));
        players.add(new Player("Austin Reaves", "Lakers", 26, 77, 'G', "Pac"));
        players.add(new Player("LeBron James", "Lakers", 40, 81, 'F', "Pac"));
        players.add(new Player("Rui Hachimura", "Lakers", 27, 80, 'F', "Pac"));
        players.add(new Player("Jaxson Hayes", "Lakers", 24, 84, 'C', "Pac"));

        // Clippers
        players.add(new Player("James Harden", "Clippers", 35, 77, 'G', "Pac"));
        players.add(new Player("Kris Dunn", "Clippers", 31, 75, 'G', "Pac"));
        players.add(new Player("Kawhi Leonard", "Clippers", 33, 79, 'F', "Pac"));
        players.add(new Player("Normal Powell", "Clippers", 31, 76, 'G', "Pac"));
        players.add(new Player("Ivica Zubac", "Clippers", 28, 84, 'C', "Pac"));

        // Suns
        players.add(new Player("Devin Booker", "Suns", 28, 77, 'G', "Pac"));
        players.add(new Player("Bradley Beal", "Suns", 31, 76, 'G', "Pac"));
        players.add(new Player("Kevin Durant", "Suns", 36, 82, 'F', "Pac"));
        players.add(new Player("Grayson Allen", "Suns", 29, 76, 'G', "Pac"));
        players.add(new Player("Mason Plumlee", "Suns", 35, 82, 'C', "Pac"));

        // Kings
        players.add(new Player("Malik Monk", "Kings", 27, 75, 'G', "Pac"));
        players.add(new Player("Zach LaVine", "Kings", 30, 77, 'G', "Pac"));
        players.add(new Player("DeMar DeRozan", "Kings", 35, 78, 'F', "Pac"));
        players.add(new Player("Keegan Murray", "Kings", 24, 80, 'F', "Pac"));
        players.add(new Player("Domantas Sabonis", "Kings", 29, 83, 'C', "Pac"));

    //NORTHWEST DIVISION

        // Nuggets
        players.add(new Player("Jamal Murray", "Nuggets", 28, 76, 'G', "NW"));
        players.add(new Player("Christian Braun", "Nuggets", 23, 78, 'G', "NW"));
        players.add(new Player("Michael Porter Jr", "Nuggets", 26, 82, 'F', "NW"));
        players.add(new Player("Aaron Gordon", "Nuggets", 29, 80, 'F', "NW"));
        players.add(new Player("Nikola Jokic", "Nuggets", 30, 84, 'C', "NW"));

        // Timberwolves
        players.add(new Player("Mike Conley", "Timberwolves", 37, 73, 'G', "NW"));
        players.add(new Player("Anthony Edwards", "Timberwolves", 23, 76, 'G', "NW"));
        players.add(new Player("Jaden McDaniels", "Timberwolves", 24, 81, 'F', "NW"));
        players.add(new Player("Julius Randle", "Timberwolves", 30, 80, 'F', "NW"));
        players.add(new Player("Rudy Gobert", "Timberwolves", 32, 85, 'C', "NW"));

        // Thunder
        players.add(new Player("SGA", "Thunder", 26, 78, 'G', "NW"));
        players.add(new Player("Jalen Williams", "Thunder", 24, 78, 'G', "NW"));
        players.add(new Player("Lu Dort", "Thunder", 26, 76, 'F', "NW"));
        players.add(new Player("Chet Holmgren", "Thunder", 23, 84, 'F', "NW"));
        players.add(new Player("Isaiah Hartenstein", "Thunder", 27, 84, 'C', "NW"));

        // Jazz
        players.add(new Player("Keyonte George", "Jazz", 21, 76, 'G', "NW"));
        players.add(new Player("Collin Sexton", "Jazz", 26, 73, 'G', "NW"));
        players.add(new Player("Johnny Juzang", "Jazz", 24, 77, 'F', "NW"));
        players.add(new Player("Lauri Markkanen", "Jazz", 27, 84, 'F', "NW"));
        players.add(new Player("Walker Kessler", "Jazz", 24, 84, 'C', "NW"));

        // Trail Blazers
        players.add(new Player("Scoot Henderson", "Trail Blazers", 21, 74, 'G', "NW"));
        players.add(new Player("Anfernee Simons", "Trail Blazers", 25, 75, 'G', "NW"));
        players.add(new Player("Shaedon Sharpe", "Trail Blazers", 22, 78, 'F', "NW"));
        players.add(new Player("Jerami Grant", "Trail Blazers", 31, 80, 'F', "NW"));
        players.add(new Player("Deandre Ayton", "Trail Blazers", 27, 84, 'C', "NW"));

    // SOUTHWEST DIVISION

        // Mavericks
        players.add(new Player("Klay Thompson", "Mavericks", 35, 78, 'G', "SW"));
        players.add(new Player("Spencer Dinwiddie", "Mavericks", 32, 78, 'G', "SW"));
        players.add(new Player("Kyrie Irving", "Mavericks", 33, 74, 'G', "SW"));
        players.add(new Player("Anthony Davis", "Mavericks", 32, 82, 'F', "SW"));
        players.add(new Player("Dereck Lively II", "Mavericks", 23, 84, 'C', "SW"));

        // Grizzlies
        players.add(new Player("Ja Morant", "Grizzlies", 25, 74, 'G', "SW"));
        players.add(new Player("Desmond Bane", "Grizzlies", 26, 77, 'G', "SW"));
        players.add(new Player("Jaylen Wells", "Grizzlies", 23, 79, 'F', "SW"));
        players.add(new Player("Jaren Jackson Jr.", "Grizzlies", 25, 83, 'F', "SW"));
        players.add(new Player("Zach Edey", "Grizzlies", 23, 87, 'C', "SW"));

        // Pelicans
        players.add(new Player("Dejounte Murray", "Pelicans", 28, 76, 'G', "SW"));
        players.add(new Player("CJ McCollum", "Pelicans", 33, 75, 'G', "SW"));
        players.add(new Player("Zion Williamson", "Pelicans", 24, 78, 'F', "SW"));
        players.add(new Player("Trey Murphy", "Pelicans", 24, 80, 'F', "SW"));
        players.add(new Player("Yves Missi", "Pelicans", 21, 83, 'C', "SW"));

        // Rockets
        players.add(new Player("Fred VanVleet", "Rockets", 31, 72, 'G', "SW"));
        players.add(new Player("Jalen Green", "Rockets", 23, 76, 'G', "SW"));
        players.add(new Player("Amen Thompson", "Rockets", 22, 79, 'F', "SW"));
        players.add(new Player("Dillon Brooks", "Rockets", 29, 79, 'F', "SW"));
        players.add(new Player("Alperen Şengün", "Rockets", 22, 83, 'C', "SW"));

        // Spurs
        players.add(new Player("Chris Paul", "Spurs", 40, 72, 'G', "SW"));
        players.add(new Player("DeAaron Fox", "Spurs", 27, 75, 'G', "SW"));
        players.add(new Player("Devin Vassell", "Spurs", 24, 77, 'F', "SW"));
        players.add(new Player("Harrison Barnes", "Spurs", 32, 80, 'F', "SW"));
        players.add(new Player("Victor Wembanyama", "Spurs", 21, 88, 'C', "SW"));
    }

    // Getter and setter methods
    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    // Method is used to check if the guess is the same name as one of the players in load players
    public Player getPlayerByName(String name) {
        for (Player p: players) {
            if(p.getName().toLowerCase().equals(name.toLowerCase())) {
                return p;
            }
        }
        return null;
    }

    // Random player method, which is used to pick a correct player
    public Player getRandomPlayer() {
        int index = (int) (Math.random() * players.size());
        return players.get(index);
    }
}
