package com.ggz.model;

import com.sunnyd.Base;
import com.sunnyd.annotations.ActiveRecordField;

import java.util.Map;

public class Child extends Base
{
  public static final String tableName = "childs";

  @ActiveRecordField
  private String childName;

  public Child() { super(); }

  public Child(Map<String, Object> HM)
  {
    super(HM);
  }

  public String getChildName()
  {
    return childName;
  }

  public void setChildName(String childName)
  {
    this.childName = childName;
    setUpdateFlag(true);
  }
}
