/**
 *
 * @author Michelle Bolger
 * @Date 28/11/2021
 * @Licence GNU General Public License v2.0
 */


public class Producer implements Runnable {

    Queue queue;
    Producer(Queue theQueue)
    {
        queue = theQueue;
        new Thread(this, "Producer").start();
    }

    /**
     * allows thread to produce 5 items for queue
     */
    public void run()
    {
        for (int i = 0; i < 5; i++)
            // producer put items
            queue.put(i);
    }
}