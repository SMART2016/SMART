package com.smart.models;
// Generated Apr 25, 2016 10:55:45 AM by Hibernate Tools 5.0.0.CR1



/**
 * Members generated by hbm2java
 */
public class Members  implements java.io.Serializable {


     private Integer id;
     private String username;
     private String password;
     private String firstname;
     private String lastname;
     private String role;

    public Members() {
    }

	
    public Members(String password, String firstname, String lastname, String role) {
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.role = role;
    }
    public Members(String username, String password, String firstname, String lastname, String role) {
       this.username = username;
       this.password = password;
       this.firstname = firstname;
       this.lastname = lastname;
       this.role = role;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public String getFirstname() {
        return this.firstname;
    }
    
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return this.lastname;
    }
    
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getRole() {
        return this.role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }




}

