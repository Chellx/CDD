import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;

public class QueueFIFO {
    Semaphore mutex = new Semaphore(1);
    public BlockingQueue <Semaphore> theQueue;

    /**
     *   @author Michelle Bolger
     *   @Date 9/12/2021
     *   @Licence GNU General Public License v2.0
     *    the Leaders-Followers problem
     * FIFO Queue
     * allows leaders and followers to implement queue
     * implements java blocking queue
     */
    public QueueFIFO(){
        theQueue = new <Semaphore>ArrayBlockingQueue(3); //instance of blocking queue holds 3 semaphores
    }

    /**
     * @param queueSemaphore current threads semaphore
     *
     */
    public void wait (Semaphore queueSemaphore){
        try{
            mutex.acquire();
            theQueue.add(queueSemaphore);
            mutex.release();
            queueSemaphore.acquire();
        }
        catch (Exception e){

        }
    }


    public void signalThread(){
        try{
            mutex.acquire();
            Semaphore semaphore = theQueue.remove();
            mutex.release();
            semaphore.release();
        }

        catch(Exception e){

        }
    }
}
