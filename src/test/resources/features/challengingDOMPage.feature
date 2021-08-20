Feature: Tests Challenging DOM Page

  @Regression
  Scenario: User is able to load the Challenging DOM Page
    When user hits the url in browser
    Then page loads successfully

  @Regression
  Scenario: Page Title Details
    Given user is on the dom page
    When user gets the title of the page
    Then page title should be "The Internet"

  @Regression
  Scenario: Page Header Details
    Given user is on the dom page
    Then page Header should be "Challenging DOM"

  @Regression
  Scenario: Page Description Details
    Given user is on the dom page
    Then page Description should be "The hardest part in automated web testing is finding the best locators (e.g., ones that well named, unique, and unlikely to change). It's more often than not that the application you're testing was not built with this concept in mind. This example demonstrates that with unique IDs, a table with no helpful locators, and a canvas element."

  @Regression
  Scenario: User is able to click on blue button and answer in canvas updates
    Given user is on the dom page
    And user fetch value from canvas
    When user clicks blue button
    Then the answer canvas updates

  @Regression
  Scenario: User is able to click on red button and answer in canvas updates
    Given user is on the dom page
    And user fetch value from canvas
    When user clicks red button
    Then the answer canvas updates

  @Regression
  Scenario: User is able to click on green button and answer in canvas updates
    Given user is on the dom page
    And user fetch value from canvas
    When user clicks green button
    Then the answer canvas updates

  @Regression
  Scenario: User is able to interact with Canvas answer field
    When user is on the dom page
    Then answer canvas is visible

  @Regression
  Scenario: User is able to see the correct table headers
    Given user is on the dom page
    When user fetches table headers
    Then the table headers should be
    |Lorem|Ipsum|Dolor|Sit|Amet|Diceret|Action|

  @Regression
  Scenario: User is able to get correct number of table rows
    Given user is on the dom page
    When user fetches table rows
    Then number of rows should be 10

  @Regression
  Scenario: User is able to get correct number of table columns
    Given user is on the dom page
    When user fetches table columns
    Then number of columns should be 7

    ## As unable to Edit row on Edit Action Verifying the action with URL change
  @Functional
  Scenario: User is able to edit first row
    Given user is on the dom page
    When user fetches details of row 1
    And clicks on edit button
    Then action should be performed "#edit"

    ## As unable to Delete row on delete Action Verifying the action with URL change
  @Functional
  Scenario: User is able to delete second row
    Given user is on the dom page
    When user fetches details of row 2
    And clicks on delete button
    Then action should be performed "#delete"

    ## Deliberately failing the Test to Capture Failed scenario in Extent Report
  @Functional
  Scenario: Footer link loads
    Given user is on the dom page
    Then Footer link text should be "Elemental Selenium.."