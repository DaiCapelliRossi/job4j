package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PassportOfficeTest {


    @Test
    public void add() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport()), is(citizen));
    }

    @Test
    public void dontAdd() {
        Citizen citizen = new Citizen("2f44a", "Vasya Petrov");
        Citizen citizen2 = new Citizen("2f44a", "Petya Vasechkin");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        office.add(citizen2);
        assertThat(office.get(citizen.getPassport()), is(citizen));
    }
}