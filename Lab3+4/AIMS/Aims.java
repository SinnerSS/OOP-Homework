public class Aims {

    public static void main(String[] args) {
        Order order1 = new Order();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
        dvd1.setCategory("Animation");
        dvd1.setCost(19.95f);
        dvd1.setDirector("Roger Allers");
        dvd1.setLength(87);

        order1.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars");
        dvd2.setCategory("Science Fiction");
        dvd2.setCost(24.95f);
        dvd2.setDirector("George Lucas");
        dvd2.setLength(124);

        order1.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin");
        dvd3.setCategory("Animation");
        dvd3.setCost(18.99f);
        dvd3.setDirector("John Musker");
        dvd3.setLength(90);

        order1.addDigitalVideoDisc(dvd3);

        System.out.print("Total Cost is: ");
        System.out.printf("%.2f\n",order1.totalCost());

        order1.removeDigitalVideoDisc(dvd1);
        System.out.print("Total Cost after removing " + dvd1.getTitle() + " is: ");
        System.out.printf("%.2f\n",order1.totalCost());

        DigitalVideoDisc dvd4 = new DigitalVideoDisc("The Avengers", "Action", "Joss Whedon", 143, 24.95f);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Inception", "Christopher Nolan", "Action", 135, 9.99f);
        DigitalVideoDisc dvd6 = new DigitalVideoDisc("The Shawshank Redemption", "Frank Darabont", "Drama", 142, 7.99f);

        Order order2 = new Order("Feb 2nd 2022");
        Order order3 = new Order("Aug 15th 2022");
    
        order2.addDigitalVideoDisc(dvd4);
        order2.addDigitalVideoDisc(dvd6);
    
        order3.addDigitalVideoDisc(dvd3);
        order3.addDigitalVideoDisc(dvd5);
    

        System.out.println("Order 1:");
        order1.print();
        System.out.println("Order 2:");
        order2.print();
        System.out.println("Order 3:");
        order3.print();

    }
}
