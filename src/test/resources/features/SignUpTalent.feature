@SignUp
Feature: SignUP Talent functionality

  #Verify Talent SignUp with Union Value and Credits
  @SAG-AFTRA
  Scenario: SignUp using Header Join Now option
    Given User is on login page
    Then click on JoinNow
    And user enter fullName
    #And User select the union value from dropdown and store the value
    Then Select union "SAG-AFTRA" from dropdown and store the value
    And User enters aunique email id
    Then User enters username and Password and Store username and password
    Then User enters confirm password
    And Enable the Terms and conditions Check box
    Then User click on SignUp button
    Then User login the application with Created username and password
    Then Verify user is on Home page
    And Verify selected Union value is displayed
    Then Verify credits value is displayed as "5"
    And Verify the FreeTrail label is displayed
    And click on logout button
      #Verify Talent SignUp with Union Value and Credits
  @AEA
  Scenario: SignUp using Header Join Now option
    Given User is on login page
    Then click on JoinNow
    And user enter fullName
    #And User select the union value from dropdown and store the value
    #Then Select union "AEA" from dropdown and store the value
    Then Select the union value "AEA"
    And User enters aunique email id
    Then User enters username and Password and Store username and password
    Then User enters confirm password
    And Enable the Terms and conditions Check box
    Then User click on SignUp button
    Then User login the application with Created username and password
    Then Verify user is on Home page
    And Verify selected Union value is displayed
    Then Verify credits value is displayed as "5"
    And Verify the FreeTrail label is displayed
    And click on logout button

      #Verify Talent SignUp with Union Value and Credits
  @ACTRA
  Scenario: SignUp using Header Join Now option
    Given User is on login page
    Then click on JoinNow
    And user enter fullName
    #And User select the union value from dropdown and store the value
    Then Select union "ACTRA" from dropdown and store the value
    And User enters aunique email id
    Then User enters username and Password and Store username and password
    Then User enters confirm password
    And Enable the Terms and conditions Check box
    Then User click on SignUp button
    Then User login the application with Created username and password
    Then Verify user is on Home page
    And Verify selected Union value is displayed
    Then Verify credits value is displayed as "5"
    And Verify the FreeTrail label is displayed
    And click on logout button
      #Verify Talent SignUp with Union Value and Credits
  @CAEA
  Scenario: SignUp using Header Join Now option
    Given User is on login page
    Then click on JoinNow
    And user enter fullName
    #And User select the union value from dropdown and store the value
    Then Select union "CAEA" from dropdown and store the value
    And User enters aunique email id
    Then User enters username and Password and Store username and password
    Then User enters confirm password
    And Enable the Terms and conditions Check box
    Then User click on SignUp button
    Then User login the application with Created username and password
    Then Verify user is on Home page
    And Verify selected Union value is displayed
    Then Verify credits value is displayed as "5"
    And Verify the FreeTrail label is displayed
    And click on logout button
      #Verify Talent SignUp with Union Value and Credits
  @MEAA
  Scenario: SignUp using Header Join Now option
    Given User is on login page
    Then click on JoinNow
    And user enter fullName
    #And User select the union value from dropdown and store the value
    Then Select union "MEAA" from dropdown and store the value
    And User enters aunique email id
    Then User enters username and Password and Store username and password
    Then User enters confirm password
    And Enable the Terms and conditions Check box
    Then User click on SignUp button
    Then User login the application with Created username and password
    Then Verify user is on Home page
    And Verify selected Union value is displayed
    Then Verify credits value is displayed as "5"
    And Verify the FreeTrail label is displayed
    And click on logout button
      #Verify Talent SignUp with Union Value and Credits
  @UBCP/ACTRA
  Scenario: SignUp using Header Join Now option
    Given User is on login page
    Then click on JoinNow
    And user enter fullName
    #And User select the union value from dropdown and store the value
    Then Select union "UBCP/ACTRA" from dropdown and store the value
    And User enters aunique email id
    Then User enters username and Password and Store username and password
    Then User enters confirm password
    And Enable the Terms and conditions Check box
    Then User click on SignUp button
    Then User login the application with Created username and password
    Then Verify user is on Home page
    And Verify selected Union value is displayed
    Then Verify credits value is displayed as "5"
    And Verify the FreeTrail label is displayed
    And click on logout button
      #Verify Talent SignUp with Union Value and Credits
  @UDA
  Scenario: SignUp using Header Join Now option
    Given User is on login page
    Then click on JoinNow
    And user enter fullName
    #And User select the union value from dropdown and store the value
    Then Select union "UDA" from dropdown and store the value
    And User enters aunique email id
    Then User enters username and Password and Store username and password
    Then User enters confirm password
    And Enable the Terms and conditions Check box
    Then User click on SignUp button
    Then User login the application with Created username and password
    Then Verify user is on Home page
    And Verify selected Union value is displayed
    Then Verify credits value is displayed as "5"
    And Verify the FreeTrail label is displayed
    And click on logout button

#Verify Talent SignUp with Non-Union Value and Credits
  @nonunion
  Scenario: SignUp using Header Join Now option
    Given User is on login page
    Then click on JoinNow
    And user enter fullName
    Then Select union "Non-Union" from dropdown and store the value
    And User enters aunique email id
    Then User enters username and Password and Store username and password
    Then User enters confirm password
    And Enable the Terms and conditions Check box
    Then User click on SignUp button
    Then User login the application with Created username and password
    Then Verify user is on Home page
    And Verify selected Union value is displayed
    Then Verify credits value is displayed as "3"
    And Verify the FreeTrail label is displayed
    And click on logout button
