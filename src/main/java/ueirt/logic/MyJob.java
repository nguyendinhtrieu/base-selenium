package ueirt.logic;

import ueirt.logic.model.MyResult;
import ueirt.logic.model.SettingJob;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class MyJob implements IMyJob {
    private SettingJob settingJob;
    private MyCallback callback;

    private ExecutorService executorService;

    public MyJob(SettingJob settingJob, MyCallback callback) {
        this.settingJob = settingJob;
        this.callback = callback;
    }

    @Override
    public void start() {
        callback.onStarted();

        executorService = Executors.newFixedThreadPool(settingJob.getNThread());
        List<Future<MyResult>> results = settingJob.getMyData().stream()
                .map(myData -> executorService.submit(new MyCallable(myData)))
                .collect(Collectors.toList());

        executorService.shutdown();

        while (!executorService.isTerminated()) {
            updateProgress(results);
        }
        updateProgress(results);

        this.stop();
    }

    @Override
    public void stop() {
        executorService.shutdownNow();
        callback.onStopped();
    }


    private void updateProgress(List<Future<MyResult>> futures) {
        int total = futures.size();
        int doneCount = (int) futures.stream().filter(Future::isDone).count();
        callback.onProgress(doneCount, total);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException("STOP CheckingProgressJob", e);
        }
    }
}
