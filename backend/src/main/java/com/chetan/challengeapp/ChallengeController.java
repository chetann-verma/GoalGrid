package com.chetan.challengeapp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.PostConstruct;

@RestController
@CrossOrigin
public class ChallengeController {

	@Autowired
	ChallengeService challengeServ;
	
	
	
	@GetMapping("/challenges")
	ResponseEntity<List<Challenge>> getAllChallenges()
	{
		List<Challenge> challenges = challengeServ.getAllChallenges();
		return  new ResponseEntity<>(challenges ,HttpStatus.OK);
	}
	
	@PostMapping("/challenges")
	ResponseEntity<String> addChallenge(@RequestBody Challenge challenge)
	{
		if(challenge!=null) {
			challengeServ.addChallenge(challenge);
			return new ResponseEntity<>("Challenge Added Successfully",HttpStatus.OK);
		}
		else
		 return new ResponseEntity<>("Failed to add",HttpStatus.BAD_REQUEST);	
	}
	
	@GetMapping("/challenges/{month}")
	ResponseEntity<Challenge> getChallengeByMonth(@PathVariable String month)
	{
		Challenge challenge = challengeServ.getChallengeByMonth(month);
		if(challenge!=null)
			return new ResponseEntity<>(challenge,HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/challenge/{id}")
	ResponseEntity<String> updateChallengeById(@PathVariable Long id,@RequestBody Challenge challenge)
	{
		
		if(challengeServ.updateById(id , challenge))
			return new ResponseEntity<>("Successfullt updated",HttpStatus.OK);
		else
			return new ResponseEntity<>("Failed to update",HttpStatus.BAD_REQUEST);	
	}
	
	@DeleteMapping("/challenge/{id}")
	ResponseEntity<String> deleteChallengeById(@PathVariable Long id)
	{
		if(challengeServ.deleteById(id))
			return new ResponseEntity<>("Successfully Deleted",HttpStatus.OK);
		else
			return new ResponseEntity<>("Failed to delete",HttpStatus.BAD_REQUEST);	
	}
}
