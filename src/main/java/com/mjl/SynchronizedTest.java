package com.mjl;

/**
 * @author MJL
 * @date 2024/1/17.
 */
public class SynchronizedTest {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            SynchronizedTest test = new SynchronizedTest();
            try {
                test.synchronizedString("SynchronizedTest");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1");
        Thread t2 = new Thread(() -> {
            SynchronizedTest test = new SynchronizedTest();
            try {
                test.synchronizedString("SynchronizedTest");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t2");
        Thread t4 = new Thread(() -> {
            SynchronizedTest test = new SynchronizedTest();
            try {
                test.synchronizedString("SynchronizedTest");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t4");
        Thread t5 = new Thread(() -> {
            SynchronizedTest test = new SynchronizedTest();
            try {
                test.synchronizedString("SynchronizedTest");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t5");
        Thread t10 = new Thread(() -> {
            SynchronizedTest test = new SynchronizedTest();
            try {
                test.synchronizedString("SynchronizedTest");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t10");
        Thread t3 = new Thread(() -> {
            SynchronizedTest test = new SynchronizedTest();
            try {
                test.synchronizedStringAndException("SynchronizedTest");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t3");
        t3.start();
        t1.start();
        t2.start();
        t4.start();
        t5.start();
        t10.start();
    }

    public void synchronizedString(String s) throws InterruptedException {
        synchronized (s.intern()) {
            System.out.println("当前线程 : " + Thread.currentThread().getName() + "开始");
            Thread.sleep(300);
            System.out.println("当前线程 : " + Thread.currentThread().getName() + "结束");
        }
    }

    public void synchronizedStringAndException(String s) throws InterruptedException {
        synchronized (s.intern()) {
            System.out.println("当前线程 : " + Thread.currentThread().getName() + "开始");
            Thread.sleep(300);
            int i = 1/0;
            System.out.println("当前线程 : " + Thread.currentThread().getName() + "结束");
        }
    }
}
