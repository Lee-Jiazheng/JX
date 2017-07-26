package com.neusoft.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bruce Lee on 2017/7/25.
 */
public class testFileTest {
    @Test
    public void main()  {

        List<User> users = new ArrayList<>();
        User user = new User();
        user.setUserphoto("asdfasdf");
        users.add(user);
        String s = String.valueOf(users);
        System.out.println(s);
    }

}