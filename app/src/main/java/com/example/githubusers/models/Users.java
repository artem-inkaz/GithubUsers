package com.example.githubusers.models;

import java.util.Objects;
// final значи класс меняться не будет
public final class Users {
    private String name;
    private String avatarUrl;

    public Users(String name, String avatarUrl) {
        this.name = name;
        this.avatarUrl = avatarUrl;
    }

    public String getName() {
        return name;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return name.equals(users.name) &&
                avatarUrl.equals(users.avatarUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, avatarUrl);
    }

    @Override
    public String toString() {
        return "Users{" +
                "name='" + name + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                '}';
    }
}
