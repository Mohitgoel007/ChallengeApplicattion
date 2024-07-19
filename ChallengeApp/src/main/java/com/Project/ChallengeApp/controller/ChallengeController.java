package com.Project.ChallengeApp.controller;

import com.Project.ChallengeApp.Service.ChallengeService;
import com.Project.ChallengeApp.model.Challenge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/challenges")
@CrossOrigin(origins = "http://localhost:3000")
public class ChallengeController {

    @Autowired
    private ChallengeService challengeService;

    @GetMapping()
    public ResponseEntity<List<Challenge>> getAllChallenges() {
        return new ResponseEntity<>(challengeService.getAllChallenges(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<String> addChallenge(@RequestBody Challenge challenge) {
        boolean IsChallengedAdded = challengeService.addChallenge(challenge);
        if (IsChallengedAdded)
            return new ResponseEntity<>("Challenge Added Successfully", HttpStatus.OK);
        return new ResponseEntity<>("Challenge Not Added Successfully", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{Month}")
    public ResponseEntity<Challenge> getChallenge(@PathVariable String Month) {
        Challenge challenge = challengeService.getChallenge(Month);
        if (challenge != null)
            return new ResponseEntity<>(challenge, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> UpdateChallenge(@PathVariable Long id, @RequestBody Challenge UpdateChallenge) {
        boolean IsChallengeUpdated = challengeService.UpdateChallenge(id, UpdateChallenge);
        if (IsChallengeUpdated)
            return new ResponseEntity<>("Challenge Updated Successfully", HttpStatus.OK);
        return new ResponseEntity<>("Challenge Not Updated Successfully", HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> DeleteChallenge(@PathVariable Long id) {
        boolean IsChallengeDeleted = challengeService.DeleteChallenge(id);
        if (IsChallengeDeleted)
            return new ResponseEntity<>("Challenge Deleted Successfully", HttpStatus.OK);
        return new ResponseEntity<>("Challenge Not Deleted Successfully", HttpStatus.NOT_FOUND);

    }
}
