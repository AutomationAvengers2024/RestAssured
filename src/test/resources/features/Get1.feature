Feature: 
  Get All User Details
Scenario Outline: Check if Admin able to get all users with valid endpoint
    Given Admin creates GET request with valid endpoint "<resource>"
    When Admin sends GET request with valid end point
    Then Admin receives "<statuscode>"  Ok status with response body

    Examples: 
      | resource   | statuscode |
      | /uap/users |        200 |
