package com.ggz.controller;

import org.testng.annotations.Test;

public class CrawlerTest
{
  @Test
  public void searchTest()
  {
    Crawler.search("mario");
  }
}
