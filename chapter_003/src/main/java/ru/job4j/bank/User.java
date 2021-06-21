package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс - модель пользователя
 * Хранит данные о паспорте и имени
 * @author ANASTASIA OSTROUMOVA
 * @version 1.0
 */


public class User {
    private String passport;
    private String username;

    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Сравнение пользователей осуществляется по полю паспорт
     * @param o принимает объект класса Objects
     * @return true, если реквизиты равны
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}