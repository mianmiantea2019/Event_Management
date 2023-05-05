package com.spring2go.easyevent.custom;

/**
 * @author: Christy Guo
 * @create_date: 2023-05-03 12:07 AM
 * @desc:
 * @modifier:
 */

 import com.spring2go.easyevent.entity.UserEntity;
 import lombok.Data;
 
 @Data
 public class AuthContext {
     private UserEntity userEntity;
     private boolean tokenInvalid;
 
     public void ensureAuthenticated() {
         if (tokenInvalid) throw new RuntimeException("invalid token！");
         if (userEntity == null) throw new RuntimeException("please login in！");
     }
 }
 