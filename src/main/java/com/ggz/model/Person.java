package com.ggz.model;

import com.sunnyd.Base;
import com.sunnyd.annotations.ActiveRecordField;

import java.util.Map;

public class Person extends Base
{
  public static final String tableName = "persons";
  @ActiveRecordField
  private String firstName;
  @ActiveRecordField
  private String lastName;

  public Person() { super(); }

  public Person(Map<String, Object> HM) { super(HM); }

  public String getFirstName() { return firstName; }

  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
    setUpdateFlag(true);
  }

  public String getLastName()
  {
    return lastName;
  }

  public void setLastName(String lastName)
  {
    this.lastName = lastName;
    setUpdateFlag(true);
  }

  @Override
  public boolean save()
  {
    if (firstName != null && firstName.isEmpty())
      return false;
    return super.save();
  }


}
