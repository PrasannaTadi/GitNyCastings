@PostCastingCallLogin
Feature: Verify Posting New Casting Call

#  Scenario: Creating Draft notice from the Director
#    Given User is on login page
#    Then enter Username
#    Then enter password
#    And click on login button
##    Then User enters username "Lakshmiiii" and password "Test@1234"
##    Then click on login button
#    Then Click on Create New casting call
#    Then Enter the Project title and Store the Title
#    Then Select union "SAG-AFTRA" from Union dropdown and store the value
#    And Add Casting info text data
#    Then Select the Pay Type from dropdown
#    Then add payScale
#    Then add Description
#    And Select location "California (San Francisco)" from dropdown and store the value
#    Then Select Category "Comedy Clubs" from dropdown and store the value
#    Then select the expirydate
#    #Then Select the date and Store the value
#    And Upload the Picture
#    And Upload the Script
#    And click on save as Draft
#    Then Verify the navigated to projects page
#    And Verify created notice title is displaying on the top od the list and Pending Label is showing

  Scenario: Posting notice from the Director
   Given User is on login page
   Then enter Username
    Then enter password
    And click on login button
    Then Click on Create New casting call
    Then Enter the Project title and Store the Title
    Then Select union "SAG-AFTRA" from Union dropdown and store the value
    And Add Casting info text data
    Then Select the Pay Type from dropdown
    Then add payScale
    Then add Description
    And Select location "California (San Francisco)" from dropdown and store the value
    Then Select Category "Comedy Clubs" from dropdown and store the value
    Then select the expirydate
    And Upload the Picture
    And Upload the Script
    And click on save and continue
    Then Verify user is navigated to role Creator page
    And Preview Notice Button is disabled
    Then Add the Role Name and Store the value
    And Age min and max
    And Select the Gender from the dropdown
    And Select the Ethnicity from the dropdown
    And Select the Role type from the dropdwon
    Then click on save the Role
    And Verify added role displaying on page with title
    Then Verify preview Notice is enabled
    And click on Preview notice
    Then Verify preview Notice page is opened
    And Verify Notice details and Role Details
    Then click on SUBMIT NOTICE button
   And Verify created notice title is displaying on the top of the list and Pending Label is showing
   #//div[contains(@class,'css-17a5j2x')]
   And Verify the added Location is showing
  #(.//p[contains(@class,'MuiTypography-body2')])[1]

   And click on logout button
#    And Verify User navigated to dashboard page
#    And Verify the created project title is displaying with Pending tag
#   And click on logout button
   When login as a Admin
   Then verify user is on Admin Dashboard page
   And Approve the Notice

