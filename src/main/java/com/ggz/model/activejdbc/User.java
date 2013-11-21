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

@Entity
@javax.persistence.Table(name = "users")
public class User extends Model {

    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="email")
    private String email;
    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;
    @Column(name="address")
    private String address;

    private User u;

    public User() {}

    public User(Model u)
    {
        this.u = (User)u;
    }

    public String getFirstName() {
        return u.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
