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
            return true;
        }
        return false;
    }

    public boolean removeDigitalVideoDisc(DigitalVideoDisc disc) {
        for(int i = 0; i < qtyOrdered; i++) {
            if(itemsOrdered[i] == disc) {
                qtyOrdered -= 1;
                while(itemsOrdered[i] != null) {
                    itemsOrdered[i] = itemsOrdered[i+1];
                    return true;
                }
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
