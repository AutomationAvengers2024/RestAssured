
@put
Feature:PUT request in UserAPI 

  Scenario Outline:  PUT request with valid and invalid data
    Given Admin has a valid/invalid request body for put operation from sheet name "<sheetname>" at row number <rownumber>
    When Admin sends a PUT request to the valid endpoint 
    Then The API should return corresponding status code 
Examples:
|sheetname|rownumber|
|putdata|1|
|putdata|2|
|putdata|3|