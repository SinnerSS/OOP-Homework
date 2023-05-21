import java.util.ArrayList;
import java.util.List;

public class NoGarbage {
    private static final long TIME_LIMIT = 6000; 
    public static void main(String[] args) {
        int i = 0;
        List<GarbageObject> garbageList = new ArrayList<>();
        try {
            while (true) {
                garbageList.add(new GarbageObject(System.currentTimeMillis()));
                i++;

                removeExpiredObjects(garbageList);
            }

        } catch (OutOfMemoryError e) {
            System.out.println(i + " garbage objects added");
        }
    }

    private static void removeExpiredObjects(List<GarbageObject> garbageList) {
        long currentTime = System.currentTimeMillis();
        List<GarbageObject> objectsToRemove = new ArrayList<>();
        for (GarbageObject obj : garbageList) {
            if (currentTime - obj.checkTime() > TIME_LIMIT) {
                objectsToRemove.add(obj);
            }
        }

        if(objectsToRemove.size() != 0) {
            System.out.println("Removing " + objectsToRemove.size() + " garbage object");
            garbageList.removeAll(objectsToRemove);
        }
    }

    private static class GarbageObject {
        private long checkTime;

        public GarbageObject(long checkTime) {
            this.checkTime = checkTime;
        }

        public long checkTime() {
            return checkTime;
        }
    }
}