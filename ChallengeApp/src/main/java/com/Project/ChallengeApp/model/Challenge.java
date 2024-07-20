package com.Project.ChallengeApp.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

//import javax.persistence.GenerationType;

@Getter
@Setter
@Entity
public class Challenge {

    @Id
    private Long id;

    @Column(name = "ChallengeMonth")
    private String month;

    private String description;
}
