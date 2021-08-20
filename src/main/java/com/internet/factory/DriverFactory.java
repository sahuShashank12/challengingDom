package com.internet.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {
    private WebDriver driver;
    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public WebDriver init_driver(String browser){
        System.out.println("Browser Choosen :" +browser);
        if (browser.equalsIgnoreCase("Chrome")){
            WebDriverManager.chromedriver().setup();
            tlDriver.set(new ChromeDriver());
        }
        else if (browser.equalsIgnoreCase("Firefox")){
            WebDriverManager.firefoxdriver().setup();
            tlDriver.set(new FirefoxDriver());
        }
        else if (browser.equalsIgnoreCase("Safari")){
            tlDriver.set(new SafariDriver());
        }
        else {
            System.out.println("Please Provide Valid Browser for setting up the Driver Instance");
        }
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(2L, TimeUnit.SECONDS);

        return getDriver();
    }

    public static synchronized WebDriver getDriver(){
        return tlDriver.get();
    }

}
