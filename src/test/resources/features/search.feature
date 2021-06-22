#language: en

@AllCenarios
Feature: Search website
  Background:
  Open Browser on "www.google.com"
  Search for "Amazon Brasil" and Search
  Navigate to "www.amazon.com.br" Through The Search Page

  Scenario: 80% Of Shown Products Should Be Exclusively The Searched Product
    Given The User Open the Amazon Brasil Site
    When Search For Iphone Using The Search Bar
    And Count The Total List Of Found Products
    And Count The Total Of Iphone Items Found
    Then Make Sure At Least 80% Of Items Found are Iphone

  Scenario: The Higher Price In The First Page Can't Be Greater Than U$2000

  Scenario: Products Different Than The Searched Product Should Be Cheaper Than The
  Searched Product



