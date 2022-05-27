# API_Automation
This is a Automation testing framework for testing API 

**API Details**
From https://any-api.com select sptify API

**API Key Details**

1.Go to the URL https://any-api.com/spotify_com/spotify_com/console 
2. Then click lock image
3. In API Authorization choose Oauth 2.0 Accescode
4. Then click select all option
5. Then click the Authorize button
6. Now spotify login page open,
7.Login with your username and password of your spotify Account
8.After login you get the token for for unlock
9. copy that token and paste it in the src/test/implements/stepimplements -- api_key value
10. Then save and excecute the programe


Note: Api_token is expires in one hour, so please generate a token before excecuting the Test and place in the Api_key place

