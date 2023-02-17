Feature: Search Yelp
  Background:
    Given user navigates to https://www.saucedemo.com/
    And login as standard user

  Scenario: Go to product page

    Given user go to About tab
    And user goes back to Product page

#  Scenario Outline: Add lowes price products to cart
#
#    Given User search restaurant <type>
#    When filter by <neighbourhoods>
#    And select the first search result
#    Then User views restaurants information
#
#    Examples:
#      |type|neighbourhoods|
#      |Pizza|Glen Park    |
#      |Fish |Glen Park    |