/**
 *
 * @author Michelle Bolger
 * @Date 28/11/2021
 * @Licence GNU General Public License v2.0
 */

public class Consumer implements Runnable {


    Queue queue;
    Consumer(Queue theQueue)
    {
        queue = theQueue;
        new Thread(this, "Consumer").start();
    }

    /**
     * allows thread to consume 5 items from  queue
     */
    public void run()
    {
        for (int i = 0; i < 5; i++)
            // consumer get items
            queue.get();
    }
}
