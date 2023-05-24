import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CompactDisc extends Disc implements Playable {
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
    //TODO: reformat play output
    @SuppressWarnings("resource")   
    public void play() {        

        Scanner enterDetector = new Scanner(System.in);
        System.out.println("Current CD: " + getTitle());

        for(Track track : tracks) {
            track.play();
            System.out.println("Press enter to skip");
            enterDetector.nextLine();

        }
    }
}
