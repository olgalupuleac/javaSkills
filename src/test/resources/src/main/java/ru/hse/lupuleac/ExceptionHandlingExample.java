package ru.hse.lupuleac;

public class ExceptionHandlingExample {
    public void t() {
        try {
            System.out.print(9);
        } catch (Exception e) {

        }
    }

    public void b() {
        try {
            System.out.print(9);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
