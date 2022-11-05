package com.wipro.CodeChallenge.Controller;

import com.wipro.CodeChallenge.Entity.UserEntity;
import com.wipro.CodeChallenge.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/userDetails")
public class UserController
{
    @Autowired
    UserService service;
//Mapping end point for tally the unique userid's
    @GetMapping("/userIdCount")
    public Map<String, Integer> userIdCount()
    {
        return service.userIdCount();
    }

//Mapping the endpoint for updated array item

// precoded to change 4th Json array item as in code challenge
    @GetMapping("/updatedUserList")
    public List<UserEntity> updatedUserList()
    {
        return service.changedData();
    }

// using payload to change the data by input from user
    @PostMapping("/updatedUserList")
    public List<UserEntity> updatedUserList_param(@RequestParam("arrayIndex") int arrayIndex)
    {
        return service.changedData_param(arrayIndex);
    }

}

