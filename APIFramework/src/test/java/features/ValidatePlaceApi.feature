Feature: Validating place API
@addApi
Scenario Outline: Verify if place is being successfully added using place API
Given Add place PayLoad with "<name>" "<Address>" "<Language>"
When user calls "addPlaceAPI" with "post" http request
Then Api call got sucess with status code 200
And "status" in response body is "OK" 
And "scope" in response body is "APP" 
And Verify Place id created maps to "<name>" using "getPlaceAPI"

Examples:
|name       |Address    |Language|
|Ajith      |Salem      |Tamil   |
#|kay Kailash|Dadagapatti|Telugu  |

@DeleteApi
Scenario: Verify if place is deleted using delete api
Given Add Deleteplace PayLoad
When user calls "deletePlaceAPI" with "post" http request
Then Api call got sucess with status code 200
And "status" in response body is "OK" 
