package Snyc;

/**
 *
 * @author Michelle Bolger
 * @Date 16/10/2021
 * @Licence GNU General Public License v2.0

 */
class IntegerObj {
    int value;
    IntegerObj(int val) {
        this.value = val;
    }

    /**
     * @return value number of times threads have executed
     * synchronised will allow a single thread to execute at a time
     */
    synchronized int inc()
    {
        this.value++;
        return this.value;
    }
}
