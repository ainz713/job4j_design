package ru.job4j;

import java.util.HashSet;
import java.util.Set;

public class Userp {

    private String name;
    private Set<String> address;

    public Userp(String name) {
        this.name = name;
        this.address = new HashSet<>();
    }

    public boolean add(String email) {
        return address.add(email);
    }

    public Set<String> getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Userp{"
                + "address=" + address
                + '}';
    }
}
