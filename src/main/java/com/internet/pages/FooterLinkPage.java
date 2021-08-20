package com.internet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FooterLinkPage extends BasePage{

    public FooterLinkPage(WebDriver driver) {
        super(driver);
    }

    public String getFooterPageTitle(){
       return getPageTitle();
    }

    public void waitForPageLoad(){
        waitForPageTitle(getPageTitle());
    }
}
