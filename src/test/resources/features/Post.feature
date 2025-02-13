@post
Feature: Create a New User

  Scenario Outline: Create a new user valid data and invalid data
    Given Admin creates post request with valid data in request body from sheet name "<sheetname>" and <rownumber>
    When Admin sends post request with valid endpoint
    Then Admin receives created with response body

    Examples: 
      | sheetname | rownumber |
      | post  |         1 |
      | post  |         2 |
      | post  |         3 |
      | post  |         4 |
