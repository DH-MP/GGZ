package com.ggz.model;

import com.sunnyd.Base;
import com.sunnyd.annotations.ActiveRecordField;
import com.sunnyd.annotations.ActiveRelationHasMany;
import com.sunnyd.database.Manager;

import java.util.ArrayList;
import java.util.HashMap;

public class Peer extends Base
{
  public static final String tableName = "peers";
  @ActiveRecordField
  private String firstName;
  @ActiveRecordField
  private String lastName;
  @ActiveRecordField
  private String email;
  @ActiveRecordField
  private String userName;
  @ActiveRecordField
  private String password;
  @ActiveRecordField
  private Integer point;
  @ActiveRecordField
  private Integer rankId;
  @ActiveRecordField
  private String personalWebsite;

  public Peer()
  {
    super();
  }

  // TODO: We need to add a parameterized constructor here
  public Peer(HashMap<String, Object> HM)
  {
    super(HM);
  }

  public String getFirstName()
  {
    return firstName;
  }

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

  public String getEmail()
  {
    return email;
  }

  public void setEmail(String email)
  {
    this.email = email;
    setUpdateFlag(true);
  }

  public String getUserName()
  {
    return userName;
  }

  public void setUserName(String userName)
  {
    this.userName = userName;
    setUpdateFlag(true);
  }

  public String getPassword()
  {
    return password;
  }

  public void setPassword(String password)
  {
    this.password = password;
    setUpdateFlag(true);
  }

  public Integer getPoint()
  {
    return point;
  }

  public void setPoint(Integer point)
  {
    this.point = point;
    setUpdateFlag(true);
  }

  public Integer getRankId()
  {
    return rankId;
  }

  public void setRankId(Integer rankId)
  {
    this.rankId = rankId;
    setUpdateFlag(true);
  }

  public String getPersonalWebsite()
  {
    return personalWebsite;
  }

  public void setPersonalWebsite(String personalWebsite)
  {
    this.personalWebsite = personalWebsite;
    setUpdateFlag(true);
  }

    public static void main(String[] args) {
        /*Peer p = new Peer();
        p.setFirstName("wais");
        p.setUserName("wais");
        p.setPassword("khedri");
        System.out.println(p.save());
          */
        Peer p = Peer.find(1);
        System.out.println(p.getFirstName());
        System.out.println(p.getUserName());
    }

}
