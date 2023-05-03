package com.spring2go.easyevent.mapper;

/**
 * @author: Christy Guo
 * @create_date: 2023-05-02 11:46 PM
 * @desc:
 * @modifier:
 */

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.spring2go.easyevent.entity.BookingEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookingEntityMapper extends BaseMapper<BookingEntity> {
}
