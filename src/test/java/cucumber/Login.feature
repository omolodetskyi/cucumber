#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Login
  Login page to ask user for authentication

  @postive
  Scenario: Login with correct username/password
    Given Open http://the-internet.herokuapp.com/
    And click Form Authentication link
    When I enter "tomsmith" in username field and enter "SuperSecretPassword!" in password field and click Login button
    Then Secure Area page is opened
    And You logged into a secure area! message appears
    
   @negative
   Scenario Outline: Login with incorrect username/password
   Given Open http://the-internet.herokuapp.com/
   And click Form Authentication link
   When I enter incorrect "<userName>" in username field and enter "<password>" in password field and click Login button
   Then "<errorMessage>" message appears
   
   Examples:
   |userName|password|errorMessage|
   |incorrectUserName|SuperSecretPassword!|Your username is invalid!|
   |tomsmith|incorrectPassword|Your password is invalid!|