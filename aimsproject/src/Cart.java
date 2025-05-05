
public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added.");
        } else {
            System.out.println("The cart is full.");
        }
    }


    // Overload 2: Add with varargs
    public void addDigitalVideoDisc(DigitalVideoDisc... dvds) {
        for (DigitalVideoDisc disc : dvds) {
            addDigitalVideoDisc(disc);
        }
    }

    // Overload 3: Add two DVDs
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        addDigitalVideoDisc(dvd1);
        addDigitalVideoDisc(dvd2);
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] == disc) {
                found = true;
                // Shift left
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null;
                qtyOrdered--;
                System.out.println("The disc has been removed.");
                break;
            }
        }
        if (!found) {
            System.out.println("The disc was not found in the cart.");
        }
    }

    public float totalCost() {
        float total = 0f;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }

    public void printCart() {
        System.out.println("***********************CART***********************");
        for (int i = 0; i < qtyOrdered; i++) {
            DigitalVideoDisc disc = itemsOrdered[i];
            System.out.println((i + 1) + ". DVD - " + disc.getTitle() + " - "
                    + disc.getCategory() + " - " + disc.getDirector() + " - "
                    + disc.getLength() + ": " + disc.getCost() + "$");
        }
        System.out.println("Total cost: " + totalCost() + "$");
        System.out.println("***************************************************");
    }
}


