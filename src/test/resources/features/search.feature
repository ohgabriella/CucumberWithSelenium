#language: en

@AllCenarios
Feature: Search website

  Background:
  Open Browser on "www.google.com"
  Search for "Amazon Brasil" and Search
  Navigate to "www.amazon.com.br" Through The Search Page

#  Scenario: 80% Of Shown Products Should Be Exclusively The Searched Product
#    Given the user open the Amazon Brasil site
#    When search for Iphone using the search bar
#    And count the total list of found products
#    And count the total of Iphone items found
#    Then make sure at least 80% of items found are Iphone

  Scenario: The Higher Price In The First Page Can't Be Greater Than U$2000
#    Given the user open the Amazon Brasil site
#    When find the more expensive Iphone in page
    And convert its value to USD
    Then make sure the converted value is not greater than US2000

#  Scenario: Products Different Than The Searched Product Should Be Cheaper Than The Searched Product
#  Given the user search for Iphone using the search bar
#  When find products which are not Iphone
#  Then make sure all found products are cheaper than the cheapest Iphone



