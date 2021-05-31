package ru.job4j;

import java.util.Collections;
import java.util.List;

public class Pochta {

    public List<Userp> obrabotka(List<Userp> users) {
        for (int i = 0; i < users.size() - 1; i++) {
            for (int j = i + 1; j < users.size(); j++) {
                if (i != j) {
                    if (!Collections.disjoint(users.get(i).getAddress(),
                            users.get(j).getAddress())) {
                        sliyanie(users.get(i), users.get(j));
                        if (users.get(i).getAddress().size() > users.get(j)
                                .getAddress().size()) {
                            users.remove(users.get(j));
                        } else {
                            users.remove(users.get(i));
                        }
                    }
                }
            }
        }
        return users;
    }

    public void sliyanie(Userp username1, Userp username2) {
        for (String s
                :username2.getAddress()) {
            username1.getAddress().add(s);
        }
    }
}
