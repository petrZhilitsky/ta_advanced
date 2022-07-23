Feature: Adding and deleting new dashboard to Dashboards overview
  As a user
  I want to add and delete new dashboard

  Background:
    Given default user logs in the app

  Scenario Outline: (1) user adds and deletes new dashboard
    Given default user is on Dashboards page
    When user clicks Add New Dashboard button
    And user inputs dashboard name '<name>'
    And user clicks Add button
    Then Dashboard Added notification appears
    And user clicks Delete icon of dashboard
    And user clicks Delete button
    Then Dashboard Deleted notification appears
    @cucumber
    Examples:
      | name       |
      | temp_dash1 |
      | temp_dash2 |
    @smoke
    Examples:
      | name            |
      | temp_dash_smoke |

  @smoke
  Scenario: (2) user edits dashboard description
    Given default user is on Dashboards page
    When user clicks Edit icon of dashboard
    And user inputs random description
    And user clicks Update button
    Then dashboard has updated description