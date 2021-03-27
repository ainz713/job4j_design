package ru.job4j.collection.map;

import java.util.*;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return children == user.children
                && Objects.equals(name, user.name)
                && Objects.equals(birthday, user.birthday);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (Objects.equals(name, null) ? 0 : name.hashCode());
        result = 31 * result + Integer.hashCode(children);
        result = 31 * result + (Objects.equals(birthday, null) ? 0 : birthday.hashCode());
        return result;
    }

    public static void main(String[] args) {
        User user1 = new User("Imya1", 1,
                new GregorianCalendar(2017, Calendar.JANUARY, 25));
        User user2 = new User("Imya1", 1,
                new GregorianCalendar(2017, Calendar.JANUARY, 25));
        Map<User, Object> map = new HashMap<>();
        map.put(user1, new Object());
        map.put(user2, new Object());
        System.out.println(map);
    }
   // {ru.job4j.collection.map.User@2f4d3709=java.lang.Object@1d81eb93,
    //        ru.job4j.collection.map.User@4e50df2e=java.lang.Object@7291c18f}

   //{ru.job4j.collection.map.User@98e13977=java.lang.Object@2f4d3709,
           //ru.job4j.collection.map.User@98e13977=java.lang.Object@4e50df2e}

    // {ru.job4j.collection.map.User@2f4d3709=java.lang.Object@1d81eb93,
    // ru.job4j.collection.map.User@4e50df2e=java.lang.Object@7291c18f}

    //{ru.job4j.collection.map.User@98e13977=java.lang.Object@2f4d3709}
}
