Feature: Search Yelp
  Background:
    Given user navigates to https://www.saucedemo.com/
    And login as standard user

  Scenario: Go to product page

    Given user go to About tab
    Then user goes back to Product page
    And order products from lowest to highest price

  Scenario Outline: Buy the most expensive products

    Given user order products from highest to lowest price
    Then user add to cart the <productQuantity> most expensive products
    And review that shopping cart contains <productQuantity> products
    Then user go to shopping cart
    And complete checkout process

    Examples:
      |productQuantity|
      |4|

