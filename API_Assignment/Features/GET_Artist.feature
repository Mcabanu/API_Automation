Feature: Get an Artist for a single artist identified by their unique Spotify ID
# GET /v1/artists/{id}
	
Background:
	Given Spotify API token is ready 

@Test	
Scenario: GET valid artist 
	Given Send a GET HTTP request to retreive an existing artist
	Then The HTTP status code in the response header is 200
	And The Response body contains an object in JSON format
	And The JSON object contains following keys
		| external_urls		| value	|
		| followers			| value	|
		| genres			| value	|
		| href				| value	|
		| id				| value	|
		| images			| value	|
		| name        		| value	|
		| popularity        | value	|
		| type 				| value	|
		| uri       	   	| value	|
	
	@Test	
Scenario: GET invalid artist 
	Given Send a GET HTTP request to retreive a non-existing artist
	Then The HTTP status code in the response header is 400
	And The Response body contains an object in JSON format
	And The JSON object contains error information

