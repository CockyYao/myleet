package com.atsyc.multithread;

import java.util.concurrent.locks.LockSupport;
import java.util.function.IntConsumer;

/**
 *
 * https://leetcode-cn.com/problems/print-zero-even-odd/
 */
public class ZeroEvenOdd {

    private int n;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // true 通知even线程，false通知odd线程
    private volatile boolean notify = true;

    private Object evenLock = new Object();

    private Object oddLock = new Object();

    private Object zeroLock = new Object();


    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {


            while (true){

                    printNumber.accept(0);

                    if(notify){
                        evenLock.notifyAll();
                    }else{
                        oddLock.notifyAll();
                    }
                    notify = !notify;
                    zeroLock.wait();
            }

    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while (true){

            evenLock.wait();
            printNumber.accept(1);
            zeroLock.notify();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while (true){
            oddLock.wait();
            printNumber.accept(2);
            zeroLock.notify();
        }
    }

    public static void main(String[] args) {
        ZeroEvenOdd ins = new ZeroEvenOdd(10);
        Thread t1 = new Thread(()->{
            try {
                ins.zero(value -> System.out.println(value));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(()->{
            try {
                ins.even(value -> System.out.println(value));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t3 = new Thread(()->{
            try {
                ins.odd(value -> System.out.println(value));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
        t3.start();


    }


}
