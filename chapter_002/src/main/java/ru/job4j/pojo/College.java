package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFamilyName("Ostroumova");
        student.setGroup("135");
        student.setAccepted("01.09.2011");

        System.out.println(student.getFamilyName() + " was accepted in Group " + student.getGroup() + " on " + student.getAccepted());
    }
}
