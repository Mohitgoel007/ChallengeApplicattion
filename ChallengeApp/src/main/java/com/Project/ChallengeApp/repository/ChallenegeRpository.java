package com.Project.ChallengeApp.repository;

import com.Project.ChallengeApp.model.Challenge;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

//CRUD
public interface ChallenegeRpository extends JpaRepository<Challenge,Long> {
    Optional<Challenge> findByMonthIgnoreCase(String Month);
}
