package ueirt.logic;

public interface IMyCallback {
    void onStarted();

    void onStopped();

    void onProgress(int current, int total);

    void onUpdated();
}
