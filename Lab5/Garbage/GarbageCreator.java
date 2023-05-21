import java.util.ArrayList;
import java.util.List;

public class GarbageCreator {
    public static void main(String[] args) {
        int i = 0;
        List<Object> garbageList = new ArrayList<>();
        try {
            while (true) {
                garbageList.add(new Object());
                i++;
            }
        } catch(OutOfMemoryError e) {
            System.out.println(i + " garbage objects added");
        }
    }
}