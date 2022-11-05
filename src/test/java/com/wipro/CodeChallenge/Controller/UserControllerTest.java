package com.wipro.CodeChallenge.Controller;

import com.wipro.CodeChallenge.Entity.UserEntity;
import com.wipro.CodeChallenge.Service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @InjectMocks
    UserController controller;

    @Mock
    UserService service;

    @Test
    void userIdCount()
    {
        UserEntity user=new UserEntity();
        List<UserEntity> list = new ArrayList<>(List.of(user));
        UserEntity user1=new UserEntity();
        user1.setId(1);
        user1.setUserId(1);
        user1.setTitle("1800 Flowers");
        user1.setBody("1800 Flowers");
        list.add(user1);
        assertNotNull(list);
        assertEquals(1,list.get(1).getUserId());
        assertEquals(1,list.get(1).getId());
        assertEquals("1800 Flowers",list.get(1).getTitle());
        assertEquals("1800 Flowers",list.get(1).getBody());
        Map<Integer, List<UserEntity>> userIdMap = list.stream().collect(Collectors.groupingBy(UserEntity::getUserId));
        Map<String, Integer> resultMap = new HashMap<>();
        userIdMap.forEach((key, value) -> resultMap.put("userId " + key, value.size()));
        Mockito.when(service.userIdCount()).thenReturn(resultMap);
        assertNotNull(controller.userIdCount());
    }

    @Test
    void userIdCount_RuntimeException_test(){
        Mockito.when(service.userIdCount()).thenThrow(new RuntimeException("Got a Run Time exception"));
        assertThrows(RuntimeException.class,()->controller.userIdCount());
    }

    @Test
    void userIdCount_NullPointerException_test(){
        Mockito.when(service.userIdCount()).thenThrow(new NullPointerException("User not found"));
        assertThrows(NullPointerException.class,()->controller.userIdCount());
    }

    @Test
    void updatedUserList_test() {
        UserEntity user=new UserEntity();
        List<UserEntity> list = new ArrayList<>(List.of(user));
        UserEntity user1=new UserEntity();
        user1.setId(1);
        user1.setUserId(1);
        user1.setTitle("1800 Flowers");
        user1.setBody("1800 Flowers");
        list.add(user1);
        assertNotNull(list);
        Mockito.when(service.changedData()).thenReturn(list);
        assertNotNull(controller.updatedUserList());
    }

    @Test
    void updatedUserList_RuntimeException_test()
    {
        Mockito.when(service.changedData()).thenThrow(new RuntimeException("Got a Run Time exception"));
        assertThrows(RuntimeException.class,()->controller.updatedUserList());
    }

    @Test
    void updatedUserList_NullPointerException_test()
    {
        Mockito.when(service.changedData()).thenThrow(new NullPointerException("User not found"));
        assertThrows(NullPointerException.class,()-> controller.updatedUserList());
    }

    @Test
    void updatedUserList_param()
    {
        UserEntity user=new UserEntity();
        List<UserEntity> list = new ArrayList<>(List.of(user));
        UserEntity user1=new UserEntity();
        user1.setId(1);
        user1.setUserId(1);
        user1.setTitle("1800 Flowers");
        user1.setBody("1800 Flowers");
        list.add(user1);
        assertNotNull(list);
        Mockito.when(service.changedData_param(Mockito.anyInt())).thenReturn(list);
        assertNotNull(controller.updatedUserList_param(1));
    }

    @Test
    void updatedUserList_param_NullPointerException_test()
    {
        Mockito.when(service.changedData_param(Mockito.anyInt())).thenThrow(new NullPointerException("User not found"));
        assertThrows(NullPointerException.class,()->controller.updatedUserList_param(1));
    }

    @Test
    void updatedUserList_param_RuntimeException_test() {
        Mockito.when(service.changedData_param(Mockito.anyInt())).thenThrow(new RuntimeException("Got a Run Time exception"));
        assertThrows(RuntimeException.class,()->controller.updatedUserList_param(1));
    }
}