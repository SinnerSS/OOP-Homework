import java.util.Arrays;

public class DigitalVideoDisc extends Disc{
    public DigitalVideoDisc(String title) {
        super(title);
    }
    public DigitalVideoDisc(String title, String category) {
        super(title, category);
    }
    public DigitalVideoDisc(String title, String category, String director) {
        super(title, category, director);

    }
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, director, length, cost);
    }
    public boolean search(String title){
        String[] tokens = title.toUpperCase().split(" ");
        String[] titleTokens = this.getTitle().toUpperCase().split(" ");
        for(String token : tokens){
            if(!Arrays.asList(titleTokens).contains(token)) return false;
        }

        return true;
    }
    public void play() {
        System.out.println("Playing DVD: " + getTitle());
        System.out.println("DVD length: " + getLength());
    }
}

