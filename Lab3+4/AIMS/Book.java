import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
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
    
}
