Feature: Get an a playlist identified by their unique user ID
	# GET /v1/users/{user_id}/playlists
	
Background:
	Given Spotify API token is ready 
	
	@Test1
Scenario: GET valid playlist 
	Given Send a GET HTTP request to retreive an existing playlist
	Then The HTTP status code in the response header is 200
	And The Response body contains an object in JSON format