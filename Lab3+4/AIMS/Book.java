import java.util.ArrayList;
import java.util.List;

public class Book extends Media implements Comparable<Book> {
    private List<String> authors = new ArrayList<>();

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public boolean addAuthor(String authorName) {
        if(authors.contains(authorName)) return false;
        authors.add(authorName);
        return true;
    }

    public boolean removeAuthor(String authorName) {
        if(!authors.contains(authorName)) return false;
        authors.remove(authorName);
        return true;
    }

    public Book(String title) {
        super(title);
    }

    public Book(String title, String category) {
        super(title, category);
    }

    public Book(String title, String category, List<String> authors) {
        super(title, category);
        this.authors = authors;
    }

    public Book(String title, String category, List<String> authors, float cost) {
        super(title, category);
        this.authors = authors;
        super.setCost(cost);
    }

    public int compareTo(Book book) {
        float costDifference = this.getCost() - book.getCost();
        if (costDifference < 0) return -1; 
        if (costDifference > 0) return 1;
        return 0; 
    }
}
