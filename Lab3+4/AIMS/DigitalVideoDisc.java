import java.util.Arrays;

public class DigitalVideoDisc extends Media{
    private String director;
    private int length;
    public String getDirector() {
        return director;
    }
    public void setDirector(String director) {
        this.director = director;
    }
    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }
    public DigitalVideoDisc(String title) {
        super(title);
    }
    public DigitalVideoDisc(String title, String category) {
        super(title, category);
    }
    public DigitalVideoDisc(String title, String category, String director) {
        super(title, category);
        this.director = director;
    }
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category);
        this.director = director;
        this.length = length;
        super.setCost(cost);
    }
    public boolean search(String title){
        String[] tokens = title.toUpperCase().split(" ");
        String[] titleTokens = this.getTitle().toUpperCase().split(" ");
        for(String token : tokens){
            if(!Arrays.asList(titleTokens).contains(token)) return false;
        }

        return true;
    }
}

