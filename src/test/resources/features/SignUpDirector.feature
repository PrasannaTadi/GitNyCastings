@SignUpDirector
Feature: SignUP Director functionality

  #Verify Director login

  Scenario: SignUp using Header Join Now option
    Given User is on login page
    Then click on JoinNow
    And click on casting directors
    And user enter fullName
    And User enter the companyname
    And User enter the phonenumber
    And User enters aunique email id
    Then User enters username and Password and Store username and password
    Then User enters confirm password
    And Enable the Terms and conditions Check box
    Then User click on SignUp button
    Then User login the application with Created username and password
    And Verify the WelocmeText for newDirector
    Then Verify Search Talent is disabled
    And click on logout button
