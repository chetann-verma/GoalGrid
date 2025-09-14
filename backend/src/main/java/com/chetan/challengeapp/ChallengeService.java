package com.chetan.challengeapp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChallengeService {

	@Autowired
	ChallengeRepo repo;
	
	public List<Challenge> getAllChallenges() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public void addChallenge(Challenge challenge) {
		// TODO Auto-generated method stub
		
		 repo.save(challenge);
	}

	public Challenge getChallengeByMonth(String month) {
		// TODO Auto-generated method stub
		
		Optional<Challenge> challenge = repo.getByMonthIgnoreCase(month);
		return challenge.orElse(null);
	}

	

	public boolean updateById(Long id, Challenge challenge) {
		// TODO Auto-generated method stub
		Optional<Challenge> challenge1 = repo.findById(id);
		if(challenge1.isPresent())
		{
			Challenge challengeToUpdate = challenge1.get();
			challengeToUpdate.setDescription(challenge.getDescription());
			//challengeToUpdate.setId(challenge.getId());
			challengeToUpdate.setMonth(challenge.getMonth());
			repo.save(challengeToUpdate);
			return true;
		}
		else
		 return false;
	}

	public boolean deleteById(Long id) {
		// TODO Auto-generated method stub
		Optional<Challenge> challenge1 = repo.findById(id);
		if(challenge1.isPresent())
		{
			repo.deleteById(id);
			return true;
		}
		else
			return false;
	
	}

	
}
