package ru.job4j.tracker;


public class Programmer extends Engineer {
    String programmingLanguage;

    public Programmer() {
    }

    public Programmer(String name, String surname, String education, String birthday, int numOfProjects, String programmingLanguage) {
        super(name, surname, education, birthday, numOfProjects);
        this.programmingLanguage = programmingLanguage;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void personalInfo() {
        System.out.println(name + " " + surname + ", DOB: " + birthday + ". Education: " + education + ". Programming language: " + programmingLanguage + ", number of projects: " + numOfProjects);
    }

    public void makeGame() {
        System.out.println("Я стал программистом, чтобы создать игру своей мечты.");
    }
}
