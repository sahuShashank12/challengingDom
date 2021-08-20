package com.internet.pages;

import com.internet.config.ConfigReader;
import com.internet.utility.ReadCanvas;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ChallengingDOMPage extends BasePage{

    private ReadCanvas readCanvas  = new ReadCanvas();;

    // Page Locators:
    private By blueButton = By.xpath("//a[@class='button']");
    private By redButton = By.xpath("//a[@class='button alert']");
    private By greenButton = By.xpath("//a[@class='button success']");
    private By pageHeader = By.xpath("//div[@class='example']/h3");
    private By pageDescription = By.xpath("//div[@class='example']/p");
    private By table = By.xpath("//table");
    private By footerLink = By.linkText("Elemental Selenium");
    private By canvas = By.id("canvas");
    private By rowEditButton = By.xpath("//table/tbody/tr[1]/td[7]/a[contains(text(),'edit')]");
    private By rowDeleteButton = By.xpath("//table/tbody/tr[2]/td[7]/a[contains(text(),'delete')]");

    // Constructor of the Page Class

    public ChallengingDOMPage(WebDriver driver) {
        super(driver);
    }


    // Getters for WebElements
    public WebElement getBlueButton() {
        return getElement(blueButton);
    }

    public WebElement getRedButton() {
        return getElement(redButton);
    }

    public WebElement getGreenButton() {
        return getElement(greenButton);
    }

    public WebElement getPageHeader() {
        return getElement(pageHeader);
    }

    public WebElement getPageDescription() {
        return getElement(pageDescription);
    }

    public WebElement getTable() {
        return getElement(table);
    }

    public WebElement getFooterLink() {
        return getElement(footerLink);
    }

    public WebElement getCanvas() {
        return getElement(canvas);
    }

    public WebElement getRowEditButton() {
        return getElement(rowEditButton);
    }

    public WebElement getRowDeleteButton() {
        return getElement(rowDeleteButton);
    }


    // Page Actions
    public String getChallengingDOMPageHeader(){
        return getPageHeader().getText();
    }

    public String getChallengingDOMPageDescription(){
        return getPageDescription().getText();
    }

    public String getAnswerValue(){

        WebElement element = getCanvas();
        String imagePath = readCanvas.captureCanvasImage(element);
        String imageText = readCanvas.readImageText(imagePath);
        return imageText;
    }

    public void clickBlueButton(){
        clickButton(getBlueButton());
    }

    public void clickRedButton(){
        clickButton(getRedButton());
    }

    public void clickGreenButton(){
        clickButton(getGreenButton());
    }

    public void clickEditButton(){
        clickButton(getRowEditButton());
    }

    public void clickDeleteButton(){
        clickButton(getRowDeleteButton());
    }

    public void clickFooterLink(){ clickButton(getFooterLink());}

    public void loadPage(){
        driver.get(ConfigReader.getInstance().getConfigProperty("url"));
    }

    public List<String> getTableHeadersList(){
        WebElement table = getTable();
        List<String> tHeadsList = new ArrayList<>();
        List<WebElement> tHeads = table.findElements(By.xpath("thead//th"));
        for(int i = 0; i < tHeads.size(); i++){
            tHeadsList.add(tHeads.get(i).getText());
        }
       // System.out.println(tHeadsList);
        return tHeadsList;
    }

    public List<String> getRowDetails(int rowNumber){
        WebElement table = getTable();
        List<String> columnValues = new ArrayList<>();
        List<WebElement> tColumn = table.findElements(By.xpath("tbody/tr["+rowNumber+"]/td"));
        for(int i = 0; i < tColumn.size(); i++){
            columnValues.add(tColumn.get(i).getText());
        }
       // System.out.println(columnValues);
        return columnValues;
    }

    public int getTableRowNumber(){
        WebElement table = getTable();
        List<WebElement> tr = table.findElements(By.xpath("tbody/tr"));
        int totalRows = tr.size();
        return totalRows;
    }

    public int getTableColumnNumber(){
        WebElement table = getTable();
        List<WebElement> td = table.findElements(By.xpath("tbody/tr[1]/td"));
        int totalColumns = td.size();
        return totalColumns;
    }

}
