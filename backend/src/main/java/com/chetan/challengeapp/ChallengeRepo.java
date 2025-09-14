package com.chetan.challengeapp;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ChallengeRepo extends JpaRepository<Challenge, Long> {

	Optional<Challenge> getByMonthIgnoreCase(String month);

}
