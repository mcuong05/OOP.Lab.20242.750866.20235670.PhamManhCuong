

public class Aims {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Create a new cart
		Cart anOrder = new Cart();
		//Create new dwd objects and add them to the cart
	    DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
	        "Animation", "Roger Allers", 87, 19.95f);
	    anOrder.addDigitalVideoDisc(dvd1);

	    DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
	        "Science Fiction", "George Lucas", 87, 24.95f);
	    anOrder.addDigitalVideoDisc(dvd2);

	    DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
	        "Animation", 18.99f);
	    anOrder.addDigitalVideoDisc(dvd3);

	    //print total cost of the items in the cart
	    System.out.println("\n--Before removing--");
	    anOrder.printCart();
	    //Remove one DVD
	    anOrder.removeDigitalVideoDisc(dvd2);
	    //Print cart again
	    System.out.println("\n--After removing--");
	    anOrder.printCart();
	    
	}

	}


