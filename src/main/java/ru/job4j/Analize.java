package ru.job4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Analize {

    public static Info diff(List<User> previous, List<User> current) {
        Info info = new Info();

        Map<Integer, User> diffMap = new HashMap<>();

        for (User c : current) {
            diffMap.put(c.getId(), c);
        }

        for (User p : previous) {
            if (!diffMap.containsKey(p.getId())) {
                info.deleted++;
            } else if (!diffMap.get(p.getId()).equals(p)) {
                info.changed++;
            }
        }

        info.added = current.size() - previous.size() + info.deleted;
        return info;
    }

    public static class User {
       private int id;
       private String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
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
            return id == user.id
                    && Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{"
                    + "name='"
                    + name
                    + '\''
                    + '}';
        }
    }

    public static class Info {

       private int added = 0;
       private int changed = 0;

       private int deleted = 0;

        public int getAdded() {
            return added;
        }

        public void setAdded(int added) {
            this.added = added;
        }

        public int getChanged() {
            return changed;
        }

        public void setChanged(int changed) {
            this.changed = changed;
        }

        public int getDeleted() {
            return deleted;
        }

        public void setDeleted(int deleted) {
            this.deleted = deleted;
        }

        @Override
        public String toString() {
            return "Info{"
                    + "added="
                    + added
                    + ", changed="
                    + changed
                    + ", deleted="
                    + deleted
                    + '}';
        }
    }

}