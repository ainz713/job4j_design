package ru.job4j;

import java.util.List;
import java.util.Objects;

public class Analize {

    public static Info diff(List<User> previous, List<User> current) {
        Info info = new Info();
        if (previous.size() > current.size()) {
            info.deleted = previous.size() - current.size();
        } else if (previous.size() < current.size()) {
            info.added = current.size() - previous.size();
        } else {

            for (int i = 0; i < current.size(); i++) {
                if (!current.get(i).equals(previous.get(i))) {
                    info.changed++;
                }
            }
        }
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
            return Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
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