package ru.job4j.tracker;

public class Dentist extends Doctor {
    public Dentist() {
    }

    public Dentist(String name, String surname, String education, String birthday, String qualification) {
    }

    public void personalInfo() {
        System.out.println(name + " " + surname + ", DOB: " + birthday + ". Education: " + education + ". Qualification: " + qualification);
    }

    public void cure() {
        System.out.println("Будем ставить пломбу... или все-таки коронку?");
    }
}