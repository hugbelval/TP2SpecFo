package org.chocolaterie;

public class CMouleuse {
    private final int MOULEUSE_MAX = 1;
    private int mouleuseUtilisee = 0;
    synchronized void remplit(String id) throws InterruptedException {
        while (mouleuseUtilisee >= MOULEUSE_MAX) wait();
        System.out.println("Chocolatier " + id + " remplit");
        ++mouleuseUtilisee;
    }

    synchronized void garnit(String id) {
        --mouleuseUtilisee;
        System.out.println("Chocolatier " + id + " garnit");
        notifyAll();
    }
}
