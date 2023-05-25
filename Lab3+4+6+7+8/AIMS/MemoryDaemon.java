import java.util.concurrent.Semaphore;

public class MemoryDaemon implements Runnable {
    private long memoryUsed = 0;
    private final Semaphore semaphore;

    public MemoryDaemon(Semaphore semaphore) {
        this.semaphore = semaphore;
    }


    public void run() {
        Runtime rt = Runtime.getRuntime();
        long used;


        while(true) {
            used = rt.totalMemory() - rt.freeMemory();
            if(used != memoryUsed) {
                try {
                    semaphore.acquire();

                    System.out.println("\tMemory used = " + used);

                    memoryUsed = used;

                    semaphore.release();
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(100); 
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
