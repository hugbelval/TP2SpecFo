package org.chocolaterie;

public class CTempereuse {
    private final int TEMPEREUSE_MAX = 1;
    private int tempereuseUtilisee = 0;
    synchronized void tempereChocolat(String id) throws InterruptedException {
        while (tempereuseUtilisee>=TEMPEREUSE_MAX) wait();
        System.out.println("Chocolatier " + id + " tempereChocolat");
        ++tempereuseUtilisee;
    }

    synchronized void donneChocolat(String id) {
        System.out.println("Chocolatier " + id + " donneChocolat");
        --tempereuseUtilisee;
        notifyAll();
    }
}
