package com.wipro.CodeChallenge.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

//any other field other than specified in userentity will be ignoed
@JsonIgnoreProperties(ignoreUnknown = true)

public class UserEntity
{
    private int userId;
    @Id private int id;     //id is the primary key of entity
    private String title;
    private String body;
}
