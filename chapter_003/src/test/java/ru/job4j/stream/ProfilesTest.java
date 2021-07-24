package ru.job4j.stream;

import org.junit.Test;
import ru.job4j.search.Person;
import ru.job4j.search.PhoneDictionary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfilesTest {
    @Test
    public void whenCollect() {
        List<Profile> profile = new ArrayList<>();
        profile.add(new Profile(new Address("Moscow", "Arbat str.", 17, 29)));
        profile.add(new Profile(new Address("St.Petersburg", "Nevskiy pr.", 27, 129)));
        profile.add(new Profile(new Address("Ekaterinburg", "Lenina str.", 9, 85)));
        profile.add(new Profile(new Address("Ekaterinburg", "Lenina str.", 9, 85)));
        Profiles profiles = new Profiles();
        List<Address> addresses = profiles.collect(profile);
        List<Address> expected = new ArrayList<>();
        expected.add(new Address("Ekaterinburg", "Lenina str.", 9, 85));
        expected.add(new Address("Moscow", "Arbat str.", 17, 29));
        expected.add(new Address("St.Petersburg", "Nevskiy pr.", 27, 129));


        assertThat(addresses, is(expected));
    }

}