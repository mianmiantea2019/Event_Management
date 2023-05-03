package com.spring2go.easyevent.entity;

/**
 * @author: Christy Guo
 * @create_date: 2023-05-02 11:20 PM
 * @desc:
 * @modifier:
 */

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.spring2go.easyevent.type.UserInput;
import lombok.Data;

@Data
@TableName(value = "tb_user")
public class UserEntity {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String email;
    private String password;

    public UserEntity fromUserInput(UserInput userInput) {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(userInput.getEmail());
        userEntity.setPassword(userInput.getPassword());
        return userEntity;
    }
}
