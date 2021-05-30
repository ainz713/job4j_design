package ru.job4j;

import java.util.List;
import java.util.Set;

public class Pochta {

    public List<Userp> obrabotka(List<Userp> users) {
        for (int i = 0; i < users.size(); i++) {
            Set<String> rsl = users.get(i).getAddress();
            for (int j = 0; j < users.size() - 1; j++) {
                if (users.get(i).equals(users.get(j + 1))) {
                    continue;
                }
                for (String s
                        : users.get(j + 1).getAddress()) {
                    if (rsl.contains(s)) {
                        sliyanie(users.get(i), users.get(j + 1));
                        if (users.get(i).getAddress().size() > users.get(j + 1)
                                .getAddress().size()) {
                            users.remove(users.get(j + 1));
                        } else {
                            users.remove(users.get(i));
                        }
                        break;
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
