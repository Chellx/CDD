package Mutex;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Michelle Bolger
 * @Date 16/10/2021
 * @Licence GNU General Public License v2.0
 */
class IntegerObj {


    static Semaphore mutex = new Semaphore(1);

    int value;

    IntegerObj(int val) {
        this.value = val;
    }

    /**
     * Increments int value
     * Returns updated value
     *
     * @return value number of times threads have executed
     */
    int inc() {


        try {
            mutex.acquire();

            this.value++;


        }

        catch (InterruptedException e) {
            e.printStackTrace();
        }

        finally {
            mutex.release();
            return this.value;

        }
    }
}
