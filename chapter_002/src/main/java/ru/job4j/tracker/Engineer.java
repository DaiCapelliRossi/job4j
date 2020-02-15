package ru.job4j.tracker;

public class Engineer extends Profession {
    int numOfProjects;

    public Engineer() {
    }

    public Engineer(String name, String surname, String education, String birthday, int numOfProjects) {
        super(name, surname, education, birthday);
        this.numOfProjects = numOfProjects;
    }

    public void personalInfo() {
        System.out.println(name + " " + surname + ", DOB: " + birthday + ". Education: " + education + ". Number of projects: " + numOfProjects);
    }

    public int getNumberOfProjects() {
        return numOfProjects;
    }
}
