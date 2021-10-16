package Mutex;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Michelle Bolger
 * @Date 16/10/2021
 * @Licence GNU General Public License v2.0
 */
public class Task implements Runnable {


    private String name;
    private IntegerObj total;


    /**
     * @param task_1 thread name
     * @param total int obj value
     *
     */

    public Task(String task_1, IntegerObj total) {
        name = task_1;
        this.total = total;
    }

    /**
     *
     */
    public void run() {


        try {
            for (int i = 0; i < 500; i++) {
                total.inc();
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


