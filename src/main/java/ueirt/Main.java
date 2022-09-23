package ueirt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, "src/main/resources/driver/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriver webDriver = new ChromeDriver(chromeOptions);

        webDriver.get("https://google.com/");

        try {
            Thread.sleep(1000 * (new Random().nextInt(5) + 3));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        webDriver.close();
        webDriver.quit();
    }
}
