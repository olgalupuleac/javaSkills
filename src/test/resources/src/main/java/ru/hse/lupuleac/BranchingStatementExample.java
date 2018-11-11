package ru.hse.lupuleac;

public class BranchingStatementExample {
    public void exampleContinue() {
        int a = 6;
        for(int i = 0; i < 6; i++) {
            if (i % 2 == 0) {
                continue;
            }
            a++;
        }
    }

    public void exampleBreak() {
        int a = 6;
        for(int i = 0; i < 6; i++) {
            if (i == 4) {
                break;
            }
            a++;
        }
    }

    public void exampleReturn() {
        int a = 6;
        for(int i = 0; i < 6; i++) {
            if (i == 4) {
                return;
            }
            a++;
        }
    }

    public String toString() {
        return "a";
    }
}
