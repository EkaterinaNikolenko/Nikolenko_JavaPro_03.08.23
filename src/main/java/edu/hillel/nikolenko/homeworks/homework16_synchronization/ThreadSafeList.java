package edu.hillel.nikolenko.homeworks.homework16_synchronization;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeList<T> {
    private List<T> list = new ArrayList<>();
    private ReentrantLock lock = new ReentrantLock();

    public void add(int index, T item) {
        lock.lock();
        try {
            list.add(index, item);
        } finally {
            lock.unlock();
        }
    }

    public boolean add(T item) {
        lock.lock();
        try{
            return list.add(item);
        } finally {
            lock.unlock();
        }
    }

    public boolean remove(T item) {
        lock.lock();
        try {
            return list.remove(item);
        } finally {
            lock.unlock();
        }
    }

    public T remove(int index) {
        lock.lock();
        try {
            return list.remove(index);
        } finally {
            lock.unlock();
        }
    }

    public T get(int index) {
        lock.lock();
        try {
            return list.get(index);
        } finally {
            lock.unlock();
        }
    }
}
