Feature: Automate goibibo application
Description: This feature will test a booking functionality

  Scenario: Booking functionality
    Given Enter the URL "https://www.goibibo.com/"
    Then Choose a trip and select from and To place
    And Choose a departure and return date
    Then Click on the search button
    And Select flight and book a ticket
    And Verify the booking ticket