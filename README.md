# AuthorizationService

## The purpose of the application

The purpose of the application is to check what permissions a given user has by logic and password and react accordingly to incorrect data by setting the appropriate response code to the request

## Usage example


https://user-images.githubusercontent.com/66965572/233117163-f1f0fce9-b666-4239-bd5e-23fc2f51b3a7.mov

### Explanation
**case 1:** when the user data, namely username and password are entered correctly, user permissions are shown  

**case 2:** when the data is entered incorrectly, namely the wrong username and/or password is entered, then the statuscode is set to 400 for the response and the corresponding error message is displayed  

**case 3:** when the data is entered incorrectly, namely the username and/or password is not entered, then the statuscode is set to 401 for the response and the corresponding error message is displayed  


