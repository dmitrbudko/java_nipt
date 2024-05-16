package edu.phystech.hw4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Stepper {
    public enum Side {
        LEFT, RIGHT
    }

    private final List<Side> history = new ArrayList<>();
    private final Lock lock = new ReentrantLock();
    private final Condition leftCondition = lock.newCondition();
    private final Condition rightCondition = lock.newCondition();
    private boolean isLeftTurn = true;

    public void leftStep() throws InterruptedException {
        lock.lock();
        try {
            while (!isLeftTurn) {
                leftCondition.await();
            }
            history.add(Side.LEFT);
            isLeftTurn = false;
            rightCondition.signal();
        } finally {
            lock.unlock();
        }
    }

    public void rightStep() throws InterruptedException {
        lock.lock();
        try {
            while (isLeftTurn) {
                rightCondition.await();
            }
            history.add(Side.RIGHT);
            isLeftTurn = true;
            leftCondition.signal();
        } finally {
            lock.unlock();
        }
    }

    public List<Side> getHistory() {
        return history;
    }
}
