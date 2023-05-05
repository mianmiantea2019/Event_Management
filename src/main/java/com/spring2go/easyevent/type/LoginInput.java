/*
 * @Author: mianmiantea2019
 * @Date: 2023-05-05 00:24:44
 * @LastEditors: mianmiantea2019
 * @LastEditTime: 2023-05-05 00:26:35
 * @Description: 
 */
package com.spring2go.easyevent.type;

/**
 * @author: Christy Guo
 * @create_date: 2023-05-05 11:13 PM
 * @desc:
 * @modifier:
 */


import lombok.Data;
@Data
public class LoginInput {
    private String email;
    private String password;
}
