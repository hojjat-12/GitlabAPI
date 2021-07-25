# GitlabAPI
A simple spring boot project that use gitlabAPI for handle some http request.

An easy method for run the project is install spring-boot-cli and maven. I share a simple youtube video that learn how to get started with spring boot and maven with Eclips IDE.
https://www.youtube.com/watch?v=UfOxcrxhC0s (first 20 minutes is enough for run my project)

Another method that can help to run project is in this link : https://spring.io/guides/gs/spring-boot/

To see my principal source code go to src/main/java/com/example/demo directory.

This project runs on port 8181 and i use Postman for test my API. We have 2 scenario in this project.

scenario 1:
- The user sends a POST request to your API, with their id <userId> and Gitlab access token <gitlabAccessToken>
- The API keeps these values internally (you don't need any database or caching mechanism, simply store it inside a variable as long as it keeps its value over the following requests)
- The user sends a GET request to your API, with their id set as a header <userId> in the request. The id of the project is provided as part of the request url.
- Your API makes a request to the right Gitlab API with the access token user previously provided and responds to the user with exactly the same content received from the Gitlab API

scenario 2:
- The user sends a GET request to your API, with their id set as a header <userId> in the request. The id of the project is provided as part of the request url.
- As the user has never provided their gitlabAccessToken before your API responds with the status code 400
  
In first and second picture i test first scenario: (please pay attention to red rectangles)

![postman1](https://user-images.githubusercontent.com/51695882/126911768-0118cc4a-b700-427a-b4ac-a421e739e668.jpg)

Second picture:

![postman2](https://user-images.githubusercontent.com/51695882/126911921-16c287e0-50d0-4eb4-86f9-538e43c4e95c.jpg)

The third picture shows second scenario: (note that in this scenario we send GET request while we haven't POST userId and access token yet.)

![postman3](https://user-images.githubusercontent.com/51695882/126912220-6d66aef1-a4a1-4c30-8302-701328e0827d.jpg)
