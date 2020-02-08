package ru.job4j.tracker;

public class Surgeon extends Doctor {
    String specification;

    public Surgeon() {
    }

    public Surgeon(String name, String surname, String education, String birthday, String qualification, String specification) {
        super(name, surname, education, birthday, qualification);
        this.specification = specification;
    }

    public String getSpecification() {
        return specification;
    }

    public void personalInfo() {
        System.out.println(name + " " + surname + ", DOB: " + birthday + ". Education: " + education + ". Qualification: " + qualification + ", specification: " + specification);
    }

    public void operate() {
        System.out.println("Скальпель, зажим, тампон, зашиваем.");
    }
}
