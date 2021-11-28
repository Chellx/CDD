/**
 *
 * @author Michelle Bolger
 * @Date 28/11/2021
 * @Licence GNU General Public License v2.0
 * A queue used to store items produced by producer thread and allows consumer thread to consume the items
 *
 */

import java.util.concurrent.Semaphore;


public class Queue {

    int consumeProduceItem;


    // consumerSemaphore 0 permits ensure put() executes first 0=locked
    static Semaphore consumerSemaphore = new Semaphore(0);

    static Semaphore producerSemaphore = new Semaphore(1); //1 = unlocked

    // get an item from buffer queue
    void get()
    {
        try {
            // Before consumer can consume an item, it has to  acquire a permit from the consumer semaphore
            consumerSemaphore.acquire();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        // consumer consuming an item
        System.out.println("Consumed : " + consumeProduceItem);

        // After consumer consumes the item it releases producer semaphore to tell producer
        producerSemaphore.release();
    }

    //  put an item in buffer queue
    void put(int item)
    {
        try {
            // Before producer can produce it must acquire a permit from producerSemaphore
            producerSemaphore.acquire();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        // producer producing an item
        this.consumeProduceItem = item;

        System.out.println("Produced : " + item);

        // After producer produces the item, it releases consumerSemaphore to notify consumer
        consumerSemaphore.release();
    }
}