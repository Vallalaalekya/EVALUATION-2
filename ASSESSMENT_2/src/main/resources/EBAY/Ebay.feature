
@tag
Feature: Functionality of ebay Advanced search feature
  

  @tag1
  Scenario: functionality of ebay Advanced Search feature
    Given open browser, enter the ebay URL
    When user should access the advanced search page
    And  user should select the appropriate search options
    And user click on  the search options link
    And user should handle the new window and assert it and back to parent window
    And user should enter the search details 
    And user should click on search button
    Then User should see  "No exact matches found"
    And user should close the browser

  