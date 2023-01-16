package org.example.counter;

/**
 * 스레드는 특정 상태를 저장하게 해서는 안된다.
 * 스레드 safe 하지 않고 생각과 다른 결과가 나올 수 있다.
 *
 * @author : yunji
 * @version : 1.0.0
 * @date : 2023/01/16
 */
public class Counter implements Runnable{

    private int count = 0;

    public void increment(){
        count++;
    }

    public void decrement(){
        count--;
    }

    public int getValue(){
        return count;
    }

    @Override
    public void run() {
        synchronized (this) {
            this.increment();
            System.out.println("value for thread after increment" + Thread.currentThread().getName() + " " + this.getValue());
            this.decrement();
            System.out.println("value for thread at last" + Thread.currentThread().getName() + " " + this.getValue());
        }
    }
}
