package ru.job4j;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PochtaTest {
    private List<Userp> st;

    @Test
    public void proverka() {
        Pochta p = new Pochta();
        Userp u1 = new Userp("user1");
        u1.add("xxx@ya.ru");
        u1.add("foo@gmail.com");
        u1.add("lol@mail.ru");
        Userp u2 = new Userp("user2");
        u2.add("foo@gmail.com");
        u2.add("ups@pisem.net");
        Userp u3 = new Userp("user3");
        u3.add("xyz@pisem.net");
        u3.add("vasya@pupkin.com");
        Userp u4 = new Userp("user4");
        u4.add("ups@pisem.net");
        u4.add("aaa@bbb.com");
        Userp u5 = new Userp("user5");
        u5.add("xyz@pisem.net");
        List<Userp> gg = new ArrayList<>();
        gg.add(u1);
        gg.add(u2);
        gg.add(u3);
        gg.add(u4);
        gg.add(u5);
        st = p.obrabotka(gg);
        assertTrue(st.get(1).getAddress().toString().contains("ups@pisem.net,"
                + " lol@mail.ru, xxx@ya.ru, aaa@bbb.com, foo@gmail.com"));
        assertTrue(st.get(0).getAddress().toString().contains("vasya@pupkin.com, xyz@pisem.net"));
    }

    @Test
    public void proverka2() {
        Pochta p = new Pochta();
        Userp u1 = new Userp("user1");
        u1.add("xxx@ya.ru");
        u1.add("foo@gmail.com");
        u1.add("lol@mail.ru");
        Userp u2 = new Userp("user2");
        u2.add("foo@gmail.com");
        u2.add("ups@pisem.net");
        u2.add("345s@pisem.net");
        u2.add("1231@pisem.net");
        u2.add("123123@pisem.net");
        Userp u3 = new Userp("user3");
        u3.add("xyz@pisem.net");
        u3.add("vasya@pupkin.com");
        Userp u4 = new Userp("user4");
        u4.add("ups@pisem.net");
        u4.add("aaa@bbb.com");
        Userp u5 = new Userp("user5");
        u5.add("xyz@pisem.net");
        u5.add("xyz2423@pisem.net");
        u5.add("xyz111@pisem.net");
        List<Userp> gg = new ArrayList<>();
        gg.add(u1);
        gg.add(u2);
        gg.add(u3);
        gg.add(u4);
        gg.add(u5);
        st = p.obrabotka(gg);
        assertTrue(st.get(1).getAddress().toString().contains("123123@pisem.net, ups@pisem.net,"
                + " 345s@pisem.net, lol@mail.ru, xxx@ya.ru,"
                + " 1231@pisem.net, aaa@bbb.com, foo@gmail.com"));
        assertTrue(st.get(0).getAddress().toString().contains("xyz2423@pisem.net, vasya@pupkin.com,"
                + " xyz@pisem.net, xyz111@pisem.net"));
    }
}