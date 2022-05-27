Feature: Get an Album for a single album identified by their unique Spotify ID
	# GET /v1/albums/{id}
	
Background:
	Given Spotify API token is ready 
	
	@Test	
Scenario: GET valid album 
	Given Send a GET HTTP request to retreive an existing album
	Then The HTTP status code in the response header is 200
	And The Response body contains an object in JSON format
	And The JSON object contains following keys
	
  	| album_type	| value	|
  	| artists	    | value	|
		| external_urls	| value	|
		| href				  | value	|
		| id			     	| value	|
		| name        	| value	|
		| type 			  	| value	|
		| uri       	  | value	|
		| available_markets	| value	|
	
	@Test	
	Scenario: GET invalid album 
	Given Send a GET HTTP request to retreive a non-existing album
	Then The HTTP status code in the response header is 400
	And The Response body contains an object in JSON format
	And The JSON object contains error information
	