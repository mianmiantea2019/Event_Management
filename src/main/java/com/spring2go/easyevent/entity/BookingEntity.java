package com.spring2go.easyevent.entity;

/**
 * @author: Christy Guo
 * @create_date: 2023-05-02 11:21 PM
 * @desc:
 * @modifier:
 */

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "tb_booking")
public class BookingEntity {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer userId;
    private Integer eventId;
    private Date createdAt;
    private Date updatedAt;
}
