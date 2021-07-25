package com.example.demo;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class GitlabApiController {
	
	@PostMapping("/token")
	@ResponseBody
	public String handlePostUserInfo(@RequestBody UserInfo userInfo) throws Exception {
		
		// add body of POST request that contains userId and gitlabAccessToken to the storage
		Storage.add(userInfo);
		return "OK. UserId and gitlabAccessToken successfully stored.";
	}
	
	@GetMapping("/projects/{projectId}/repository_tree")
	public String handleGetRep(@PathVariable String projectId,
			@RequestHeader("userId") String userId) {
		
		// my gitlab access token (my username in gitlab: "hojjat-12")
		// "AakdgYF2Q7mMMEKPUzCx"
		
		// id of a private project for test (my username in gitlab: "hojjat-12")
		// "28371488"
		// this repository has two simple html file (test_page3.html and test_page4.html)
		
		// for failure response code: 400
		if (Storage.getUsers().get(userId)==null) 
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found!");
		
		// load gitlabAccessToken from storage class
		String accessToken = Storage.getUsers().get(userId).toString();
		
		final String req = "https://gitlab.com/api/v4/projects/" + projectId + "/repository/tree";
		
		// initialize headers for add PRIVATE-TOKEN to header of get request
	    HttpHeaders headers = new HttpHeaders();
	    headers.set("PRIVATE-TOKEN", accessToken);
	    HttpEntity entity = new HttpEntity(headers);
	    
	    RestTemplate restTemplate = new RestTemplate();
	    // use a HTTP GET request for get repositories
	    ResponseEntity<String> response = restTemplate.exchange(
	    	    req, HttpMethod.GET, entity, String.class);
	    String result = response.getBody();
		
	    // System.out.println(result);
		return result;
	}
}
