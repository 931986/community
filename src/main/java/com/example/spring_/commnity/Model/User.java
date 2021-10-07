package com.example.spring_.commnity.Model;

import lombok.Data;

@Data
public class User {
    private  Integer id;
    private String name;
    private  String Token;

    private String accountId;
    private  Long gmtCreate;
    private  Long gmtModified;
    private String avatarUrl;
//    @Data自动生成get,set方法

//    public String getAccountId() {
//        return accountId;
//    }
//
//    public void setAccountId(String accountId) {
//        this.accountId = accountId;
//    }
//
//
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getToken() {
//        return Token;
//    }
//
//    public void setToken(String token) {
//        Token = token;
//    }
//
//    public Long getGmtCreate() {
//        return gmtCreate;
//    }
//
//    public void setGmtCreate(Long gmtCreate) {
//        this.gmtCreate = gmtCreate;
//    }
//
//    public Long getGmtModified() {
//        return gmtModified;
//    }
//
//    public void setGmtModified(Long gmtModified) {
//        this.gmtModified = gmtModified;
//    }
}
