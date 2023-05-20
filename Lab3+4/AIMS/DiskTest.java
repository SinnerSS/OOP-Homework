public class DiskTest {
    public static void main(String[] args){
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Star Wars");

        // Testing search method
        System.out.println(dvd1.search("star")); // expected output: True
        System.out.println(dvd1.search("wars")); // expected output: True
        System.out.println(dvd1.search("wArS StAr")); // expected output: True

        System.out.println(dvd1.search("war")); // expected output: False

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Aladdin");
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("The Lion King");
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("The Avengers");

        Order order1 = new Order();

        order1.addDigitalVideoDisc(dvd1, dvd2, dvd3, dvd4);

        // Testing random item method
        System.out.println(order1.getALuckyItem().getTitle());// expected output: Random title

    }
}