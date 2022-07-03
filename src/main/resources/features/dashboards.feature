Feature: Adding and deleting new dashboard to Dashboards overview
  As a user
  I want to add and delete new dashboard

  @cucumber
  Scenario: (1) user adds new dashboard
    Given default user is on Dashboards page
    When user clicks Add New Dashboard button
    And user inputs dashboard name 'Temporary_Dash'
    And user clicks Add button
    Then Dashboard Added notification appears

  @cucumber
  Scenario: (2) user deletes new dashboard
    Given default user is on Dashboards page
    When user clicks Delete icon of 'Temporary_Dash' dashboard
    And user clicks Delete button
    Then Dashboard Deleted notification appears
