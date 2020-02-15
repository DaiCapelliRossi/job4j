package ru.job4j.tracker;

public class TestProfession {
    public static void main(String[] args) {
        Profession p = new Profession("Ivan", "Valuev", "Bachelor degree", "24.01.1985");
        Doctor doc = new Doctor("Sergey", "Krochev", "KMD", "20.07.1970", "Лечащий врач");
        Dentist d = new Dentist("Andrew", "White", "MD", "17.09.1990", "Стоматолог высшей степени");
        Surgeon s = new Surgeon("Anastasia", "Awesome", "MD", "26.07.1994", "Хирург", "Нейрохирург");
        Engineer e = new Engineer("Alex", "Black", "Masters's degree", "05.08.1993", 30);
        Programmer proger = new Programmer("Pavel", "Masik", "Specialist", "13.02.1993", 30, "Java");
        Builder b = new Builder("Vlad", "Cepesh", "No", "01.01.1400", 1);
        proger.personalInfo();
        proger.makeGame();
        s.personalInfo();
        Object patient = new Patient();
        s.heal(patient);
        s.operate();


    }
}
