package ru.job4j.pojo;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class LicenseTest {

    @Test
    public void eqName() {
        License first = new License();
        first.setCode("audio");
        first.setOwner("Ness");
        License second = new License();
        second.setCode("audio");
        second.setOwner("Ness");
        assertThat(first, is(second));
    }
}