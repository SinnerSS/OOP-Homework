public class Track implements Playable, Comparable<Track> {
    private String title = null;
    private int length = 0;
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }
    public void play() {
        System.out.println("Playing track: " + title);
        System.out.println("Track length: " + length);
    }
    public int compareTo(Track track) {
        return title.charAt(0) - track.title.charAt(0);
    }
}
