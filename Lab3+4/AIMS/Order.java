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

    public boolean removeDigitalVideoDisc(DigitalVideoDisc disc) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] == disc) {
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j+1];
                    if(itemsOrdered[j+1] == null) break;
                }
                itemsOrdered[qtyOrdered - 1] = null;
                qtyOrdered -= 1;
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
