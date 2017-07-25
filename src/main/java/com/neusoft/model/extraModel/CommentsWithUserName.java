package com.neusoft.model.extraModel;

import com.neusoft.model.Comments;

import java.io.Serializable;

/**
 * Created by Bruce Lee on 2017/7/23.
 */
public class CommentsWithUserName extends Comments implements Serializable{
    public String userName;
    public String getUserName(){
        return userName;
    }
    public void setUserName(String userName){
        this.userName = userName;
    }
}
