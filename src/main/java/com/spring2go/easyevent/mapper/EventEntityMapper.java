package com.spring2go.easyevent.mapper;

/**
 * @author: Christy Guo
 * @create_date: 2023-05-02 11:45 PM
 * @desc:
 * @modifier:
 */


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.spring2go.easyevent.entity.EventEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EventEntityMapper extends BaseMapper<EventEntity> {
}
