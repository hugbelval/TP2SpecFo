package org.chocolaterie;

public class Laboratoire {
    private final int N = 3;
    private Thread[] noir;
    private Thread[] blanc;
    private CMouleuse cMouleuseNoir;
    private CMouleuse cMouleuseBlanc;
    private CTempereuse cTempereuseNoir;
    private CTempereuse cTempereuseBlanc;

    public void start(){
        cMouleuseNoir = new CMouleuse();
        cMouleuseBlanc = new CMouleuse();
        cTempereuseNoir = new CTempereuse();
        cTempereuseBlanc = new CTempereuse();
        noir = new Thread[N];
        blanc = new Thread[N];

        for (int i = 0; i<N; i++) {
            noir[i] = new Thread(new Chocolatier(i + "n", cTempereuseNoir, cMouleuseNoir));
            blanc[i] = new Thread(new Chocolatier(i + "b", cTempereuseBlanc, cMouleuseBlanc));
        }
        for (int i = 0; i<N; i++) {
            noir[i].start();
            blanc[i].start();
        }
    }
}
