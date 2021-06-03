package ru.job4j;

import java.util.*;

public class Pochta {

    public List<Userp> obrabotka(List<Userp> users) {
        Set<Userp> x = new LinkedHashSet<>();
        List<Integer> m = new ArrayList<>();
        Userp temp;
        for (int i = 0; i < users.size() - 1; i++) {
            if (!m.contains(i)) {
                temp = new Userp(users.get(i).getName());
                for (String s
                        : users.get(i).getAddress()) {
                    temp.getAddress().add(s);
                }
                for (int j = i + 1; j < users.size(); j++) {
                    if (i != j && !m.contains(j)) {
                        if (!Collections.disjoint(temp.getAddress(),
                                users.get(j).getAddress())) {
                            sliyanie(temp, users.get(j));
                            m.add(i);
                            m.add(j);
                            if (temp.getAddress().size() > users.get(j)
                                    .getAddress().size()) {
                                    x.add(temp);
                            } else {
                                x.add(users.get(j));
                            }
                        }
                    }
                }
            }
        }

        return new ArrayList<>(x);
    }

    public void sliyanie(Userp username1, Userp username2) {
        for (String s
                : username2.getAddress()) {
            username1.getAddress().add(s);
        }
    }
}
