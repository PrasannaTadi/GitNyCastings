@IntroPageValidation
Feature: Navigating to the intro pages Functionality

  Scenario: Successful Navigating to the intro page
    Given User is on login page
    Then click on directSubmit logo
    Then Verify Intro page URL
    And Verify DirectSubmit logo is displayed
    And Verify I AM TALENT toggle text is displayed
    And Verify I'M A CASTING DIRECTOR toggle text is displayed
#    And Verify the toggle button is displayed
#    And Verify Casting Calls menu is displayed
#    And Verify Post Casting Notice menu is displayed
#    And Verify Log In button is displayed
#    And Verify Join Now button is displayed
    And Verify Start Free Trial button is displayed
    And Verify See Today's Casting Calls button is displayed
    And Verify Direct Submit booked heading is displayed
    And Verify Description text is displayed
#    And Verify Statistics section is displayed
