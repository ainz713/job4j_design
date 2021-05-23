package ru.job4j.lsp;

public class DumbDog extends Dog {

        @Override
        public void makeNoise() {
            throw new RuntimeException("I can't make noise");
        }
}
