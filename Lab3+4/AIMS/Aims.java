import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;

public class Aims {

    //TODO: refactor to use hashmap for orderlist
    private static List<Order> orderList = new ArrayList<>();
    private static Scanner inputScan = new Scanner(System.in);


    private static final List<Class<?>> mediaType = new ArrayList<>(List.of(Book.class, DigitalVideoDisc.class));

    public static void main(String[] args) {
        int selection = 0;

        loop: while(true) {
            selection = showMenu();


            switch(selection) {
                case 1:
                    createOrder();
                    break;

                
                case 2:
                    if(orderList.isEmpty()) {
                        clrscr();


                        System.out.println("No order exist");        
                        System.out.print("Press enter to continue");
                        inputScan.nextLine();
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
        }


        inputScan.close();


    }


    public static int showMenu() {
        clrscr();


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


        return selection;


    }


    private static void createOrder() {
        Order order;


        clrscr();


        System.out.print("Enter order date: ");
        String dateOrder = inputScan.nextLine();

        if(dateOrder.isEmpty())
            order = new Order();
        else
            order = new Order(dateOrder);
        orderList.add(order);


        clrscr();
        System.out.println("Order " + order.getId() + " has been added");
        System.out.print("Press enter to continue");
        inputScan.nextLine();


    }
 

    private static Media createItem() {
        int selection = 0;
        Media media = null;
    

        clrscr();


        System.out.println("Choose item type:");
        System.out.println("--------------------------------");
        System.out.println("1. Book");
        System.out.println("2. Dvd");


        selection = inputScan.nextInt();
        inputScan.nextLine();


        clrscr();


        System.out.print("Enter title: ");
        String title = inputScan.nextLine();


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


                Book book = new Book(title, category, authorsList, cost);
                media = book;
                

                clrscr();
                System.out.println("Item " + book.getId() + " has been created");
                break;


            case 2:
                System.out.print("Enter director: ");
                String director = inputScan.nextLine();


                System.out.print("Enter length: ");
                int length = inputScan.nextInt();
                inputScan.nextLine();


                DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
                media = dvd;


                clrscr();
                System.out.println("Item " + dvd.getId() + " has been created");
                break;

            
        }


        System.out.print("Press enter to continue");
        inputScan.nextLine();
        

        return media;


    }


    private static void addItemToOrder(Media media) {
        clrscr();


        long id = getOrderId();


        for(Order order : orderList) {
            if(order.getId() == id) {
                order.addMedia(media);


                clrscr();


                System.out.println("Item " + media.getId() + " has been added to order " + order.getId());
                System.out.println("Press enter to continue");
                inputScan.nextLine();


            }
        }
    }


    private static void removeItemFromOrder() {
        clrscr();


        long orderId = getOrderId();


        for(Order order : orderList) {
            if(order.getId() == orderId) {
                clrscr();


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


                for(Media item : order.getItemsOrdered())
                    if(item.getId() == itemId) {
                        order.removeMedia(item);
                        break;
                    }

                clrscr();
                System.out.println("Remove item " + itemId + " from order " + order.getId());
                System.out.println("Press enter to continue");
                inputScan.nextLine();                
                

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

        return id;
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
