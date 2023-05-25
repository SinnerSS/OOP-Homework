import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Book extends Media implements Comparable<Book> {
    private List<String> authors = new ArrayList<>();
    private String content = null;
    private List<String> contentTokens = new ArrayList<>();
    private Map<String, Integer> wordFrequency = new HashMap<>();
    

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        contentTokens = Arrays.asList(content.split("\\s+|\\s?\\p{Punct}\\s?"));
        wordFrequency = new HashMap<>();
        for(String token : contentTokens) {
            if(wordFrequency.containsKey(token)){
                int count = wordFrequency.get(token);
                wordFrequency.put(token, count + 1);
            }
            wordFrequency.put(token, 1);
        }
    }

    public List<String> getContentTokens() {
        return contentTokens;
    }

    public Map<String, Integer> getWordFrequency() {
        return wordFrequency;
    }

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
