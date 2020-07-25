package ueirt;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriverService;
import ueirt.logic.IMyJob;
import ueirt.logic.MyCallback;
import ueirt.logic.MyJob;
import ueirt.logic.model.MyData;
import ueirt.logic.model.SettingJob;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, "src/main/resources/driver/chromedriver");

        IMyJob myJob = new MyJob(
                new SettingJob(Arrays.asList(
                        new MyData("1", new Point(0, 0), new Dimension(500, 500)),
                        new MyData("2", new Point(300, 0), new Dimension(500, 500)),
                        new MyData("3", new Point(600, 0), new Dimension(500, 500)),
                        new MyData("4", new Point(900, 0), new Dimension(500, 500)),
                        new MyData("5", new Point(1200, 0), new Dimension(500, 500))
                ), 3),
                new MyCallback()
        );

        myJob.start();
    }
}
