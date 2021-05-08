package ru.job4j.gc;

import static com.carrotsearch.sizeof.RamUsageEstimator.sizeOf;

public class GCUser {
    public static void main(String[] args) {
        EmptyUser user1 = new EmptyUser();
        User user2 = new User(2, "Наташа");
        User user3 = new User(3, "Марина");
        System.out.printf("size of user1 = %d\n", sizeOf(user1));
        System.out.printf("size of user2 = %d\n", sizeOf(user2));
        System.out.printf("size of user3 = %d\n", sizeOf(user3));
        System.out.printf("size of user2 + user3 = %d\n", sizeOf(user2) + sizeOf(user3));

        GCDemo.info();
        for (int i = 0; i < 10000; i++) {
            new User(i, "Name" + i);
        }
        GCDemo.info();
    }
}
