package ueirt.logic;

import lombok.AllArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ueirt.logic.model.MyData;
import ueirt.logic.model.MyResult;

import java.util.Random;
import java.util.concurrent.Callable;

@AllArgsConstructor
public class MyCallable implements Callable<MyResult> {
    private MyData myData;

    @Override
    public MyResult call() {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriver webDriver = new ChromeDriver(chromeOptions);

        webDriver.manage().window().setSize(myData.getDimension());
        webDriver.manage().window().setPosition(myData.getPoint());
        webDriver.get("https://chromedriver.chromium.org/downloads");

        try {
            Thread.sleep(1000 * (new Random().nextInt(5) + 3));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("CLOSE & QUIT");
        webDriver.close();
        webDriver.quit();

        return new MyResult(myData, true);
    }
}
