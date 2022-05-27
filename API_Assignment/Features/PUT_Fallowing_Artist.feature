Feature:  Update the current user as a follower of one or more artists or other Spotify users
	#PUT /v1/me/following	
	
Background: 
	Given Spotify API token is ready 
	
	@Test	
Scenario: PUT follow a valid artist
	Given Send a PUT HTTP request to follow an existing artist
	Then The HTTP status code in the response header is 204
	And The Response body is empty

@Test	
Scenario: PUT follow an invalid artist 
	Given Send a PUT HTTP request to follow a non-existing artist
	Then The HTTP status code in the response header is 400
	And The Response body contains an object in JSON format
	And The JSON object contains error information