package com.morcat.test;

/**
 * @author shenzixing
 * @date 2024/2/3
 */
public class OddEvenPrinterTest {

    /**
     * 打印奇数线程
     */
    public static class OddThread extends Thread {

        private Integer start = 1;

        @Override
        public void run() {
            try {
                while (start <= 1000) {
                    synchronized (OddEvenPrinterTest.class) {
                        OddEvenPrinterTest.class.notify();
                        System.out.println(start);
                        start = start + 2;
                        OddEvenPrinterTest.class.wait();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static class EvenThread extends Thread {

        private Integer start = 2;

        @Override
        public void run() {
            try {
                while (start <= 1000) {
                    synchronized (OddEvenPrinterTest.class) {
                        OddEvenPrinterTest.class.notify();
                        System.out.println(start);
                        start = start + 2;
                        OddEvenPrinterTest.class.wait();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        OddThread oddThread = new OddThread();
        EvenThread evenThread = new EvenThread();
        oddThread.start();
        evenThread.start();
    }

}
