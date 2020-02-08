package ru.job4j.tracker;

public class Profession {
    String name;
    String surname;
    String education;
    String birthday;

    public Profession() {
    }

    public Profession(String name, String surname, String education, String birthday) {
        this.name = name;
        this.surname = surname;
        this.education = education;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEducation() {
        return education;
    }

    public String getBirthday() {
        return birthday;
    }

    public void personalInfo() {
        System.out.println(name + surname + ", dob: " + birthday + ", education: " + education);
    }


}

