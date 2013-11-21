package com.ggz.model.activejdbc;

/**
 * Created with IntelliJ IDEA.
 * User: Wais
 * Date: 11/20/13
 * Time: 7:40 PM
 * To change this template use File | Settings | File Templates.
 */
import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.Table;
import javax.persistence.*;
import java.util.*;

public class User extends Model {
    private User u;

    public User() {}

    public User(Model u)
    {
        this.u = (User)u;
    }

    public String getFirstName() {
        return u.getString("first_name");
    }

    public void setFirstName(String firstName) {
        set("first_name",firstName);

    }

    public String getLastName() {
        return u.getString("last_name");
    }

    public void setLastName(String lastName) {
        set("last_name",lastName);
    }

    public String getPassword() {
        return u.getString("password");
    }

    public void setPassword(String password) {
        set("password",password);
    }

    public String getAddress() {
        return u.getString("address");
    }

    public void setAddress(String address) {
        set("address",address);
    }

    public String getUserName() {
        return u.getString("user_name");
    }

    public void setUserName(String userName) {
        set("user_name",userName);
    }
}
