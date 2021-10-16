package AtomicInt;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Michelle Bolger
 * @Date 16/10/2021
 * @Licence GNU General Public License v2.0
 */
public class Task implements Runnable {


    private String name;
    private AtomicInteger total;


    /**
     * @param task_1 thread name
     * @param total atomic int value
     *
     */

    public Task(String task_1, AtomicInteger total) {
        name = task_1;
        this.total = total;
    }

    /**
     *
     */
    public void run() {

        try {
            for (int i = 0; i < 500; i++) {
                total.incrementAndGet(); // gets atomic int current value and increments by 1
                if (i % 100 == 0) {
                    Thread.sleep(100);
                }

            }
            System.out.println(name + " complete");


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
