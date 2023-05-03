package com.example.eventmanager.fetcher;


import com.netflix.graphql.dgs.*;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;



/**
 * @author: Christy Guo
 * @create_date: 2023-05-02 11:01 PM
 * @desc:
 * @modifier:
 */

@Slf4j
@DgsComponent
@RequiredArgsConstructor
public class EventDataFetcher {
  @DgsQuery
  public List<String> events() {
    return  Arrays.asList("reading books");
  }
}
