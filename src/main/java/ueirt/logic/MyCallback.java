package ueirt.logic;

public class MyCallback implements IMyCallback {

    @Override
    public void onStarted() {
        System.out.println("ON_STARTED");
    }

    @Override
    public void onStopped() {
        System.out.println("ON_STOPPED");
    }

    @Override
    public void onProgress(int current, int total) {
        System.out.println("ON_PROGRESS: doneCount/total: " + current + "/" + total);
    }

    @Override
    public void onUpdated() {
        System.out.println("ON_UPDATED");
    }
}
