package ru.hse.lupuleac;

import java.util.ArrayList;
import java.util.List;

public class AnonymousClassExample {
    interface HelloWorld {
        void greet();
        void greetSomeone(String someone);
    }

    class EnglishGreeting implements HelloWorld {
        String name = "world";
        public void greet() {
            greetSomeone("world");
        }
        public void greetSomeone(String someone) {
            name = someone;
            System.out.println("Hello " + name);
        }
    }

    HelloWorld spanishGreeting = new HelloWorld() {
        String name = "mundo";
        public void greet() {
            greetSomeone("mundo");
        }
        public void greetSomeone(String someone) {
            name = someone;
            System.out.println("Hola, " + name);
        }
    };

    public void french() {
         new HelloWorld() {
            String name = "tout le monde";
            public void greet() {
                greetSomeone("tout le monde");
            }
            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Salut " + name);
            }
        }.greet();
    }

    public void notAnonymous() {
        HelloWorld englishGreeting = new EnglishGreeting();
        List<String> list = new ArrayList<>();
    }
}
