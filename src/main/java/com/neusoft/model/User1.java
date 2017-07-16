package com.neusoft.model;


import java.util.Date;

public class User1 {

    private int id;

    private String username;

    private String nickname;

    private String password;

    private String email;

    private String headurl;

    private String bulletin;

    private String enabled;

    private String spacename;

    private String spaceintro;

    private String sign;

    private String customcss;

    private int articlelistsize;

    private int photolistsize;

    private int amount;

    private int visitcount;

    private Date createtime;


    public int getId() {
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname){
        this.nickname = nickname;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getHeadurl() {
        return headurl;
    }
    public void setHeadurl(String headurl){
        this.headurl = headurl;
    }
    public String getBulletin() {
        return bulletin;
    }
    public void setBulletin(String bulletin){
        this.bulletin = bulletin;
    }
    public String getEnabled() {
        return enabled;
    }
    public void setEnabled(String enabled){
        this.enabled = enabled;
    }
    public String getSpacename() {
        return spacename;
    }
    public void setSpacename(String spacename){
        this.spacename = spacename;
    }
    public String getSpaceintro() {
        return spaceintro;
    }
    public void setSpaceintro(String spaceintro){
        this.spaceintro = spaceintro;
    }
    public String getSign() {
        return sign;
    }
    public void setSign(String sign){
        this.sign = sign;
    }
    public String getCustomcss() {
        return customcss;
    }
    public void setCustomcss(String customcss){
        this.customcss = customcss;
    }
    public int getArticlelistsize() {
        return articlelistsize;
    }
    public void setArticlelistsize(int articlelistsize){
        this.articlelistsize = articlelistsize;
    }
    public int getPhotolistsize() {
        return photolistsize;
    }
    public void setPhotolistsize(int photolistsize){
        this.photolistsize = photolistsize;
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount){
        this.amount = amount;
    }
    public int getVisitcount() {
        return visitcount;
    }
    public void setVisitcount(int visitcount){
        this.visitcount = visitcount;
    }
    public Date getCreatetime() {
        return createtime;
    }
    public void setCreatetime(Date createtime){
        this.createtime = createtime;
    }
}
