public class Order {
    public static final int MAX_NUMBER_ORDER = 10;

    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBER_ORDER];

    private int qtyOrdered = 0;

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
    
}
