public class DiskTest {
    public static void main(String[] args){
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Star Wars");

        // Testing search method
        System.out.println(dvd1.search("star")); // expected output: True
        System.out.println(dvd1.search("wars")); // expected output: True
        System.out.println(dvd1.search("wArS StAr")); // expected output: True

        System.out.println(dvd1.search("war")); // expected output: False

    }
}