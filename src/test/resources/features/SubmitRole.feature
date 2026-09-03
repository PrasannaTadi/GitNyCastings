@RoleSubmission
Feature: Submission for the new Role
  Scenario: Talent applying for the Role
    Given User is on login page
    Then enter Username
    Then enter password
    And click on login button
    Given User is On the CastingNotices Page
    Then Click on the NoticeTitle
    Then Verify user navigating to the child window
    And Click on the Role title
    And Select the Media
    Then Click on the Submit button
    And Verify applied tag is showing on the main casting notices page
    And click on logout button

