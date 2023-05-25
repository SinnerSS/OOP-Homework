import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;

public class Order {
    public static final int MAX_NUMBER_ORDER = 10;
    public static final int MAX_LIMITED_ORDER = 5;

    public static int nbOrders = 0;

    //TODO: refactor to use hashmap for itemsOrdered
    private List<Media> itemsOrdered = new ArrayList<>();

    private String dateOrdered = null;

    static final AtomicLong NEXT_ID = new AtomicLong(1000);
    final long id = NEXT_ID.getAndIncrement();
    

    public Order() {
        if(nbOrders == MAX_LIMITED_ORDER) throw new IllegalStateException();
        this.dateOrdered = null;
        nbOrders += 1;
    }

    public Order(String dateOrdered) {
        if(nbOrders == MAX_LIMITED_ORDER) throw new IllegalStateException();
        this.dateOrdered = dateOrdered;
        nbOrders += 1;
    }

    public long getId() {
        return id;
    }

    public String getDateOrdered() {
        return dateOrdered;
    }

    public void setDateOrdered(String dateOrdered) {
        this.dateOrdered = dateOrdered;
    }

    public List<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public boolean addMedia(Media media) {
        if(itemsOrdered.size() < MAX_NUMBER_ORDER) {
            itemsOrdered.add(media);
            return true;
        }
        return false;
    }

    public void addMedia(Media media1, Media media2) {
        if (itemsOrdered.size() < MAX_NUMBER_ORDER) {
            itemsOrdered.add(media1);
        } else {
            System.out.println("The order is already full. " + media1.getTitle() + " could not be added.");
        }
        if (itemsOrdered.size() < MAX_NUMBER_ORDER) {
            itemsOrdered.add(media2);
        } else {
            System.out.println("The order is already full. " + media2.getTitle() + " could not be added.");
        }
    }

    public void addMedia(Media... mediaList) {
        for (Media media : mediaList) {
            if (itemsOrdered.size() < MAX_NUMBER_ORDER) {
                itemsOrdered.add(media);
            } else {
                System.out.println("The order is already full. " + media.getTitle() + " could not be added.");
            }
        }
    }

    public void removeMedia(Media media) {
        if(!itemsOrdered.contains(media)) return;
        itemsOrdered.remove(media);
    }

    public float totalCost() {
        float totalCost = 0;
        for(int i = 0; i < itemsOrdered.size(); i++) {
            totalCost += itemsOrdered.get(i).getCost();
        }
        return totalCost;
    }

    public void print() {
        System.out.println("*********************Order****************");
        System.out.printf("Id: %d\n", id);
        System.out.printf("Date: %s\n", dateOrdered);
        System.out.println("Ordered Items:");
        

        for(int i=0; i < itemsOrdered.size(); i++) {
            if(itemsOrdered.get(i) instanceof DigitalVideoDisc) {
                DigitalVideoDisc dvd = (DigitalVideoDisc) itemsOrdered.get(i);

                String title = dvd.getTitle();
                String category = dvd.getCategory() != null ? dvd.getCategory() : "N/A";
                String director = dvd.getDirector() != null ? dvd.getDirector() : "N/A";
                int length = dvd.getLength();
                double price = dvd.getCost();
                long id = dvd.getId();
                
                System.out.printf("%d: DVD - %s - %s - %s - %d min: %.2f $\n",
                    id, title, category, director, length, price);
            }
            if(itemsOrdered.get(i) instanceof Book) {
                Book book = (Book) itemsOrdered.get(i);

                String title = book.getTitle();
                List<String> authors = book.getAuthors();
                String category = book.getCategory() != null ? book.getCategory() : "N/A";
                double price = book.getCost();
                long id = book.getId();

                System.out.printf("%d: Book - %s - ", id, title);
                if(authors.size() == 0) {
                    System.out.printf("N/A - ");
                } else {
                    for(String author : authors) System.out.printf("%s, ", author);
                }
                System.out.printf("- %s min: %.2f $\n", category, price);
            }
            if(itemsOrdered.get(i) instanceof CompactDisc) {
                CompactDisc cd = (CompactDisc) itemsOrdered.get(i);

                String title = cd.getTitle();
                String category = cd.getCategory() != null ? cd.getCategory() : "N/A";
                String director = cd.getDirector() != null ? cd.getDirector() : "N/A";
                int length = cd.getLength();
                double price = cd.getCost();
                long id = cd.getId();
                
                System.out.printf("%d: CD - %s - %s - %s - %d min: %.2f $\n",
                    id, title, category, director, length, price);
            }
        }
        

        double totalCost = this.totalCost();
        System.out.printf("Total cost: %.2f\n", totalCost);
        

        System.out.println("*******************************************");
    }

    public Media getALuckyItem(){
        int luckyIndex = ThreadLocalRandom.current().nextInt(itemsOrdered.size());
        itemsOrdered.get(luckyIndex).setCost(0);
        return itemsOrdered.get(luckyIndex);
    }

    
}
