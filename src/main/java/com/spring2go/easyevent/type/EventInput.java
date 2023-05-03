package com.spring2go.easyevent.type;

/**
 * @author: Christy Guo
 * @create_date: 2023-05-02 11:13 PM
 * @desc:
 * @modifier:
 */

import lombok.Data;

@Data
public class EventInput {
    private String title;
    private String description;
    private Float price;
    private String date;
}
