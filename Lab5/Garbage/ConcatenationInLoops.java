import java.util.concurrent.ThreadLocalRandom;

public class ConcatenationInLoops {
    public static void main(String[] args){
        String alphabet = 
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
            "abcdefghijklmnopqrstuvwxyz" +
            "0123456789";

        int n = 300000;
        
        String s = "";
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < n; i++) {
            char randomLetter = alphabet.charAt(ThreadLocalRandom.current().nextInt(alphabet.length()));
            s += randomLetter;
        }
        System.out.println(System.currentTimeMillis() - startTime);

        StringBuffer sbf = new StringBuffer();
        startTime = System.currentTimeMillis();
        for(int i = 0; i < n; i++) {
            char randomLetter = alphabet.charAt(ThreadLocalRandom.current().nextInt(alphabet.length()));
            sbf.append(randomLetter);
        }
        s = sbf.toString();
        System.out.println(System.currentTimeMillis() - startTime);
                        
        StringBuilder sbd = new StringBuilder();
        startTime = System.currentTimeMillis();
        for(int i = 0; i < n; i++) {
            char randomLetter = alphabet.charAt(ThreadLocalRandom.current().nextInt(alphabet.length()));
            sbd.append(randomLetter);
        }
        s = sbd.toString();
        System.out.println(System.currentTimeMillis() - startTime);
    }
}