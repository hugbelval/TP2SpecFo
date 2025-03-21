package org.chocolaterie;

import static java.lang.Thread.sleep;

public class Chocolatier implements Runnable{
    private String id;
    private CTempereuse cTempereuse;
    private CMouleuse cMouleuse;

    public Chocolatier(String id, CTempereuse cTempereuse, CMouleuse cMouleuse) {
        this.id = id;
        this.cTempereuse = cTempereuse;
        this.cMouleuse = cMouleuse;
    }

    public void run() {
        try {
            while (true) {
                cTempereuse.tempereChocolat(id);
                sleep((long)(Math.random() * 2000));
                cTempereuse.donneChocolat(id);
                sleep((long)(Math.random() * 2000));
                cMouleuse.remplit(id);
                sleep((long)(Math.random() * 2000));
                cMouleuse.garnit(id);
                sleep((long)(Math.random() * 2000));
            }
        } catch (InterruptedException ignored){}
    }
}
