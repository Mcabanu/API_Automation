package Implements;

import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class StepIplementations {
	
	private RequestSpecification request;
    private Response response;
    private String baseUri;
    private String api_token;
    private String artist_id;

    private String album_id;
    private String market_code;
    
    private String User_ID;
    
    
    public StepIplementations() {
    	//@TODO: Init system, automatic auth token to avoid expirations
    	//https://beta.developer.spotify.com/documentation/ios-sdk/guides/token-swap-and-refresh/
    	baseUri = "https://api.spotify.com";
    	api_token = "BQAQ9Ey5D3Je9KRWWLVXhFx6trgaEb1c2eXNzYiBzv9EKV0NjHI5S_2pHmcW4tkXNnLW_rpftnX2m3T03p_28qFhZsCFyxsb5lL6ROdHIgpB8auzeW35uUUauS0GLSy14gKBhu2epzE45Y8zIxfWCgIp3PcZMCvr8tERQqvZx1_HTGImcG3IYQt9Dz0ioO89awp1fdyckaSamsT6z8pIT8TjxjfWFpas8t31db_iqdpr64XaKMNnDpJkTyF5-2hC9hPy3Uv9BZ3hj08DOobdJsQKyTtC8A";
		artist_id = "0OdUWJ0sBjDrqHygGUXeCF"; //Band of Horses
    	request = RestAssured.with();
    	
    	album_id = "4aawyAB9vmqN3uQ7FjRGTy";
    	market_code= "ES";
    	
    	User_ID = "smedjan";
	}
    
  //  ----------------------------@tag-------------------
    
	public void RetreiveArtist(boolean real_artist){
		
		String uri_path = "/v1/artists/";		
		try {
			request.given()
				.header("Authorization", "Bearer "+ api_token)
            	//.contentType(ContentType.JSON)
            	.baseUri(baseUri);
			
			String id =  artist_id;
			if (real_artist == false){
				id = ""; //invalid ID
			}
					
			response = request.when().get(uri_path + id);
			//System.out.println("Response: " + response.prettyPrint());
			
		}		
		catch (Exception e){
			if(e.getMessage().contains("Connection refused")){System.out.println("Web application is not running.");return;}
			else{System.out.println("Unknown exception while invoking this request.");e.printStackTrace();}return;
		}
	}
	
	
	//===================================PUT feature====================
	
	public void FollowArtist(boolean real_artist) 
	{
		String uri_path = "/v1/me/following";		
		try {
			
			String id = artist_id;
			if (real_artist == false){
				id = ""; //invalid ID
			}
			
			request.given()
				.header("Authorization", "Bearer "+ api_token)
            	.baseUri(baseUri)
            	.contentType(ContentType.JSON)
				.param("type", "artist")
				.param("ids", id);
	
			response = request.when().put(uri_path + "");
			//System.out.println("Response: " + response.prettyPrint());
			
		}		
		catch (Exception e){
			if(e.getMessage().contains("Connection refused")){System.out.println("Web application is not running.");return;}
			else{System.out.println("Unknown exception while invoking this request.");e.printStackTrace();}return;
		}		
	}

	//--------------------------------------------------------------------------------------
public void RetreiveAlbum(boolean real_album)
    {
	
		String uri_path = "/v1/albums/";		
		try {
			request.given()
				.header("Authorization", "Bearer "+ api_token)
            	//.contentType(ContentType.JSON)
            	.baseUri(baseUri);
			
			String id1 = album_id;
			if (real_album == false){
				id1 = ""; //invalid ID
			}
					
			response = request.when().get(uri_path + id1);
			//System.out.println("Response: " + response.prettyPrint());
			
		}		
		catch (Exception e){
			if(e.getMessage().contains("Connection refused")){System.out.println("Web application is not running.");return;}
			else{System.out.println("Unknown exception while invoking this request.");e.printStackTrace();}return;
		}
	}

//------------------------------------------------------------------------------------------

public void RetreivePlaylist(boolean real_user){
	
	String uri_path = "/v1/users/smedjan/playlists";		
	try {
		
		String uid = User_ID;
		if (real_user == false){
			uid = ""; //invalid ID
		}
			
		request.given()
			.header("Authorization", "Bearer "+ api_token)
        	.baseUri(baseUri);
		
			
		response = request.when().get(uri_path  );
		//System.out.println("Response: " + response.prettyPrint());
		
	}		
	catch (Exception e){
		if(e.getMessage().contains("Connection refused")){System.out.println("Web application is not running.");return;}
		else{System.out.println("Unknown exception while invoking this request.");e.printStackTrace();}return;
	}
}

//================================================================================================

public void CheckResponse(int response_code) {
	response.then().statusCode(response_code);
}

public void CheckBodyJson() {
	response.then().contentType(ContentType.JSON);
}	

public void CheckJsonFields(Map<String,String> json_fields) {
	for (Map.Entry<String, String> field : json_fields.entrySet()) {
		assert response.body().jsonPath().get(field.getKey()) != null;
	}		
}

public void CheckBodyEmpty() {
	assert response.body().asString() == "";
}

public void CheckJsonFieldContainsErrorInfo() {
	JsonPath jsonPath = response.jsonPath();
	//System.out.println(jsonPath.get("error"));
	assert jsonPath.get("error") != null;
}
}

