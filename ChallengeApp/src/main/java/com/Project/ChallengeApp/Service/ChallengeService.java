package com.Project.ChallengeApp.Service;

import com.Project.ChallengeApp.model.Challenge;
import com.Project.ChallengeApp.repository.ChallenegeRpository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ChallengeService {

//    private List<Challenge> challenges = new ArrayList<>();

    private Long NextId = 1L;

    @Autowired
    private ChallenegeRpository challengerepository;

    public List<Challenge> getAllChallenges() {
        return challengerepository.findAll();
    }

    public boolean addChallenge(Challenge challenge) {
        if (challenge != null) {
            challenge.setId(NextId++);
            challengerepository.save(challenge);
            return true;
        }
        return false;
    }

    public Challenge getChallenge(String Month) {
        Optional<Challenge> challenge = challengerepository.findByMonthIgnoreCase(Month);
        return challenge.orElse(null);
    }

    public boolean UpdateChallenge(Long id, Challenge updateChallenge) {
        Optional<Challenge> challenge =  challengerepository.findById(id);
            if (challenge.isPresent()) {
                Challenge challengeToUpdate = challenge.get();
                challengeToUpdate.setMonth(updateChallenge.getMonth());
                challengeToUpdate.setDescription(updateChallenge.getDescription());
                challengerepository.save(challengeToUpdate);
                return true;
            }
        return false;
    }

    public boolean DeleteChallenge(Long id) {
        Optional<Challenge> challenge =  challengerepository.findById(id);
        if (challenge.isPresent()) {
         challengerepository.deleteById(id);
         return true;
    }
        return false;
}
}
