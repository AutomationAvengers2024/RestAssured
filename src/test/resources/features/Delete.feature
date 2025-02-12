Feature: Delete User with UserID
Scenario: Validate valid user ID in DELETE request
Given Admin creates the DELETE request with valid UserID endpoint
When Admin sends Delete request with valid endpoint and valid userid
Then Admin receives 200 OK status 
