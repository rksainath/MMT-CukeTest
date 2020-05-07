Feature: Check the landing page of Make My Trip

  @RegressionTest
  Scenario Outline: Plan a one way journey
  Given I have landed in the MMT page
  Then I choose my <departure> departure place
  Then I choose my <arrival> arrival place
  Then I choose my <dateOnward> for onward journey
  And Search for the availability of flights
  Then Close the browser
  
  Examples:
  | departure | arrival   | dateOnward |
  | "Mumbai"  | "Chennai" | "9"        |
 