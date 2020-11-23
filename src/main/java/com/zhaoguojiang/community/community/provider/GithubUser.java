package com.zhaoguojiang.community.community.provider;

/**
 * @Author: xj0927
 * @Description:
 * @Date Created in 2020-11-23 17:49
 * @Modified By:
 */
public class GithubUser {
    private String name;
    private Long id;
    private String bio;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
