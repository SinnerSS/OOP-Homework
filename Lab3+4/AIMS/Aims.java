import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Semaphore;
import java.io.IOException;

public class Aims {

    //TODO: refactor to use hashmap for orderlist
    private static List<Order> orderList = new ArrayList<>();
    private static Scanner inputScan = new Scanner(System.in);



    private static final List<Class<?>> mediaType = new ArrayList<>(List.of(Book.class, DigitalVideoDisc.class, CompactDisc.class));

    public static void main(String[] args) {
        clrscr();

        
        int selection = 0;
        Semaphore semaphore = new Semaphore(1, true);

        Thread memoryMonitor = new Thread(new MemoryDaemon(semaphore));
        memoryMonitor.setDaemon(true);
        memoryMonitor.start();

        loop: while(true) {
            try {
               semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            selection = showMenu();


            switch(selection) {
                case 1:
                    createOrder();
                    break;

                
                case 2:
                    if(orderList.isEmpty()) {
                        System.out.println("No order exist");        
                        System.out.print("Press enter to continue");
                        inputScan.nextLine();
                        clrscr();
                        break;
                    }


                    Media media = createItem();
                    addItemToOrder(media);
                    break;


                case 3:
                    if(orderList.isEmpty()) {
                        clrscr();


                        System.out.println("No order exist");        
                        System.out.print("Press enter to continue");
                        inputScan.nextLine();
                        break;
                    }

                    removeItemFromOrder();
                    break;


                case 4:
                    if(orderList.isEmpty()) {
                        clrscr();


                        System.out.println("No order exist");        
                        System.out.print("Press enter to continue");
                        inputScan.nextLine();
                        break;
                    }

                    clrscr();
                    long orderId = getOrderId();
                    

                    for(Order order : orderList) {
                        clrscr();
                        if(order.getId() == orderId) {
                            order.print();
                            System.out.print("Press enter to continue");
                            inputScan.nextLine();
                        }
                    }
                    break;

                case 0: 
                    break loop;


            }
            
            semaphore.release();
        }


        inputScan.close();


    }


    public static int showMenu() {


        System.out.println("Order Management Application: ");
        System.out.println("--------------------------------");
        System.out.println("1. Create new order");
        System.out.println("2. Add item to the order");
        System.out.println("3. Delete item by id");
        System.out.println("4. Display the items list of order");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");


        int selection = inputScan.nextInt();
        inputScan.nextLine();
        clrscr();


        return selection;


    }


    private static void createOrder() {
        Order order;


        System.out.print("Enter order date: ");
        String dateOrder = inputScan.nextLine();
        clrscr();

        if(dateOrder.isEmpty())
            order = new Order();
        else
            order = new Order(dateOrder);
        orderList.add(order);


        System.out.println("Order " + order.getId() + " has been added");
        System.out.print("Press enter to continue");
        inputScan.nextLine();
        clrscr();


    }
 

    private static Media createItem() {
        int selection = 0;
        Media media = null;


        System.out.println("Choose item type:");
        System.out.println("--------------------------------");
        System.out.println("1. Book");
        System.out.println("2. DVD");
        System.out.println("3. CD");


        selection = inputScan.nextInt();
        inputScan.nextLine();
        clrscr();


        System.out.print("Enter title: ");
        String itemTitle = inputScan.nextLine();


        System.out.print("Enter category: ");
        String category = inputScan.nextLine();


        System.out.print("Enter cost: ");
        int cost = inputScan.nextInt();
        inputScan.nextLine();


        switch(selection) {
            case 1:
                List<String> authorsList = new ArrayList<>();
                String author;


                do {
                    System.out.print("Add author: ");
                    author = inputScan.nextLine();

                    if(!author.isEmpty())
                        authorsList.add(author);
                }   while(!author.isEmpty());


                Book book = new Book(itemTitle, category, authorsList, cost);
                media = book;
                

                clrscr();
                System.out.println("Item " + book.getId() + " has been created");
                break;


            case 2:
                System.out.print("Enter director: ");
                String director = inputScan.nextLine();


                System.out.print("Enter length: ");
                int dvdLength = inputScan.nextInt();
                inputScan.nextLine();


                DigitalVideoDisc dvd = new DigitalVideoDisc(itemTitle, category, director, dvdLength, cost);
                media = dvd;


                clrscr();
                preview(dvd);
                clrscr();
                System.out.println("Item " + dvd.getId() + " has been created");
                break;

            
            case 3:
                System.out.print("Enter artist: ");
                String artist = inputScan.nextLine();


                CompactDisc cd = new CompactDisc(itemTitle, category);
                cd.setArtist(artist);


                while(true) {
                    System.out.print("Enter track title: ");
                    String trackTitle  = inputScan.nextLine();


                    if(trackTitle.isEmpty()) break;


                    System.out.print("Enter track length: ");
                    int trackLength = inputScan.nextInt();
                    inputScan.nextLine();


                    Track track = new Track();
                    track.setTitle(trackTitle);
                    track.setLength(trackLength);


                    cd.addTrack(track);


                }

                media = cd;
                clrscr();
                preview(cd);
                clrscr();
                System.out.println("Item " + cd.getId() + " has been created");
                break;
                

            
        }



        System.out.print("Press enter to continue");
        inputScan.nextLine();
        clrscr();
        return media;


    }


    private static void addItemToOrder(Media media) {


        long id = getOrderId();


        for(Order order : orderList) {
            if(order.getId() == id) {
                order.addMedia(media);


                System.out.println("Item " + media.getId() + " has been added to order " + order.getId());
                System.out.println("Press enter to continue");
                inputScan.nextLine();
                clrscr();


            }
        }
    }


    private static void removeItemFromOrder() {


        long orderId = getOrderId();


        for(Order order : orderList) {
            if(order.getId() == orderId) {
                System.out.println("Items list of " + order.getId() + " :");
                for(Media item : order.getItemsOrdered()) {
                    String typeName = null;


                    for(Class<?> type : mediaType) {
                        if(type.isInstance(item)) {
                            typeName = type.getName();
                            break;
                        }
                    }


                    System.out.println(typeName + ": Id " + item.getId() + " with title " + item.getTitle());
                }
                System.out.println("--------------------------------");
                System.out.print("Select an item Id to remove: ");
                long itemId = inputScan.nextLong();
                inputScan.nextLine();
                clrscr();


                for(Media item : order.getItemsOrdered())
                    if(item.getId() == itemId) {
                        order.removeMedia(item);
                        break;
                    }

                clrscr();
                System.out.println("Remove item " + itemId + " from order " + order.getId());
                System.out.println("Press enter to continue");
                inputScan.nextLine();        
                clrscr();        
                

                return;


            }
        }
    }


    private static long getOrderId() {
        System.out.println("Order Id: ");
        for(Order order : orderList) {
            System.out.println("Id " + order.getId() + " created at " + (order.getDateOrdered() != null ? order.getDateOrdered() : "N/A"));
        }

        System.out.println("--------------------------------");
        System.out.print("Select an order Id: ");
        long id = inputScan.nextLong();
        inputScan.nextLine();
        clrscr();

        return id;
    }


    private static void preview(Disc disc) {
        System.out.print("Play item added(y/n)? ");
        String selection = inputScan.nextLine();

        if(selection.toUpperCase().equals("Y")) playDisc(disc);
    }

    private static void playDisc(Disc disc) {
        if (disc instanceof CompactDisc) {
            ((CompactDisc) disc).play();
        } else if (disc instanceof DigitalVideoDisc) {

            ((DigitalVideoDisc) disc).play();
            System.out.println("Press enter to skip");
            inputScan.nextLine();
            clrscr(); 
        }
    }

    private static void clrscr(){
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
