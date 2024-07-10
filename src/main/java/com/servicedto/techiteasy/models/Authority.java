package com.servicedto.techiteasy.models;

import jakarta.persistence.*;

import java.io.Serializable;

/*TODO annotatie*/
@Entity
@IdClass(AuthorityKey.class)
@Table(name = "authorities")
public class Authority implements Serializable {

    // We noemen deze klasse "Authority", maar je mag het ook "Roles" of "Bananas" noemen, zolang je dat maar overal doet waar deze klasse gebruikt wordt.


    @Id
    @Column(nullable = false)
    private String username;

    @Id
    @Column(nullable = false)
    private String authority;

    public Authority() {}
    public Authority(String username, String authority) {
        this.username = username;
        this.authority = authority;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getAuthority() {
        return authority;
    }
    public void setAuthority(String authority) {
        this.authority = authority;
    }

}