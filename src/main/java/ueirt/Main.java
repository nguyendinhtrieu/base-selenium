package ueirt;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

public class Main {
    public static void main(String[] args) {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, "src/main/resources/driver/chromedriver");

        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriver webDriver = new ChromeDriver(chromeOptions);

        webDriver.manage().window().setSize(new Dimension(500, 500));
        webDriver.manage().window().setPosition(new Point(0, 0));
        webDriver.get("https://chromedriver.chromium.org/downloads");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        webDriver.close();
        webDriver.quit();
    }
}
