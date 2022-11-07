package com.wipro.CodeChallenge.Service;

import com.wipro.CodeChallenge.Entity.UserEntity;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService
{
    RestTemplate restTemplate;

    public UserService(RestTemplateBuilder restTemplateBuilder)
    {
        this.restTemplate = restTemplateBuilder.build();
    }

//Logic for tally number of unique userId's in given link
    public Map<String,Integer>userIdCounter() throws RuntimeException
    {
        try
        {
            UserEntity[] user = restTemplate.getForObject("http://jsonplaceholder.typicode.com/posts", UserEntity[].class);
            List<UserEntity> list;
            if (user != null)
            {
                list = new ArrayList<>(List.of(user));
                Map<Integer, List<UserEntity>> userIdMap = list.stream().collect(Collectors.groupingBy(UserEntity::getUserId));
                Map<String, Integer> resultMap = new HashMap<>();
                userIdMap.forEach((key, value) -> resultMap.put("userId " + key, value.size()));
                return resultMap;
            }
            else
            {
                throw new NullPointerException("user is null");
            }
        }
        catch (RuntimeException e)
        {
            throw new RuntimeException("Got a Run Time Exception");
        }
    }

//Logic for changing data 4 th array item of given link by hard coding
    public List<UserEntity> changedData() throws NullPointerException
    {
        try
        {
            UserEntity[] user = restTemplate.getForObject("http://jsonplaceholder.typicode.com/posts", UserEntity[].class);
            List<UserEntity> list;
            if (user != null)
            {
                list = new ArrayList<>(List.of(user));
                list.get(4).setTitle("1800 Flowers");   //setting Tittle of 4 th json array item to 1800Flowers
                list.get(4).setBody("1800 Flowers");    //setting Body of 4 th json array item to 1800Flowers
                return list;
            }
            else
            {
                throw new NullPointerException("user is null");
            }
        }
        catch (RuntimeException e)
        {
            throw new NullPointerException("Got a Runtime Exception");
        }
    }

// Logic for changing data at specified array index of given link by requesting parameter at endpoint
    public List<UserEntity> changedData_param(int arrayIndex) throws NullPointerException
    {
        try
        {
            UserEntity[] user = restTemplate.getForObject("http://jsonplaceholder.typicode.com/posts", UserEntity[].class);
            List<UserEntity> list;
            if (user != null)
            {
                list = new ArrayList<>(List.of(user));
                list.get(arrayIndex).setBody("1800 Flowers");
                list.get(arrayIndex).setTitle("1800 Flowers");
                return list;
            }
            else
            {
                throw new NullPointerException("user is null");
            }
        }
        catch (RuntimeException e)
        {
            throw new NullPointerException("Got a Runtime Exception");
        }
    }
}

