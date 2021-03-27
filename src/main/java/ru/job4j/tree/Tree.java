package ru.job4j.tree;

import java.util.*;
import java.util.function.Predicate;

class Tree<E> implements SimpleTree<E> {
    private final Node<E> root;

    public Tree(final E root) {
        this.root = new Node<>(root);
    }

    private Optional<Node<E>> findByPredicate(Predicate<Node<E>> condition) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (condition.test(el)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.getChildren());
        }
        return rsl;
    }

    public boolean isBinary() {
        Predicate<Node<E>> pred = f -> f.getChildren().size() > 2;
        return findByPredicate(pred).isEmpty();
    }

    @Override
    public boolean add(E parent, E child) {
        boolean rsl = false;
        Optional<Node<E>> el = findBy(parent);
        if (findBy(parent).isPresent() && findBy(child) != child) {
            Node<E> parentNode = el.get();
            Node<E> childNode = new Node<>(child);
            parentNode.getChildren().add(childNode);
        }
        return rsl;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
            Predicate<Node<E>> pred = f -> f.getValue().equals(value);

        return findByPredicate(pred);
    }
}
