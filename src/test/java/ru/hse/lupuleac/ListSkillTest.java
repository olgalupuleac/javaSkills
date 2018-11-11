package ru.hse.lupuleac;

import org.junit.Test;

import static org.junit.Assert.*;

public class ListSkillTest {

    @Test
    public void visit() throws Exception {
        assertEquals(8, SkillCalculator.getScore(new ListSkill(), "src/test/resources/src/main/java/ru/hse/lupuleac/ListExample.java",
                "src/test/resources/src/main/java/ru/hse/lupuleac"));
    }
}