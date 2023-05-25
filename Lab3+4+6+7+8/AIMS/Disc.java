public class Disc extends Media{
    private String director = null;
    private int length = 0;
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
    public Disc(String title) {
        super(title);
    }
    public Disc(String title, String category) {
        super(title, category);
    }
    public Disc(String title, String category, String director) {
        super(title, category);
        this.director = director;
    }
    public Disc(String title, String category, String director, int length, float cost) {
        super(title, category);
        this.director = director;
        this.length = length;
        super.setCost(cost);
    }
}
