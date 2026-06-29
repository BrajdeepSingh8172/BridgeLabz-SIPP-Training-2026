import java.util.LinkedList;

public class MusicPlaylistEngine {
    private LinkedList<String> recentlyPlayed = new LinkedList<>();
    private final int MAX_SIZE = 10;

    public void playSong(String songTitle) {
        recentlyPlayed.remove(songTitle);
        recentlyPlayed.addFirst(songTitle);
        if (recentlyPlayed.size() > MAX_SIZE) {
            recentlyPlayed.removeLast();
        }
        System.out.println("Playing: " + songTitle);
    }

    public boolean isSongInHistory(String songTitle) {
        return recentlyPlayed.contains(songTitle);
    }

    public void displayHistory() {
        System.out.println("--- Recently Played History ---");
        for (String song : recentlyPlayed) {
            System.out.println(song);
        }
        System.out.println("Total Songs in History: " + recentlyPlayed.size());
    }

    public static void main(String[] args) {
        MusicPlaylistEngine engine = new MusicPlaylistEngine();
        
        for (int i = 1; i <= 11; i++) {
            engine.playSong("Song " + i);
        }
        
        System.out.println();
        engine.displayHistory();
        
        System.out.println("\nIs 'Song 5' in history? " + engine.isSongInHistory("Song 5"));
        System.out.println("Is 'Song 1' in history? " + engine.isSongInHistory("Song 1"));
        
        System.out.println();
        engine.playSong("Song 3");
        engine.displayHistory();
    }
}