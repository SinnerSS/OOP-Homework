import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CompactDisc extends Disc implements Playable, Comparable<CompactDisc> {
    private String artist = null;
    private int length = 0;
    private List<Track> tracks = new ArrayList<>();
    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }
    public int getLength() {
        return length;
    }
    public CompactDisc(String title) {
        super(title);
    }
    public CompactDisc(String title, String category) {
        super(title, category);
    }
    public CompactDisc(String title, String category, String director) {
        super(title, category, director);
    }
    public CompactDisc(String title, String category, String director, int length, float cost) {
        super(title, category, director, length, cost);
    }
    public void addTrack(Track track) {
        if(tracks.contains(track)) {
            System.out.println("Track already exist");
            return;
        }
        tracks.add(track);
        length += track.getLength();

        System.out.println("Track added");
    }
    public void removeTrack(Track track) {
        if(!tracks.contains(track)) {
            System.out.println("Track dont exist");
            return;
        }
        tracks.remove(track);
        length -= track.getLength();

        System.out.println("Track removed");
    }
    @SuppressWarnings("resource")   
    public void play() {        

        Scanner enterDetector = new Scanner(System.in);
        System.out.println("Current CD: " + getTitle());

        for(Track track : tracks) {
            track.play();
            System.out.println("Press enter to skip");
            enterDetector.nextLine();
            for (int i = 0; i < 4; i++) {
                System.out.print("\r");
                System.out.print("\033[2K");
                System.out.print("\033[1A");
            }
        }
    }
    public int compareTo(CompactDisc cd) {
        if(tracks.size() > cd.tracks.size()) return 1;
        if(tracks.size() < cd.tracks.size()) return -1;
        if(length > cd.length) return 1;
        if(length < cd.length) return -1;
        return 0;
    }
}
