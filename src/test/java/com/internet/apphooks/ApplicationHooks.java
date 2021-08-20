package com.internet.apphooks;

import com.internet.config.ConfigReader;
import com.internet.factory.DriverFactory;
import com.internet.pages.AbstractPage;
import com.internet.pages.BasePage;
import com.internet.utility.Log;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ApplicationHooks {

    private WebDriver driver;
    private ConfigReader reader;
    private DriverFactory driverFactory;
    public AbstractPage page;

    Logger log = Logger.getLogger(ApplicationHooks.class);
    @Before(order = 0)
    public void loadConfigFile(){
        PropertyConfigurator.configure("src/main/resources/log4j.properties");
        log.setLevel(Level.INFO);
        log.info("**************************       Loading Config File       **************************");
        reader = ConfigReader.getInstance();
    }

    @Before(order = 1)
    public void launchBrowser(Scenario scenario){
        log.info("**************************       Launch Browser       **************************");
        String browser = reader.getConfigProperty("browser");
        driverFactory = new DriverFactory();
        driver = driverFactory.init_driver(browser);
        page = new BasePage(driver);

        //log.info("==============================Starting scenario : "+scenario.getName()+"===============================");
        Log.startTestCase(scenario.getName());
    }
    @After(order = 0)
    public void quitBrowser(){
      //  Log.endTestCase();
        Log.info("**************************       Quitting Browser       **************************");
        driver.quit();
    }
    @After(order = 1)
    public void takeScreenShot(Scenario scenario){
        if (scenario.isFailed()){
            log.info("**************************       Taking Screenshot for failed scenario "+scenario.getName()+"       **************************");
            String screenShotName = scenario.getName().replaceAll("","_");
            byte[] filePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(filePath,"image/png",screenShotName);
        }
    }
}
