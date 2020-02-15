package ru.job4j.tracker;

public class Builder extends Engineer {

    public Builder() {
    }

    public Builder(String name, String surname, String education, String birthday, int numOfProjects) {
    }

    public void personalInfo() {
        System.out.println(name + " " + surname + ", DOB: " + birthday + ". Education: " + education + ". Number of projects: " + numOfProjects);
    }

    public void makePlan() {
        System.out.println("Давайте быстренько набросаем чертеж и приступим строительству.");
    }
}
