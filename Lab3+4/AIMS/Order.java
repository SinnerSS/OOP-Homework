public class Order {
    public static final int MAX_NUMBER_ORDER = 10;
    public static final int MAX_LIMITED_ORDER = 5;

    public static int nbOrders = 0;

    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBER_ORDER];

    private int qtyOrdered = 0;
    private String dateOrdered;

    

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

    public String getDateOrdered() {
        return dateOrdered;
    }

    public void setDateOrdered(String dateOrdered) {
        this.dateOrdered = dateOrdered;
    }

    public int getQtyOrdered() {
        return qtyOrdered;
    }

    public void setQtyOrdered(int qtyOrdered) {
        this.qtyOrdered = qtyOrdered;
    }

    public boolean addDigitalVideoDisc(DigitalVideoDisc disc) {
        if(qtyOrdered < MAX_NUMBER_ORDER) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered += 1;
            System.out.println("The disc has been added");
            return true;
        }
        return false;
    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        if (qtyOrdered < MAX_NUMBER_ORDER) {
            itemsOrdered[qtyOrdered++] = dvd1;
        } else {
            System.out.println("The order is already full. " + dvd1.getTitle() + " could not be added.");
        }
        if (qtyOrdered < MAX_NUMBER_ORDER) {
                itemsOrdered[qtyOrdered++] = dvd2;
        } else {
            System.out.println("The order is already full. " + dvd2.getTitle() + " could not be added.");
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc... dvdList) {
        for (DigitalVideoDisc dvd : dvdList) {
            if (qtyOrdered < MAX_NUMBER_ORDER) {
                itemsOrdered[qtyOrdered++] = dvd;
            } else {
                System.out.println("The order is already full. " + dvd.getTitle() + " could not be added.");
            }
        }
    }

    public boolean removeDigitalVideoDisc(DigitalVideoDisc disc) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] == disc) {
                if (i == qtyOrdered - 1) {
                    itemsOrdered[i] = null;
                    qtyOrdered--;
                } else {
                    System.arraycopy(itemsOrdered, i+1, itemsOrdered, i, qtyOrdered - i - 1);
                    itemsOrdered[qtyOrdered - 1] = null;
                    qtyOrdered--;
                }
                System.out.println("The disc has been removed");
                return true;
            }
        }
        return false;
    }

    public float totalCost() {
        float totalCost = 0;
        for(int i = 0; i < qtyOrdered; i++) {
            totalCost += itemsOrdered[i].getCost();
        }
        return totalCost;
    }

    public void print() {

        System.out.println("*********************Order****************");
        System.out.printf("Date: %s\n", dateOrdered);
        System.out.println("Ordered Items:");
        

        for(int i=0; i < qtyOrdered; i++) {
    
            String title = itemsOrdered[i] != null ? itemsOrdered[i].getTitle() : "N/A";
            String category = itemsOrdered[i] != null ? itemsOrdered[i].getCategory() : "N/A";
            String director = itemsOrdered[i] != null ? itemsOrdered[i].getDirector() : "N/A";
            int length = itemsOrdered[i] != null ? itemsOrdered[i].getLength() : 0;
            double price = itemsOrdered[i] != null ? itemsOrdered[i].getCost() : 0;
            
            System.out.printf("%d. DVD - %s - %s - %s - %d min: %.2f $\n",
                i + 1, title, category, director, length, price);
        }
        

        double totalCost = this.totalCost();
        System.out.printf("Total cost: %.2f\n", totalCost);
        

        System.out.println("*******************************************");
    }
    
}
