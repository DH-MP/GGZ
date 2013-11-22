package com.ggz.model;

import com.sunnyd.Base;
import com.sunnyd.annotations.ActiveRecordField;
import com.sunnyd.annotations.ActiveRecordInheritFrom;

import java.util.Map;

@ActiveRecordInheritFrom(childClassof = "Child")
public class GrandChild extends Child
{
  public static final String tableName = "grand_childs";

  @ActiveRecordField
  private String grandChildName;

  public GrandChild()
  {
    super();
  }

  public GrandChild(Map<String, Object> HM)
  {
    super(HM);
  }

  public String getGrandChildName()
  {
    return grandChildName;
  }

  public void setGrandChildName(String grandChildName)
  {
    this.grandChildName = grandChildName;
    setUpdateFlag(true);
  }
}
