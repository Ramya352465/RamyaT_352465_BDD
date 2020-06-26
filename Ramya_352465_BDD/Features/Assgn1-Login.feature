Feature: Automate Gillette application- Login feature
Description: This feature will test a login functionality

  
  #Simple login with India url
  Scenario: Login functionality
    Given I launch the gillette application using URL "https://www.gillette.co.in/en-in"
    Then I click on the login link
    And I enter my email  and password 
    Then I click on the login button
    When I enter my credentials I do validate my users
    And I logout of the application
    
   