
package org.launchcode.dismissal1.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity //Database creation//
public class User { //Database fields//
    //computer generated id
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min = 3, max = 20)
    private String username;

    @NotNull
    @Size(min = 3, max = 20)
    private String password;

    @NotNull
    @Size(min = 3, max = 20)
    private String email;

    //@OneToMany
    //@JoinColumn(name = "user_id")
    //private List<Student>students=new ArrayList<>();


    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public User() {
    }

    public int getId() {
        return id;
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

    public String getEmail(){return email;}
    public void setEmail(String email) {this.email=email;}

}