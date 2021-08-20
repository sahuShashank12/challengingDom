package com.internet.pages;

import com.internet.utility.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePage extends AbstractPage {
    public BasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    @Override
    public String getPageHeader(By locator) {
        return getElement(locator).getText();
    }

    @Override
    public WebElement getElement(By locator) {
        WebElement element = null;
        try {
            waitForElementPresent(locator);
            element = driver.findElement(locator);
            //System.out.println(element.toString());
        }catch (Exception e){
            Log.error("Exception occurred while waiting for the Element: ",e);
        }
        return element;
    }

    @Override
    public void waitForElementPresent(By locator) {
        try{
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        }catch (Exception e){
            Log.error("Exception occurred while waiting for the Element: ",e);
        }
    }

    @Override
    public void waitForPageTitle(String title) {
        try {
            wait.until(ExpectedConditions.titleIs(title));
        }catch (Exception e){
            Log.error("Exception occurred while waiting for the page title : ",e);
        }
    }

    public void waitForPageLoad(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        }catch (Exception e){
            Log.error("Exception occurred while waiting for the page to load : ",e);
        }
    }

    public void clickButton(WebElement element) {
        try {
            element.click();
        }catch (Exception e){
            Log.error("Exception occurred while clicking on the Element : ",e);
        }
    }
}
