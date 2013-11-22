package com.ggz.model;

import com.sunnyd.Base;
import com.sunnyd.annotations.ActiveRecordField;

import java.util.Map;

public class GrandChild extends Base
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
