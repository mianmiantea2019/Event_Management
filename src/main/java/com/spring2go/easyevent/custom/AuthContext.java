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
        if (tokenInvalid) throw new RuntimeException("令牌无效！");
        if (userEntity == null) throw new RuntimeException("未登陆，请先登陆！");
    }
}
