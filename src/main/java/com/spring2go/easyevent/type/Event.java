package com.spring2go.easyevent.type;

import lombok.Data;
/**
 * @author: Christy Guo
 * @create_date: 2023-05-02 11:12 PM
 * @desc:
 * @modifier:
 */


@Data
public class Event {
  private String id;
  private String title;
  private String description;
  private Float price;
  private String date;
  private Integer creatorId;
  private User creator;

}
