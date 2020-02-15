package ru.job4j.tracker;

public class Doctor extends Profession {
    String qualification;
    Diagnose diagnose = new Diagnose();

    public Doctor() {
    }

    public Doctor(String name, String surname, String education, String birthday, String qualification) {
        super(name, surname, education, birthday);
        this.qualification = qualification;
    }

    public String getQualification() {
        return qualification;
    }

    public void personalInfo() {
        System.out.println(name + " " + surname + ", DOB: " + birthday + ". Education: " + education + ". Qualification: " + qualification);
    }

    public Diagnose heal(Object patient) {
        System.out.println("Diagnose is Appendics");
        return diagnose;
    }
}