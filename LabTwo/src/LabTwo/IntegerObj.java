/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LabTwo;

/**
 *
 * @author Michelle Bolger
 * @Date 16/10/2021
 * @Licence GNU General Public License v2.0
 *
 */



class IntegerObj {
    int value;
    IntegerObj(int val) {
        this.value = val;
    }

    /**
     * Increments int value
     * Returns updated value
     * @return value number of times threads have executed
     */
    int inc(){
        this.value++;
        return this.value;
    }
}
