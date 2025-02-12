Feature: 
  Get All User Details

  Background: Admin set the basic Auth for Authorization
    Given Admin is on the UserApi
    Then Admin sets Basic Authentication using the username "Numpy@gmail.com" and password "userapi@2025"

  @GetAllUsers
  Scenario: Check if Admin able to get all users with valid endpoint
    Given Admin creates GET request with valid endpoint "/uap/users"
    When Admin sends Get request with valid endpoint for all users
    Then Admin receives "200" Status code

  @Getinvalid
  Scenario Outline: Check if Admin able to retrive all users with invalid endpoint
    Given Admin creates Get request with invalid endpoint "<invalidendpoint>"
    When Admin sends GET request with invalid endpoint
    Then Admin receives 404 not found status with response body

    Examples: 
      | invalidendpoint |
      | uap/users/uap   |
      | uap/90          |
      | uap/user/100    |

  @Get_User_ID_First_Name_Valid
  Scenario Outline: Check if Admin is able to GET user by valid USER ID and valid Firstname
    Given Admin set the GET request with valid endpoint "<endpoint>"
    When Admin sends an HTTP GET request with the valid endpoint
    Then Admin receives a "200" and  "OK" status code

    Examples: 
      | endpoint               |
      | uap/user/1            |
      | uap/users/username/NumpyNinja |
