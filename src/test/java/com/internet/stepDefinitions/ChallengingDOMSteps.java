package com.internet.stepDefinitions;

import com.internet.factory.DriverFactory;
import com.internet.pages.ChallengingDOMPage;
import com.internet.pages.FooterLinkPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.util.List;

public class ChallengingDOMSteps {

    private final ChallengingDOMPage domPage = new ChallengingDOMPage(DriverFactory.getDriver());
    private String answerBeforeAction;
    private FooterLinkPage footerLinkPage;
    private String pageTitle;
    private int actualNoOfRows;
    private int actualNoOfColumns;
    private List<String> actualTHeaderList;
    private List<String> actualColumnValues;
    private List<String> refreshedColumnValues;

    @Given("user is on the dom page")
    public void user_is_on_the_dom_page() {
        domPage.loadPage();
    }

    @And("user fetch value from canvas")
    public void userFetchValueFromCanvas() {
        answerBeforeAction = domPage.getAnswerValue();
    }

    @When("user clicks blue button")
    public void userClicksBlueButton() {
        domPage.clickBlueButton();
    }

    @Then("the answer canvas updates")
    public void the_answer_canvas_updates() {
        String answerAfterAction = domPage.getAnswerValue();
        Assert.assertNotEquals(answerBeforeAction,answerAfterAction);
    }

    @When("user clicks red button")
    public void userClicksRedButton() {
        domPage.clickRedButton();
    }

    @When("user clicks green button")
    public void userClicksGreenButton() {
        domPage.clickGreenButton();
    }

    @When("user hits the url in browser")
    public void userHitsTheUrlInBrowser() {
        domPage.loadPage();
    }

    @Then("page loads successfully")
    public void pageLoadsSuccessfully() {
       String pageTitle =  domPage.getPageTitle();
       Assert.assertEquals("The Internet",pageTitle);
    }

    @And("user gets the title of the page")
    public void userGetsTheTitleOfThePage() {
        pageTitle = domPage.getPageTitle();
        System.out.println("Page title is: "+pageTitle);
    }

    @Then("page title should be {string}")
    public void pageTitleShouldBe(String title) {
        Assert.assertEquals(title,pageTitle);
    }

    @Then("page Header should be {string}")
    public void pageHeaderShouldBe(String header) {
        Assert.assertEquals(header,domPage.getChallengingDOMPageHeader());
    }

    @Then("page Description should be {string}")
    public void pageDescriptionShouldBe(String description) {
        Assert.assertEquals(description,domPage.getChallengingDOMPageDescription());
    }

    @Then("answer canvas is visible")
    public void answerCanvasIsVisible() {
        Assert.assertTrue(domPage.getCanvas().isDisplayed());
    }

    @When("user clicks footer link")
    public void userClicksFooterLink() throws InterruptedException {
        Thread.sleep(5000);
        domPage.clickFooterLink();

    }
    @Then("Footer page title should be {string}")
    public void footerPageTitleShouldBe(String title) {
        Assert.assertEquals(title,footerLinkPage.getPageTitle());
    }

    @And("footer page loads successfully")
    public void footerPageLoadsSuccessfully() {
        footerLinkPage.getFooterPageTitle();
    }


    @When("user fetches table headers")
    public void userFetchesTableHeaders() {
        actualTHeaderList = domPage.getTableHeadersList();
    }

    @Then("the table headers should be")
    public void theTableHeadersShouldBe(DataTable tHeaders) {
        List<String> expectedTHeaderList = tHeaders.asList();
        System.out.println(expectedTHeaderList);
        Assert.assertEquals(actualTHeaderList.size(),expectedTHeaderList.size());
        Assert.assertTrue(actualTHeaderList.containsAll(expectedTHeaderList));
    }

    @When("user fetches table rows")
    public void userFetchesTableRows() {
       actualNoOfRows =  domPage.getTableRowNumber();
    }

    @Then("number of rows should be {int}")
    public void numberOfRowsShouldBe(int expectedNoOfRows) {
        Assert.assertEquals(expectedNoOfRows,actualNoOfRows);
    }

    @When("user fetches table columns")
    public void userFetchesTableColumns() {
        actualNoOfColumns =  domPage.getTableColumnNumber();
    }

    @Then("number of columns should be {int}")
    public void numberOfColumnsShouldBe(int expectedNoOfColumns) {
        Assert.assertEquals(expectedNoOfColumns,actualNoOfColumns);
    }

    @When("user fetches details of row {int}")
    public void userFetchesDetailsOfRow(int rowNumber) {
        actualColumnValues = domPage.getRowDetails(rowNumber);
    }

    @And("clicks on edit button")
    public void clicksOnEditButton() {
        domPage.clickEditButton();
        refreshedColumnValues = domPage.getRowDetails(1);
    }

    @Then("action should be performed {string}")
    public void actionShouldBePerformed(String urlText) {
        String changedURL = domPage.getCurrentURL();
        Assert.assertTrue(changedURL.contains(urlText));
    }

    @And("clicks on delete button")
    public void clicksOnDeleteButton() {
        domPage.clickDeleteButton();
    }

    @Then("Footer link text should be {string}")
    public void footerLinkTextShouldBe(String expectedText) {
        String actualText = domPage.getFooterLink().getText();
        Assert.assertEquals(expectedText,actualText);
    }

}
