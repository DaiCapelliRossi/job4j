package ru.job4j.stream;

import java.util.*;

public class Address implements Comparable<Address> {
    private String city;

    private String street;

    private int home;

    private int apartment;

    public Address(String city, String street, int home, int apartment) {
        this.city = city;
        this.street = street;
        this.home = home;
        this.apartment = apartment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Address address = (Address) o;
        return home == address.home
                && apartment == address.apartment
                && Objects.equals(city, address.city)
                && Objects.equals(street, address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, home, apartment);
    }

    @Override
    public int compareTo(Address o) {
        return city.compareTo(o.city);
    }

    public static void main(String[] args) {
        List<Address> addresses = new ArrayList<>();
        addresses.add(new Address("Moscow", "Arbat str.", 17, 29));
        addresses.add(new Address("St.Petersburg", "Nevskiy pr.", 27, 129));
        addresses.add(new Address("Ekaterinburg", "Lenina str.", 9, 85));
        Collections.sort(addresses);
        for (Address a : addresses) {
            System.out.println(a.city);
        }
    }
}