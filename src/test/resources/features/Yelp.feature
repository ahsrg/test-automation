Feature: Search Yelp
  Background:
    Given user navigates to https://www.saucedemo.com/
    And login as standard user

  Scenario: Go to product page

    Given user go to About tab
    Then user goes back to Product page
    And order products from lowest to highest price

  Scenario Outline: Buy the 4 most expensive products

    Given user order products from highest to lowest price
    Then user add the <productQuantity> most expensive products
    And review that shopping cart contains <productQuantity> products

    Examples:
      |productQuantity|
      |4|

