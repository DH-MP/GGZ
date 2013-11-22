package com.ggz.model;

import com.sunnyd.Base;
import com.sunnyd.annotations.ActiveRecordField;
import com.sunnyd.annotations.ActiveRecordInheritFrom;

import java.util.Map;

@ActiveRecordInheritFrom(childClassof = "Person")
public class Child extends Person
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
