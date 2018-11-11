package ru.hse.lupuleac;

import org.jetbrains.annotations.NotNull;

public class AnnotationExample {
    @NotNull
    public String a() {
        return "a";
    }

    public void b(@NotNull String s){}
}