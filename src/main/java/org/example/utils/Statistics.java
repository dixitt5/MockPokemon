package org.example.utils;

public interface Statistics {
    public default void called() {
        System.out.println("stats called!");
    }
}
